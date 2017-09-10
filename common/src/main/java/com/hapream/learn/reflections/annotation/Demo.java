package com.hapream.learn.reflections.annotation;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public class Demo {
    public static void main(String[] args) {
        Set<Class<?>> classes = new Reflections(new ConfigurationBuilder().addUrls(ClasspathHelper.forPackage("com.hapream.learn.reflections"))).getTypesAnnotatedWith(PropertyTest.class);
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName());
            System.out.println(((PropertyTest) (clazz.getAnnotation(PropertyTest.class))).name());
            System.out.println(ReflectionUtils.getAllFields(clazz));
            System.out.println(ReflectionUtils.getAllMethods(clazz));
        }
    }
}
