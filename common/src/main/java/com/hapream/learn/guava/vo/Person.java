package com.hapream.learn.guava.vo;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
@Getter
@Setter
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return Objects.equal(name, ((Person) obj).getName()) && Objects.equal(age, ((Person) obj).getAge());
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("age", age).toString();
    }
}
