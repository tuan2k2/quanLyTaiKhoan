/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.User;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import App.ListUserFrame;
/**
 *
 * @author tuanta
 */
public class UserDao {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "select * from users";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("ten"));
                user.setPhone(rs.getString("sodt"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("pass"));
                user.setRole(rs.getString("Roles"));
                user.setFavourites(rs.getString("Favolirites"));
                user.setAbout(rs.getString("about"));
                users.add(user);
            }
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    public void addUser(User user) {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "INSERT INTO users( ten, sodt,username,pass,Roles, Favolirites,about)"
                + "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user.getName());
            stm.setString(2, user.getPhone());
            stm.setString(3, user.getUsername());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getRole());
            stm.setString(6, user.getFavourites());
            stm.setString(7, user.getAbout());

            int rs = stm.executeUpdate();
            System.out.println(rs);

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(User user) {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "Update users set ten = ? , sodt = ? , username = ? , pass = ? , "
                + " about = ? , Favolirites = ? , Roles = ? where id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getFavourites());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setInt(8, user.getId());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void deleteUser(int id) {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "delete from users where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public User getUserById(int id) {
        Connection conn = JDBCConnection.JDBCConnection();
        String sql = "SELECT * FROM users WHERE id= ? ";

        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("ten"));
                user.setPhone(rs.getString("sodt"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("pass"));
                user.setRole(rs.getString("Roles"));
                user.setFavourites(rs.getString("Favolirites"));
                user.setAbout(rs.getString("about"));

                return user;
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void editUser(User user) {
        Connection conn = JDBCConnection.JDBCConnection();
        String sql = "UPDATE users SET ten = ?, sodt = ?, username=?,pass=?,Roles=?,"
                + "Favolirites=?,about=? WHERE id = ?";
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getName());
            stm.setString(2, user.getPhone());
            stm.setString(3, user.getUsername());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getRole());
            stm.setString(6, user.getFavourites());
            stm.setString(7, user.getAbout());
            stm.setInt(8, user.getId());

            int rs = stm.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}