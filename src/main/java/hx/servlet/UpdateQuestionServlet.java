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

@WebServlet("/question/update")
public class UpdateQuestionServlet extends HttpServlet {
  private final IQuestionService service = new QuestionService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String idStr = req.getParameter("id");
    if (idStr == null || idStr.isBlank()) {
      resp.sendRedirect(req.getContextPath() + "/question/list");
      return;
    }
    int id = Integer.parseInt(idStr);
    try {
      Question q = service.findById(id);
      if (q == null) {
        resp.sendRedirect(req.getContextPath() + "/question/list");
        return;
      }
      req.setAttribute("q", q);
      req.getRequestDispatcher("/editQuestion.jsp").forward(req, resp);
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    int id = Integer.parseInt(req.getParameter("id"));
    Question q = new Question(
        id,
        req.getParameter("title"),
        req.getParameter("optionA"),
        req.getParameter("optionB"),
        req.getParameter("optionC"),
        req.getParameter("optionD"),
        req.getParameter("answer")
    );
    try {
      service.update(q);
      resp.sendRedirect(req.getContextPath() + "/question/list");
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }
}