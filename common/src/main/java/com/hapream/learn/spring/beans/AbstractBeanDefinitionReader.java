package com.hapream.learn.spring.beans;

import com.hapream.learn.spring.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyanggang on 2017/9/8.
 * 加载资源, 解析后 map
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<String, BeanDefinition>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
