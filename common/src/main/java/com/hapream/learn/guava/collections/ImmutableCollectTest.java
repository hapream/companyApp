package com.hapream.learn.guava.collections;

import com.google.common.collect.ImmutableSet;
import junit.framework.TestCase;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
public class ImmutableCollectTest extends TestCase {

    public void testSet() {
        ImmutableSet<String> COLLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");

        try {
            COLLOR_NAMES.add("bb");
        } catch (UnsupportedOperationException e) {

        }
    }

    public void testBuild() {
        ImmutableSet<String> set = ImmutableSet.<String>builder().add("a").add("b").build();
        assertEquals( ImmutableSet.of("a","b"),set);
        ImmutableSet<String> setCopy = ImmutableSet.copyOf(set);
        assertEquals(setCopy,set);

    }
}
