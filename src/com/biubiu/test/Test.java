package com.biubiu.test;
import javax.sql.DataSource;
import java.sql.*;
public class Test {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3307/学生信息?useUnicode=True&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
            String user = "biubiu";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url,user,password);
            //String sql = "INSERT INTO student(sid,sname,age,sex,department,address,birthplace) VALUES(1001,'hj',34,'f','zc','sh','js')";
            String sql = "SELECT * FROM student WHERE sid = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setObject(1,1001);
            ResultSet rst = pst.executeQuery();
            //Statement statement = connection.createStatement();
            //int result = statement.executeUpdate(sql);
            while (rst.next()){
                Object result = rst.getObject("sname");
                System.out.println(result);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch ( SQLException e){
            e.printStackTrace();
        }
    }
}
