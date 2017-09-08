package com.hapream.learn.designpattern.adapter;

/**
 * Created by zhangyanggang on 2017/9/1.
 */
public class App {
    public static void main(String[] args) {
        Engineer engineer = new GnomeEngineerAdapter(new GnomeEngineer());
        engineer.executor();

    }
}
