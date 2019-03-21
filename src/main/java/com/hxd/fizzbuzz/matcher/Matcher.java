package com.hxd.fizzbuzz.matcher;

/**
 * 匹配器接口
 *
 * @author hxd
 * @since 2019/3/21
 */
public interface Matcher {

    /**
     * 数字匹配
     *
     * @param number 被匹配的数字
     * @return
     */
    boolean match(int number);
}
