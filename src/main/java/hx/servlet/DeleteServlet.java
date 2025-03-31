package hx.servlet;

import hx.service.UsersService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
  private UsersService usersService = new UsersService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 这里假设传参方式是 ?userName=xxx
    String userName = request.getParameter("userName");
    if (userName != null) {
      usersService.deleteUser(userName);
    }
    // 删除后重定向到查询页面，刷新列表
    response.sendRedirect(request.getContextPath() + "/QueryServlet");
  }
}