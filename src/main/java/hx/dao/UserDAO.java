package hx.dao;

import hx.entity.Users;
import hx.util.JdbcUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
  // 用户注册
  public boolean registerUser(Users user) {
    String sql = "INSERT INTO Users(userName, password, sex, email) VALUES (?, ?, ?, ?)";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, user.getUserName());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getSex());
      ps.setString(4, user.getEmail());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // 查询所有用户（管理员）
  public List<Users> getAllUsers() {
    List<Users> list = new ArrayList<>();
    String sql = "SELECT userId, userName, password, sex, email FROM Users";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        // 注意这里取出 userId 并封装
        list.add(new Users(
            rs.getInt("userId"),
            rs.getString("userName"),
            rs.getString("password"),
            rs.getString("sex"),
            rs.getString("email")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  // 通过用户名查询用户（本人）
  public Users getUserByName(String userName) {
    String sql = "SELECT userId, userName, password, sex, email FROM Users WHERE userName = ?";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, userName);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new Users(
              rs.getInt("userId"),
              rs.getString("userName"),
              rs.getString("password"),
              rs.getString("sex"),
              rs.getString("email")
          );
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  // 删除用户（注销）
  public boolean deleteUser(String userName) {
    String sql = "DELETE FROM Users WHERE userName = ?";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, userName);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // 更新用户信息
  // 这里以 "用户名唯一" 为条件更新，也可以用 userId 作为条件
  public boolean updateUser(Users user) {
    String sql = "UPDATE Users SET password = ?, sex = ?, email = ? WHERE userName = ?";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, user.getPassword());
      ps.setString(2, user.getSex());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getUserName());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {

      e.printStackTrace();
      System.out.println("注册用户失败，错误信息：" + e.getMessage());
      return false;

    }
  }
}