package hx.servlet;

import hx.entity.Users;
import hx.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {

  private final UsersService usersService = new UsersService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);
    if (session == null) {
      response.sendRedirect("login.jsp");
      return;
    }

    Users currentUser = (Users) session.getAttribute("user");
    if (currentUser == null) {
      response.sendRedirect("login.jsp");
      return;
    }

    if ("admin".equalsIgnoreCase(currentUser.getUserName())) {
      List<Users> userList = usersService.getAllUsers();
      request.setAttribute("userList", userList);
      request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
    } else {
      Users single = usersService.getUserByName(currentUser.getUserName());
      request.setAttribute("personalUser", single);
      request.getRequestDispatcher("/personalinfo.jsp").forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}