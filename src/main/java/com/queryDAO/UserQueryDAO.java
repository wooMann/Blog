package com.queryDAO;

import com.entity.User;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQueryDAO {

    private User makeUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));

        return user;
    }

    public User findUser(User user) {
        String sql = "select * from user where email = '" + user.getEmail()+"'";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {
            System.out.println(sql);
            return rs.next() ? makeUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findUserByid(Integer id) {
        String sql = "select * from user where id = " + id;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {
            return rs.next() ? makeUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User joinUser(User user) {
        String sql = "insert into user(email,password,name) values(?,?,?)";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            int result = ps.executeUpdate();

            return result >= 1 ? user : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User login(User user) {
        String sql = "select * from user where email = " + user.getEmail() + " and password = " + user.getPassword();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {
            return rs.next() ? makeUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User updateUser(User user) {
        String sql = "update users set name = ?";
        sql += user.getPassword().isEmpty() ? "" : " ,password = ? ";
        sql += " where id = ?";

        try (Connection connection = DBUtil.getDataSource().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, user.getName());
            if(user.getPassword().isEmpty()) ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            return rs.next() ? user : null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUser(Integer userId) {
        String sql = "delete from user where id = " + userId;

        try (Connection connection = DBUtil.getDataSource().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()){

            return rs.next() ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
