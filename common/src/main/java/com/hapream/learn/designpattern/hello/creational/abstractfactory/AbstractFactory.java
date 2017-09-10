package com.hapream.learn.designpattern.hello.creational.abstractfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyg on 17-9-10.
 */
public class AbstractFactory {
    private static Map<Type, Class< ? extends HelloWorldFactory>> contain ;

    public enum Type{
          JAVA, DESIGNPATTERN
    }


    static {
        contain = new HashMap<Type, Class<? extends HelloWorldFactory>>();
        contain.put(Type.JAVA, JavaFactory.class);
        contain.put(Type.DESIGNPATTERN, DesignPatternFactory.class);
    }

    public static HelloWorldFactory select(Type type) throws IllegalAccessException, InstantiationException {
        return contain.get(type).newInstance();
    }


}
