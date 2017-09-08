package com.hapream.learn.designpattern.callback;

/**
 * Created by zhangyanggang on 2017/9/4.
 */
public class XiaoHong {


    public void sum(int a, int b, CallBack call) {
        System.out.println(a + " + " + b + " = " + (a + b));
        call.call(a+b);
//        return a + b;
    }
}
