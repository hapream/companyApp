package com.hapream.learn.designpattern.hello;

/**
 * Created by zyg on 17-9-10.
 * Split "Hello World" to "Hello"(interjection) and "World"(object) so that you can configuration it separately.
 */
public class SplitHelloWorld implements HelloWorld {


    private HelloWorldInterjection helloWorldInterjection;
    private HelloWorldObject helloWorldObject;

    private static final String separator = " ";
    private static final String terminator = "!";

    public SplitHelloWorld(HelloWorldInterjection helloWorldInterjection, HelloWorldObject helloWorldObject) {
        this.helloWorldInterjection = helloWorldInterjection;
        this.helloWorldObject = helloWorldObject;
    }


    public String helloWorld() {
        return helloWorldInterjection.interjection() + separator + helloWorldObject.object() + terminator;
    }


    public interface HelloWorldInterjection {
        String interjection();
    }

    public interface HelloWorldObject {
        String object();
    }

    public static class DefalutInterjection implements HelloWorldInterjection {

        public String interjection() {
            return "Hello";
        }
    }
}
