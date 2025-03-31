package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
  private UsersService usersService = new UsersService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    // 根据用户名查询当前用户信息
    Users user = usersService.getUserByName(userName);
    request.setAttribute("user", user);
    // 转发到 update.jsp
    request.getRequestDispatcher("/update.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String sex = request.getParameter("sex");
    String email = request.getParameter("email");

    Users user = new Users(userName, password, sex, email);
    usersService.updateUser(user);

    // 更新后重定向到查询页面
    response.sendRedirect(request.getContextPath() + "/QueryServlet");
  }
}