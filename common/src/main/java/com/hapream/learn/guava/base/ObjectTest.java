package com.hapream.learn.guava.base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import lombok.Data;

/**
 * Created by zhangyanggang on 2017/9/10.
 */
public class ObjectTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1);
        user1.setName("aaa");
        System.out.println(user1);


    }

}


@Data
class User implements Comparable<User> {

    private int id;
    private String name;

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User that = (User) obj;
            return Objects.equal(this.id, that.getId()) && Objects.equal(this.name, that.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
    }

    public int compareTo(User obj) {

        return ComparisonChain.start().compare(id, obj.id).compare(name, obj.name).result();
    }
}