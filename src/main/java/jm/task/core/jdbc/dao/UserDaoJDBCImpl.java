package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//public class UserDaoJDBCImpl implements UserDao {
//    Connection connection = getConnection();
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String str ="CREATE TABLE IF NOT EXISTS `user`.`user` ( `id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(255) NULL, `lastName` VARCHAR(255) NULL,  `age` INT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
//        try(Statement statement = connection.createStatement()){
//            statement.executeUpdate(str);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String str ="DROP TABLE IF EXISTS `user`.`users`;";
//        try(Statement statement = connection.createStatement()){
//            statement.executeUpdate(str);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String str = "INSERT INTO user.users (name, lastName, age) VALUES (? , ? , ?);";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(str)) {
//
//            preparedStatement.setString(1,name);
//            preparedStatement.setString(2,lastName);
//            preparedStatement.setByte(3,age);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//    public void removeUserById(long id) {
//        String str = "DELETE FROM user.users WHERE id = ?;";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(str)) {
//            preparedStatement.setLong(1,id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//        String str = "SELECT id, name, lastName, age FROM user.users;";
//        List<User> users = new ArrayList<>();
//        try(Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(str);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        String str = "TRUNCATE user.users;";
//        try(Statement statement = connection.createStatement()){
//            statement.executeUpdate(str);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
