package com.hapream.learn.guava.cache;

import com.google.common.cache.*;
import com.hapream.learn.guava.vo.Person;
import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
public class CacheTest extends TestCase{

    public void testCache(){
        LoadingCache<Integer, Person> personCache = CacheBuilder.newBuilder()
                .concurrencyLevel(8)
                .expireAfterWrite(8, TimeUnit.SECONDS)
                .initialCapacity(10)
                .maximumSize(100)
                .recordStats()
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> notification) {

                    }
                }).build(
                        new CacheLoader<Integer, Person>() {
                            @Override
                            public Person load(Integer key) throws Exception {
                                return null;
                            }
                        }
                );
    }
}
