package com.hapream.learn.designpattern.async.method.invocation;

/**
 * Created by zhangyanggang on 2017/9/4.
 */
public interface ExeResult<V> {

    V getValue();

    void onSuccess();

    void onError();


}

