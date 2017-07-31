package main;

import java.sql.*;

/**
 * 作者：宁国通 on 2017/7/31 10:18
 * 公司邮箱：ngt@bluecity.com.cn
 * 个人邮箱：ningguotong1142115009@outlook.com
 * FIXME
 */
public class Test {
    //程序启动入口
    public static void main(String[] args){
        try{
            testSQLServer2008();//测试链接sqlserver数据库
        }catch (Exception ex){}
    }

    public static void testSQLServer2008() throws SQLException {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载JDBC驱动
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=test";  //连接服务器和数据库
        String userName = "sa";  //用户名
        String userPwd = "sa";  //密码
        Connection dbConn = null;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接成功!");  //连接成功
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败!");
        }finally {
            if (dbConn!=null && !dbConn.isClosed()){
                dbConn.close();
            }
        }
    }

}
