package com.hapream.learn.designpattern.hello.structural.adapter;

import com.hapream.learn.designpattern.hello.HelloWorld;

/**
 * Created by zyg on 17-9-10.
 */
public class HelloWorldAdapter implements HelloWorld {
    private HelloWorldDesidnPattern dp ;

    public HelloWorldAdapter(HelloWorldDesidnPattern dp) {
        this.dp = dp;
    }

    public void setDp(HelloWorldDesidnPattern dp) {
        this.dp = dp;
    }

    public String helloWorld() {
        return dp.helloDesidnPattern();
    }
}
