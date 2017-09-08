package com.hapream.learn.aviator;

import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangyanggang on 2017/9/8.
 * 效率相对
 */
public class Demo {

    @Test
    public void testAdd() {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        assertEquals(new Long(6), result);
    }

    @Test
    public void testString() {
        String yourName = "aviator";
        Map<String, Object> env = Maps.newHashMap();
        env.put("yourName", yourName);
        String result = (String) AviatorEvaluator.execute("'hello ' + yourName", env);
        assertEquals("hello aviator", result);
    }

    @Test
    public void testObject() {
        Foo foo = new Foo(100, 3.14f, new Date());
        Map<String, Object> env = Maps.newHashMap();
        env.put("foo", foo);

        String result = (String) AviatorEvaluator.execute(
                " '[foo i='+ foo.i + ' f='+foo.f+' year='+(foo.date.year+1900)+ ' month='+foo.date.month +']' ", env
        );
        System.out.println(result);
    }

    @Test
    public void testFunction(){
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("addDolble(1,2)"));
        System.out.println(AviatorEvaluator.execute("addDolble(addDolble(1,2),100)"));
        System.out.println(AviatorEvaluator.compile("addDolble(1,2)", true).execute().toString());
    }
}
