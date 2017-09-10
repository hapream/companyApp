package com.hapream.learn.designpattern.hello.creational.abstractfactory;

import com.hapream.learn.designpattern.hello.SplitHelloWorld;

/**
 * Created by zyg on 17-9-10.
 */
public interface HelloWorldFactory {
    SplitHelloWorld.HelloWorldInterjection createInterJection();

    SplitHelloWorld.HelloWorldObject createObject();
}
