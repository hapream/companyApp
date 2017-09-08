package com.hapream.learn.reflections;

import lombok.Data;

/**
 * Created by zhangyanggang on 2017/9/8.
 */

@Data
@PropertyTest(name = "Hello World")
public class AnnotationTest {
    private String name;
    private String addr;
    private int age;
}
