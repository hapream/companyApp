package com.hapream.learn.spring.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangyanggang on 2017/9/8.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
