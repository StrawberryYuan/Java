//package hx.servlet;
//
//import hx.entity.Users;
//import hx.service.UsersService;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//import java.util.List;
//
//public class QueryServlet extends HttpServlet {
//  private UsersService usersService = new UsersService();
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException, ServletException {
//    // 如果是管理员查询所有
//   // List<Users> userList = usersService.getAllUsers();
//   // request.setAttribute("userList", userList);
//    // 跳转到 userinfo.jsp 展示
//    //request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
//    List<Users> userList = usersService.getAllUsers();
//    request.setAttribute("userList", userList);
//    request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
//  }
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    doGet(request, response);
//  }
//}
package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

public class QueryServlet extends HttpServlet {
  private UsersService usersService = new UsersService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 1. 获取当前会话 & 用户
    HttpSession session = request.getSession(false);
    if (session == null) {
      // 如果没有 session，说明没登录，重定向到登录
      response.sendRedirect(request.getContextPath() + "/login.jsp");
      return;
    }
    Users currentUser = (Users) session.getAttribute("user");
    if (currentUser == null) {
      // 没有在 session 中找到用户，说明没登录
      response.sendRedirect(request.getContextPath() + "/login.jsp");
      return;
    }

    // 2. 判断用户名是否是 "admin"
    if ("admin".equalsIgnoreCase(currentUser.getUserName())) {
      // 管理员：查询所有用户
      List<Users> userList = usersService.getAllUsers();
      request.setAttribute("userList", userList);
      // 转发到管理员页面（显示所有用户）
      request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
    } else {
      // 普通用户：仅查询自己的信息
      Users personalUser = usersService.getUserByName(currentUser.getUserName());
      request.setAttribute("personalUser", personalUser);
      // 转发到 personalinfo.jsp 显示个人信息
      request.getRequestDispatcher("/personalinfo.jsp").forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}