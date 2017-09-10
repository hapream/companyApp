package com.hapream.learn.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public PropertyValues() {

    }


    public void addPropertyValue(PropertyValue value) {
        this.propertyValues.add(value);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
