package com.hapream.learn.spring.beans.io;

import java.net.URL;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getResource(location);
        return new UrlResource(resource);
    }
}
