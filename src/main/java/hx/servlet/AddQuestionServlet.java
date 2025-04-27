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

@WebServlet("/question/add")
public class AddQuestionServlet extends HttpServlet {
  private final IQuestionService service = new QuestionService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Question q = new Question(
        null,
        req.getParameter("title"),
        req.getParameter("optionA"),
        req.getParameter("optionB"),
        req.getParameter("optionC"),
        req.getParameter("optionD"),
        req.getParameter("answer")
    );
    try {
      service.add(q);
      resp.sendRedirect(req.getContextPath() + "/question/list");
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }
}