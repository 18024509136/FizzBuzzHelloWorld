package com.hxd.fizzbuzz.rule.impl;

import com.hxd.fizzbuzz.matcher.Matcher;
import com.hxd.fizzbuzz.rule.Rule;

/**
 * 简单的且关系转换规则器
 *
 * @author hxd
 * @since 2019/3/21
 */
public class SimpleAndRule implements Rule {

    private Matcher[] matchers;

    private String result;

    /**
     * @param result   转换字样
     * @param matchers 多个匹配器
     */
    public SimpleAndRule(String result, Matcher... matchers) {
        this.matchers = matchers;
        this.result = result;
    }

    public String ruleCheck(int number) {
        if (matchers[0].match(number) && matchers[1].match(number)) {
            return this.result;
        } else {
            return null;
        }
    }
}
