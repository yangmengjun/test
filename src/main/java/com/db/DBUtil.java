package com.db;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接工具
 * @author: yangmengjun
 * @date: 2019\1\21 0021 16:29
 */
public class DBUtil {
    private final static String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    private static Connection conn;

    static{
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(resultSet!=null){
                resultSet.close();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
