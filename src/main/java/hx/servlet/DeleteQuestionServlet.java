package hx.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hx.service.IQuestionService;
import hx.service.QuestionService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/question/delete")
public class DeleteQuestionServlet extends HttpServlet {
  private final IQuestionService service = new QuestionService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    try {
      service.delete(id);
      resp.sendRedirect(req.getContextPath() + "/question/list");
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }
}
