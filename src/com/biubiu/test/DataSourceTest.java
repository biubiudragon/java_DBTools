package com.biubiu.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    public static void main(String[] args) {

        try {
            //创建C3P0对象
            ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
            Connection conn=dataSource.getConnection();
            System.out.println(conn);
            //换回到数据连接池中
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
