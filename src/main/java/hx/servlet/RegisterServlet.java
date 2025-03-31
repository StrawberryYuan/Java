package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

  private UsersService usersService = new UsersService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String sex = request.getParameter("sex");
    String email = request.getParameter("email");

    Users user = new Users(userName, password, sex, email);
    boolean flag = usersService.registerUser(user);

//    if (flag) {
//      response.sendRedirect(request.getContextPath() + "/login.jsp");
//    } else {
//      request.setAttribute("msg", "注册失败，请重试");
//      request.getRequestDispatcher("/register.jsp").forward(request, response);
//    }
    if (flag) {
      // 注册成功
      // 带个参数 success=1 表示注册成功
      response.sendRedirect(request.getContextPath() + "/login.jsp?success=1");
    } else {
      // 注册失败
      request.setAttribute("msg", "注册失败，请重试");
      request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
  }
}