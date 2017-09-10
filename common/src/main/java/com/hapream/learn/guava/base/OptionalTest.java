package com.hapream.learn.guava.base;

import com.google.common.base.Optional;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public class OptionalTest extends TestCase{

    public void testAbsent(){
        Optional<String> optional = Optional.absent();
        assertFalse(optional.isPresent());
    }

    public void testOf(){
        assertEquals("test",Optional.of("test").get());
    }

    public void testOf_null(){
        try {
            Optional.of(null);
            fail();
        } catch (NullPointerException expected) {
        }
    }

    public void testFromNullable(){
        assertSame(Optional.absent(), Optional.fromNullable(null));
    }

    public void testGet_absent(){
        Optional<String> optional = Optional.absent();
        try {
            optional.get();
            fail();
        } catch (IllegalStateException expected) {
        }
    }



    public void testAsSet(){
        Set<String> strings = Collections.singleton("a");
        assertEquals(strings, Optional.of("a").asSet());
    }
}
