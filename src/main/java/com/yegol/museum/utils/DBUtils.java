package com.yegol.museum.utils;


import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DruidDataSource ds;
    static{
        Properties p = new Properties();
        InputStream ips = com.yegol.museum.utils.DBUtils.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        try {
            p.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = p.getProperty("db.driver");
        String url = p.getProperty("db.url");
        String username = p.getProperty("db.username");
        String password = p.getProperty("db.password");

        ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(3);
        ds.setMaxActive(5);
    }
    public static Connection getConn() throws SQLException {
        Connection conn = ds.getConnection();
        return conn;
    }
}
