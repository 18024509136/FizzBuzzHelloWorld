package com.hxd.fizzbuzz.matcher.impl;

import com.hxd.fizzbuzz.matcher.Matcher;

/**
 * 明文包含匹配器
 *
 * @author hxd
 * @since 2019/3/21
 */
public class LiteralContainMatcher implements Matcher {

    private String stringIncluded;

    /**
     * @param stringIncluded 要求包含的字符
     */
    public LiteralContainMatcher(String stringIncluded) {
        this.stringIncluded = stringIncluded;
    }

    public boolean match(int number) {
        return String.valueOf(number).contains(stringIncluded);
    }
}
