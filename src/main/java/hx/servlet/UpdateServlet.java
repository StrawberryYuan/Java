package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

  private final UsersService usersService = new UsersService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    Users user = usersService.getUserByName(userName);
    request.setAttribute("user", user);
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

    response.sendRedirect(request.getContextPath() + "/QueryServlet");
  }
}