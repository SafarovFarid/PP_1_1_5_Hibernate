package jm.task.core.jdbc;



import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;



import java.sql.*;


public class Main {

    private final static UserService userService = new UserServiceImpl();


    public static void main(String[] args) throws SQLException {

        userService.createUsersTable();
        userService.saveUser("Константин", "Яковлев", (byte) 78);
        System.out.printf("User с именем – %s добавлен в базу данных\n", "Константин");
        userService.saveUser("Филип", "Трамп", (byte) 74);
        System.out.printf("User с именем – %s добавлен в базу данных\n", "Филип");
        userService.saveUser("Мелания", "Шувалова", (byte) 59);
        System.out.printf("User с именем – %s добавлен в базу данных\n", "Мелания");
        userService.saveUser("Алексей", "Кондратьев", (byte) 74);
        System.out.printf("User с именем – %s добавлен в базу данных\n", "Алексей");
        for (User us: userService.getAllUsers()) {
            System.out.println(us);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        // реализуйте алгоритм здесь
    }
}
