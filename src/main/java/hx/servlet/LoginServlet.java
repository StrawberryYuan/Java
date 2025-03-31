package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
  private UsersService usersService = new UsersService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    // 1. 获取表单参数
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    // 2. 查询数据库，获得用户对象
    Users user = usersService.getUserByName(userName);

    // 3. 判断是否登录成功
    if (user != null && user.getPassword().equals(password)) {
      // 登录成功
      HttpSession session = request.getSession();
      session.setAttribute("user", user);

      // 跳转到查询功能
      response.sendRedirect(request.getContextPath() + "/QueryServlet");
    } else {
      // 登录失败
      request.setAttribute("msg", "用户名或密码错误");
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
//public class LoginServlet extends HttpServlet {
//  private UsersService usersService = new UsersService();
//
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    request.setCharacterEncoding("UTF-8");
//    String userName = request.getParameter("userName");
//    String password = request.getParameter("password");
//    Users user = null;
//    if (user != null && user.getPassword().equals(password)) {
//      // 登录成功
//      HttpSession session = request.getSession();
//      session.setAttribute("user", user);
//
//      // 登录后直接访问 QueryServlet
//      response.sendRedirect(request.getContextPath() + "/QueryServlet");
//    } else {
//      // 登录失败
//      request.setAttribute("msg", "用户名或密码错误");
//      request.getRequestDispatcher("/login.jsp").forward(request, response);
//    }
//    // 根据用户名查询用户信息
//    user = usersService.getUserByName(userName);
////    if (user != null && user.getPassword().equals(password)) {
////      // 登录成功
////      HttpSession session = request.getSession();
////      session.setAttribute("user", user);
////      // 跳转到查询功能，这样能获取所有用户信息
////      response.sendRedirect(request.getContextPath() + "/QueryServlet");
////    } else {
////      // 登录失败
////      request.setAttribute("msg", "用户名或密码错误");
////      request.getRequestDispatcher("/login.jsp").forward(request, response);
////    }
////    if (user != null && user.getPassword().equals(password)) {
////      // 登录成功，将用户信息存入 session 中
////      HttpSession session = request.getSession();
////      session.setAttribute("user", user);
////      // 跳转到用户信息展示页面（例如 userinfo.jsp）
////      response.sendRedirect(request.getContextPath() + "/userinfo.jsp");
////    } else {
////      // 登录失败，设置错误提示并返回登录页面
////      request.setAttribute("msg", "用户名或密码错误");
////      request.getRequestDispatcher("/login.jsp").forward(request, response);
////      // 登录验证成功后
////     // response.sendRedirect(request.getContextPath() + "/QueryServlet");
////    }
//
//  }
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    // 如果需要处理 GET 请求也可以调用 doPost
//    doPost(request, response);
//  }
//}