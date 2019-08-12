package com.hxd.fizzbuzz.test;

import com.hxd.fizzbuzz.build.FizzBuzzRunner;
import com.hxd.fizzbuzz.manager.RuleManager;
import com.hxd.fizzbuzz.matcher.Matcher;
import com.hxd.fizzbuzz.matcher.impl.LiteralContainMatcher;
import com.hxd.fizzbuzz.matcher.impl.TotallyModMatcher;
import com.hxd.fizzbuzz.rule.impl.ComplicateAndRule;
import com.hxd.fizzbuzz.rule.impl.SimpleAndRule;
import com.hxd.fizzbuzz.rule.impl.SimpleOrRule;
import com.hxd.fizzbuzz.rule.impl.SimpleRule;
import org.junit.Test;

/**
 * @author hxd
 * @since 2019/8/12
 */
public class FizzBuzzTest {

    /**
     * 当整除3输出Fizz，当整除5输出Buzz，当同时整除3和5输出FizzBuzz，默认输出数字原样
     */
    @Test
    public void requirement1Test() {
        Matcher modMatcher1 = new TotallyModMatcher(3);
        Matcher modMatcher2 = new TotallyModMatcher(5);
        SimpleRule simpleRule1 = new SimpleRule(modMatcher1, "Fizz");
        SimpleRule simpleRule2 = new SimpleRule(modMatcher2, "Buzz");

        SimpleAndRule simpleAndRule1 = new SimpleAndRule("FizzBuzz", modMatcher1, modMatcher2);

        RuleManager ruleManager = new RuleManager(simpleAndRule1, simpleRule1, simpleRule2);

        new FizzBuzzRunner(ruleManager, 1, 100).run();
    }

    /**
     * 当整除3或有3字样的时候输出Fizz
     * 当整除5或有5的字样的时候输出Buzz
     * 当 整除3或者5 且 有3或者5的字样 的时候输出 FizzBuzz
     * (原需求第三点的规则感觉有点问题，两大规则间的关系不应该为or,否则单个Fizz和Buzz都被FizzBuzz全部覆盖了)
     */
    @Test
    public void requirement2Test() {
        Matcher modMatcher1 = new TotallyModMatcher(3);
        Matcher modMatcher2 = new TotallyModMatcher(5);
        Matcher literalContainMatcher1 = new LiteralContainMatcher("3");
        Matcher literalContainMatcher2 = new LiteralContainMatcher("5");

        SimpleOrRule simpleOrRule1 = new SimpleOrRule("Fizz", modMatcher1, literalContainMatcher1);
        SimpleOrRule simpleOrRule2 = new SimpleOrRule("Buzz", modMatcher2, literalContainMatcher2);
        SimpleOrRule simpleOrRule3 = new SimpleOrRule("FizzBuzz", modMatcher1, modMatcher2);
        SimpleOrRule simpleOrRule4 = new SimpleOrRule("FizzBuzz", literalContainMatcher1, literalContainMatcher2);
        ComplicateAndRule complicateOrRule = new ComplicateAndRule(simpleOrRule3, simpleOrRule4);

        RuleManager ruleManager = new RuleManager(complicateOrRule, simpleOrRule1, simpleOrRule2);

        new FizzBuzzRunner(ruleManager, 1, 100).run();
    }

}
