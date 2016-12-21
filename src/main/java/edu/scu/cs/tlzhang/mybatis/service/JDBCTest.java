package edu.scu.cs.tlzhang.mybatis.service;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by tlzhang on 2016/12/16.
 */
public class JDBCTest {
     /*开始的时候为了好看清楚整个代码逻辑，将main方法加上throws Exception
     JDBC编程六步骤：①加载驱动
                     ②连接DB
                     ③执行SQL
                     ④返回结果集
                     ⑤对结果处理
                     ⑥Close对象(必须执行Close());
                     */

    public static void main(String args[]) throws SQLException {

        // 数据库连接
        Connection connection = null;
        // 编译的sql语句
        PreparedStatement preparedStatement = null;
        // 结果集
        ResultSet resultSet = null;
        // 驱动类
        String className = "com.mysql.jdbc.Driver";
        // url of db
        String url = "jdbc:mysql://172.16.4.196:3310/ztl?autoReconnectForPools=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        // 用户名
        String userName = "migu";
        // 密码
        String pwd = "iflytek123456";
        // sql语句
        String sql = "insert into user(name, address, gender) values('cczhang', '科大讯飞股份有限公司', 'male')";
        try{
            // 1.加载驱动
            Class.forName(className);
            // 2 连接数据库
            connection = DriverManager.getConnection(url, userName, pwd);
            // 3 执行sql
            preparedStatement = connection.prepareStatement(sql);
            // 4 获取结果集
            preparedStatement.execute();
            // 解析结果集

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }

            if(preparedStatement != null){
                preparedStatement.close();
                preparedStatement = null;
            }

            if(connection != null){
                connection.close();
                connection = null;
            }
        }


    }
}
