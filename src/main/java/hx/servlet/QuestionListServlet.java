package hx.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hx.entity.Question;
import hx.service.IQuestionService;
import hx.service.QuestionService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/question/list")
public class QuestionListServlet extends HttpServlet {
  private final IQuestionService service = new QuestionService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      List<Question> list = service.list();
      req.setAttribute("questions", list);
      req.getRequestDispatcher("/questionList.jsp").forward(req, resp);
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }
}