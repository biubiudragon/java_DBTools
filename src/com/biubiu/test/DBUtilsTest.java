package com.biubiu.test;

import com.biubiu.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtilsTest {
    private static ComboPooledDataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource("testc3p0");
    }

    public static void main(String[] args) {
//        Student s1 = findById();
//        System.out.println(s1);
        List<Student> s2 = findByDButils();
        System.out.println(s2);
    }
    public static Student findById(){
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rst=null;
        Student student=null;
        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM STUDENT WHERE sid = 1001";
            pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()){
                Integer id = rst.getInt(1);
                String  name=rst.getString(2);
                Integer age = rst.getInt(3);
                String sex = rst.getString(4);
                String department = rst.getString(5);
                String address = rst.getString(6);
                String birthplae = rst.getString(7);
                student = new Student(id,name,age,sex,department,address,birthplae);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
                pst.close();
                rst.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return student;
    }
    public static List<Student> findByDButils(){
        List<Student> studentList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //String sql = "SELECT * FROM STUDENT WHERE sid = ?";
        String sql = "SELECT * FROM STUDENT ";
        QueryRunner queryRunner = new QueryRunner();
        Student student = null;
        try {
            studentList = queryRunner.query(conn,sql,new BeanListHandler<>(Student.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

}
