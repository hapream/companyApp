package com.hapream.learn.designpattern.hello.structural.bridge;

import com.hapream.learn.designpattern.hello.HelloWorld;

/**
 * Created by zyg on 17-9-10.
 */
public class Bridge {
    private Style style;
    private HelloWorld helloWorld;

    public Bridge(Style style, HelloWorld helloWorld) {
        this.style = style;
        this.helloWorld = helloWorld;
    }

    public void action() {
        System.out.println(style.action());
    }

    public void helloWorld() {
        System.out.println(this.helloWorld.helloWorld());
    }
}
