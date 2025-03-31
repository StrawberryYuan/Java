package hx.service;

import hx.dao.UserDAO;
import hx.entity.Users;

import java.util.List;

public class UsersService {
  private UserDAO userDAO = new UserDAO();

  public boolean registerUser(Users user) {
    // 你也可以在这里先判断用户是否已存在，再决定是否插入
    return userDAO.registerUser(user);
  }

  public List<Users> getAllUsers() {
    return userDAO.getAllUsers();
  }

  public Users getUserByName(String userName) {
    return userDAO.getUserByName(userName);
  }

  public boolean deleteUser(String userName) {
    return userDAO.deleteUser(userName);
  }

  public boolean updateUser(Users user) {
    return userDAO.updateUser(user);
  }
}
