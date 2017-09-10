package com.hapream.learn.spring.beans;

import lombok.Data;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
@Data
public class BeanReference {
    private String name;
    private Object beanDefinition;

    public BeanReference(String name) {
        this.name = name;
    }

}
