package com.hapream.learn.reflections;

import java.lang.reflect.Method;

/**
 * Created by zhangyanggang on 2017/9/9.
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.hapream.learn.reflections.Company");
            Object object = clazz.newInstance();
            Method[] ms =clazz.getMethods();
            for (Method m : ms){
                System.out.println(m);
            }

            Method[] dms = clazz.getDeclaredMethods();
            for (Method m : dms){
                System.out.println("declared Method " + m);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
