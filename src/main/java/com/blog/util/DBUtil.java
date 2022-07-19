package com.blog.util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static final String URL = "db.url";
    private static final String USERNAME = "db.username";
    private static final String PASSWORD = "db.password";
    private static final String DRIVER_CLASS = "db.class.name";

    private static BasicDataSource dataSource;


    static {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("db.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty(DRIVER_CLASS));
            dataSource.setUrl(properties.getProperty(URL));
            dataSource.setUsername(properties.getProperty(USERNAME));
            dataSource.setPassword(properties.getProperty(PASSWORD));
            dataSource.setMinIdle(100);
            dataSource.setMaxIdle(1000);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) conn.close();
            if (pstmt != null) conn.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
