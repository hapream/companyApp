package com.hapream.learn.phoenix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangyanggang on 2017/9/7.
 */
public class TestApp {
    public static void main(String[] args) {
        query();
    }

    public static void query() {

        Connection conn = null;
        try {
            // get connection
            conn = BaseDB.getConnection();

            // check connection
            if (conn == null) {
                System.out.println("conn is null...");
                return;
            }

            // create sql
            String sql = "select * from t1";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("id" + "\t" + "account" + "\t" + "passwd");
            System.out.println("======================");

            if (rs != null) {
                while (rs.next()) {
                    System.out.print(rs.getString("id") + "\t");
                    System.out.print(rs.getString("account") + "\t");
                    System.out.println(rs.getString("passwd"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
