package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class Util {
    private static final String DB_DRIVER = "java.sql.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user?useUnicode=yes&characterEncoding=UTF-8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1q2w3e4r5t6Y7";

    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            Class.forName(DB_DRIVER);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    // реализуйте настройку соеденения с БД

}
