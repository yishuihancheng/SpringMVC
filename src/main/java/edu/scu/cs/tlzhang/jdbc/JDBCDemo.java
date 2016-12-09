package edu.scu.cs.tlzhang.jdbc;

import java.sql.*;

/**
 * Created by tlzhang on 2016/11/29.
 */
public class JDBCDemo {
    public static void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws SQLException {
        loadDriver();
        String url = "jdbc:mysql://172.16.4.196:3310/test?autoReconnectForPools=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        String userName = "migu";
        String password = "iflytek123456";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, userName, password);
        } catch (SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }

        String sql = "insert into user(name, pwd) values ('migu1', '123456')";
        Statement stmt = con.createStatement();
        PreparedStatement pstmt = con.prepareStatement(sql);
        int rows = stmt.executeUpdate(sql);
        System.out.println("rows..." + rows);
        sql = "insert into user(name, pwd) values ('tlzhang1', '123456')";
        pstmt.executeUpdate(sql);
        con.close();


    }
}
