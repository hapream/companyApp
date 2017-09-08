package com.hapream.learn.designpattern.adapter;

/**
 * Created by zhangyanggang on 2017/9/1.
 */
public class GnomeEngineerAdapter implements Engineer {
    private final Engineer engineer;

    public GnomeEngineerAdapter(Engineer engineer) {
        this.engineer = engineer;
    }

    public void executor() {
        engineer.executor();
    }
}
