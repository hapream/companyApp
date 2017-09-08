package com.hapream.learn.phoenix;

import java.sql.*;

/**
 * Created by zhangyanggang on 2017/9/7.
 */
public class TestPhoenix {


    public Connection GetConnection() {
        Connection cc = null;
        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
         String url = "jdbc:phoenix:172.24.28.118:2181";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (cc == null) {
            try {
                cc = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cc;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestPhoenix testPhoenix = new TestPhoenix();
        Connection connection = testPhoenix.GetConnection();
        Statement statement =  connection.createStatement();
         String sql = "select VAL from \"t1\"";
       ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

    }
}
