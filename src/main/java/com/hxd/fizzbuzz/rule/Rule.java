package com.hxd.fizzbuzz.rule;

/**
 * 转换规则器接口
 *
 * @author hxd
 * @since 2019/3/21
 */
public interface Rule {

    /**
     * 规则校验与转换
     *
     * @param number 被处理的数字
     * @return
     */
    String ruleCheck(int number);
}
