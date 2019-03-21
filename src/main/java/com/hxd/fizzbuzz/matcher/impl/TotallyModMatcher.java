package com.hxd.fizzbuzz.matcher.impl;

import com.hxd.fizzbuzz.matcher.Matcher;

/**
 * 整除匹配器
 *
 * @author hxd
 * @since 2019/3/21
 */
public class TotallyModMatcher implements Matcher {

    private int division;

    /**
     * @param division 要求整除的数字
     */
    public TotallyModMatcher(int division) {
        this.division = division;
    }

    public boolean match(int number) {
        return number % division == 0;
    }
}
