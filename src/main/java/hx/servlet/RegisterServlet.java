package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet({"/RegisterServlet", "/register"})
public class RegisterServlet extends HttpServlet {

  private final UsersService usersService = new UsersService();

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

    if (flag) {
      response.sendRedirect(request.getContextPath() + "/login.jsp?success=1");
    } else {
      request.setAttribute("msg", "注册失败，请重试");
      request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
  }
}