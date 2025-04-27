package hx.servlet;

import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

  private final UsersService usersService = new UsersService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    if (userName != null) {
      usersService.deleteUser(userName);
    }
    response.sendRedirect(request.getContextPath() + "/QueryServlet");
  }
}