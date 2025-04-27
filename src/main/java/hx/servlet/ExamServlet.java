package hx.servlet;

import hx.entity.Question;
import hx.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/exam")
public class ExamServlet extends HttpServlet {

  private final QuestionService service = new QuestionService();

  /**
   * 展示考试题目
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      // 随机抽取 4 道题
      List<Question> questions = service.getRandomQuestions(4);

      // 保存到 session，确保判分时是这些题
      HttpSession session = req.getSession();
      session.setAttribute("examQuestions", questions);

      // 展示给用户
      req.setAttribute("questions", questions);
      req.getRequestDispatcher("/exam.jsp").forward(req, resp);

    } catch (SQLException e) {
      throw new ServletException("获取考试题目失败", e);
    }
  }

  /**
   * 提交考试答案，判分，跳转到得分页
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int score = 0;

    HttpSession session = req.getSession();
    List<Question> questions = (List<Question>) session.getAttribute("examQuestions");

    if (questions == null) {
      // 题目为空，重定向回考试页
      resp.sendRedirect("exam");
      return;
    }

    for (Question q : questions) {
      String userAnswer = req.getParameter("answer_" + q.getQuestionId());
      if (userAnswer != null && userAnswer.equalsIgnoreCase(q.getAnswer())) {
        score += 25;
      }
    }

    session.setAttribute("score", score); // 保存分数
    resp.sendRedirect("score.jsp");       // ✅ 跳转成绩页
  }
}