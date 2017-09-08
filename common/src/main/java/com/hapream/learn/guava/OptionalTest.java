package com.hapream.learn.guava;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public class OptionalTest{

    @Test
    public void testOptionanl(){
        Optional<Integer> possible = Optional.of(7);
        if (possible.isPresent()){
            System.out.println(possible.isPresent());
            System.out.println(possible.get());
        }
    }

}
