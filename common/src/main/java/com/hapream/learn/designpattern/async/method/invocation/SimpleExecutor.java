package com.hapream.learn.designpattern.async.method.invocation;

import java.util.concurrent.Callable;

/**
 * Created by zhangyanggang on 2017/9/4.
 */
public class SimpleExecutor<V> implements Executor<V> {

    public ExeResult<V> executor(Callable<V> callable, ExeResult<V> result) {

        return null;
    }
}
