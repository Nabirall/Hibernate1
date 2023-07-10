package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class UserDaoJDBCImpl implements UserDao {
//public UserDaoJDBCImpl() {
//
//}
//
//private static final Connection connection = Util.getConnection();
//
//public final void createUsersTable() {
//    try (Statement statement = connection.createStatement()) {
//        statement.executeUpdate("create table if not exists users (id int primary key auto_increment,name varchar(45),lastname varchar(45),age int)");
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//
//public void dropUsersTable() {
//    try (PreparedStatement preparedStatement = connection.prepareStatement("drop table if exists users")) {
//        preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//
//public void saveUser(String name, String lastName, byte age) {
//    try (PreparedStatement preparedStatement = connection.prepareStatement("insert into users (name, lastname, age) values (?, ?, ?)")) {
//        preparedStatement.setString(1, name);
//        preparedStatement.setString(2, lastName);
//        preparedStatement.setByte(3, age);
//        preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//
//public void removeUserById(long id) {
//    try (PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?")) {
//        preparedStatement.setLong(1, id);
//        preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//
//public List<User> getAllUsers() {
//    List<User> userList = new ArrayList<>();
//    try (Statement statement = connection.createStatement();
//         ResultSet result = statement.executeQuery("select * from users")) {
//        while (result.next()) {
//            User user = new User(result.getString("name"), result.getString("lastname"), result.getByte("age"));
//            user.setId(result.getLong("id"));
//            userList.add(user);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return userList;
//}
//
//public void cleanUsersTable() {
//    try (PreparedStatement preparedStatement = connection.prepareStatement("truncate table users")) {
//        preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//}
