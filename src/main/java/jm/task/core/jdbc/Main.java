package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util util = new Util();
        String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
        try (Connection connection = util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // реализуйте алгоритм здесь
    }
}
