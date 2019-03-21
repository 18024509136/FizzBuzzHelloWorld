package com.hxd.fizzbuzz.rule.impl;

import com.hxd.fizzbuzz.rule.Rule;

/**
 * 复杂的且关系转换规则器
 *
 * @author hxd
 * @since 2019/3/21
 */
public class ComplicateAndRule implements Rule {

    private Rule[] innerRules;

    /**
     * @param innerRules 多个转换规则器
     */
    public ComplicateAndRule(Rule... innerRules) {
        this.innerRules = innerRules;
    }

    public String ruleCheck(int number) {
        String result = null;
        for (Rule rule : innerRules) {
            result = rule.ruleCheck(number);
            if (result == null) {
                return null;
            }
        }
        return result;
    }
}
