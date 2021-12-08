package com.biubiu.test;

import org.apache.commons.dbutils.ResultSetHandler;
import sun.plugin2.main.server.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyResultSetHandler implements ResultSetHandler {
    @Override
    public Object handle(ResultSet resultSet) throws SQLException {
        return "hello world";
    }
}
