package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

  private final UsersService usersService = new UsersService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    Users user = usersService.getUserByName(userName);

    if (user != null && user.getPassword().equals(password)) {
      HttpSession session = request.getSession();
      session.setAttribute("user", user); // ✅ 登录成功后将用户存入 session

      response.sendRedirect("index.jsp");
    } else {
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