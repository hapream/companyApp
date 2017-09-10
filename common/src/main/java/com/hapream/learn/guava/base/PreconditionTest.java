package com.hapream.learn.guava.base;

import com.google.common.base.Preconditions;
import junit.framework.TestCase;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
public class PreconditionTest {

    public static void main(String[] args) {
//        testCheckArg(0);
//        testCheckNotNull(null);
        testCheckArg(2);
        testCheckNotNull(8);
    }

    public static void testCheckArg(int i) {
        Preconditions.checkArgument(i > 0, "Argument was %s  but expected nonnegative", i);
    }

    public static void testCheckNotNull(Object object) {
        Preconditions.checkNotNull(object, "Argument should not be null");
    }

}
