package com.hapream.learn.designpattern.hello.creational.abstractfactory;

import com.hapream.learn.designpattern.hello.SplitHelloWorld;

/**
 * Created by zyg on 17-9-10.
 */
public class DesignPatternFactory  implements HelloWorldFactory{

    public SplitHelloWorld.HelloWorldInterjection createInterJection() {
        return new SplitHelloWorld.DefalutInterjection();
    }

    public SplitHelloWorld.HelloWorldObject createObject() {
        return new DesignPatternObject();
    }
    class DesignPatternObject implements SplitHelloWorld.HelloWorldObject{

        public String object() {
            return "Design Pattern " + "object";
        }
    }
}
