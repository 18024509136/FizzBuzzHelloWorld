package com.hxd.fizzbuzz.build;

import com.hxd.fizzbuzz.manager.RuleManager;

/**
 * 主程类，供用户使用
 *
 * @author hxd
 * @since 2019/3/21
 */
public class FizzBuzzRunner {

    private RuleManager ruleManager;

    private int startNo;

    private int endNo;

    /**
     * 构造函数
     *
     * @param ruleManager 规则管理器
     * @param startNo     开始数字
     * @param endNo       结束数字
     */
    public FizzBuzzRunner(RuleManager ruleManager, int startNo, int endNo) {
        this.ruleManager = ruleManager;
        this.startNo = startNo;
        this.endNo = endNo;
    }

    /**
     * 主业务
     */
    public void run() {
        for (int i = startNo; i <= endNo; i++) {
            System.out.println(ruleManager.processNumber(i));
        }
    }
}
