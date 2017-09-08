package com.hapream.learn.aviator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by zhangyanggang on 2017/9/8.
 */

@Data
public class Foo {
    private int i;
    private float f;
    private Date date = new Date();

    public Foo(int i, float f, Date date) {
        this.i = i;
        this.f = f;
        this.date = date;
    }
}
