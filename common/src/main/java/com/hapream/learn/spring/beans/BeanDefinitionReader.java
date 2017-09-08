package com.hapream.learn.spring.beans;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
