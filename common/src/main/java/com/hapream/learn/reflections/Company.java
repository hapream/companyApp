package com.hapream.learn.reflections;

import lombok.Data;

/**
 * Created by zhangyanggang on 2017/9/9.
 */

public class Company {
    private final int i = 3;

    public int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }
}
