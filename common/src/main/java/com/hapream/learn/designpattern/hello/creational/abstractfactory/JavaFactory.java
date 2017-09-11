package com.hapream.learn.designpattern.hello.creational.abstractfactory;

import com.hapream.learn.designpattern.hello.SplitHelloWorld;

/**
 * Created by zyg on 17-9-10.
 */
public class JavaFactory implements HelloWorldFactory {
    public SplitHelloWorld.HelloWorldInterjection createInterJection() {
        return new SplitHelloWorld.DefalutInterjection();
    }

    public SplitHelloWorld.HelloWorldObject createObject() {
        return  new JavaHelloWorld();
    }

    class JavaHelloWorld implements SplitHelloWorld.HelloWorldObject{

        public String object() {
            return "java " + "world";
        }
    }
}
