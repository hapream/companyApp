package com.hapream.learn.phoenix;

/**
 * Created by zhangyanggang on 2017/9/7.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * class： BaseDB
 * package： cn.com.dimensoft.hadoop.phoenix.jdbc
 * time： 2015年5月4日 下午2:19:57
 * description：
 */
public class BaseDB {

    /**
     * name：getConnection
     * time：2015年5月6日 下午2:07:06
     * description： get JDBC connection
     *
     * @return connection
     */
    public static Connection getConnection() {
        try {
            // load driver
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");

            // get connection
            // jdbc 的 url 类似为 jdbc:phoenix [ :<zookeeper quorum> [ :<port number> ] [ :<root node> ] ]，
            // 需要引用三个参数：hbase.zookeeper.quorum、hbase.zookeeper.property.clientPort、and zookeeper.znode.parent，
            // 这些参数可以缺省不填而在 hbase-site.xml 中定义。
            return DriverManager.getConnection("jdbc:phoenix:172.24.28.118:2181:hbase");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}