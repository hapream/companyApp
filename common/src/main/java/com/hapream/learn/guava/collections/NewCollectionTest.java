package com.hapream.learn.guava.collections;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import junit.framework.TestCase;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
public class NewCollectionTest extends TestCase {
    public void testMultiSet() {
        List<String> list = Lists.newArrayList("a", "b", "b", "c", "c", "c");
        Multiset<String> multiset = HashMultiset.create(list);
        assertEquals(2, multiset.count("b"));
        multiset.remove("c", 2);
        assertEquals(1, multiset.count("c"));


        List<String> stringList = Lists.newArrayList("A", "Bc", "DEF");
        Function<String, Integer> lenghFunction = new Function<String, Integer>() {
            @Nullable
            public Integer apply(@Nullable String input) {
                return input.length();
            }
        };

        Predicate<String> allCaps = new Predicate<String>() {
            public boolean apply(@Nullable String input) {
                return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(input);
            }
        };


        System.out.println(Iterables.filter(stringList, allCaps));

        System.out.println(Iterables.transform(stringList, lenghFunction));
        Multiset<Integer> integerMultiset = HashMultiset.create(Iterables.transform(Iterables.filter(stringList, allCaps), lenghFunction));
        System.out.println(integerMultiset);


    }
}
