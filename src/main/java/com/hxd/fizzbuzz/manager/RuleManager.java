package com.hxd.fizzbuzz.manager;

import com.hxd.fizzbuzz.rule.Rule;

/**
 * 规则管理器
 *
 * @author hxd
 * @since 2019/3/21
 */
public class RuleManager {

    private Rule[] rules;

    /**
     * @param rules 多个规则
     */
    public RuleManager(Rule... rules) {
        this.rules = rules;
    }

    /**
     * 处理数字转换
     *
     * @param number 被处理的数字
     * @return
     */
    public String processNumber(int number) {
        for (Rule rule : rules) {
            String result = rule.ruleCheck(number);
            // 如果结果不为null，说明匹配到规则，则输出规则定义的字符串
            if (result != null) {
                return result;
            }
        }
        // 默认返回数字原样
        return String.valueOf(number);
    }
}
