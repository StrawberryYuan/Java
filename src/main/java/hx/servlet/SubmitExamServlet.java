package hx.servlet;

import hx.entity.Question;
import hx.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/submitExam")
public class SubmitExamServlet extends HttpServlet {
  private final QuestionService service = new QuestionService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int score = 0;
    try {
      List<Question> questions = service.getRandomQuestions(4);
      for (Question q : questions) {
        String ans = req.getParameter("answer_" + q.getQuestionId());
        if (ans != null && ans.equalsIgnoreCase(q.getAnswer())) {
          score += 25;
        }
      }
      HttpSession session = req.getSession();
      session.setAttribute("score", score);

      // 直接跳转到 score.jsp
      resp.sendRedirect("score.jsp");
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }
}