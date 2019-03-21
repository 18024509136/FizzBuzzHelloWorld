package com.hxd.fizzbuzz.rule.impl;

import com.hxd.fizzbuzz.matcher.Matcher;
import com.hxd.fizzbuzz.rule.Rule;

/**
 * 只支持单个匹配器的简单转换规则器
 *
 * @author hxd
 * @since 2019/3/21
 */
public class SimpleRule implements Rule {

    private Matcher matcher;

    private String result;

    public SimpleRule() {

    }

    /**
     * @param matcher 转换字样
     * @param result  多个匹配器
     */
    public SimpleRule(Matcher matcher, String result) {
        this.matcher = matcher;
        this.result = result;
    }

    public String ruleCheck(int number) {
        return matcher.match(number) ? result : null;
    }
}
