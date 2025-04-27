package hx.dao;
import hx.util.JdbcUtil;
import hx.entity.Question;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
  // 添加试题
  public void add(Question q) throws SQLException {
    String sql = "INSERT INTO question(title, optionA, optionB, optionC, optionD, answer) VALUES(?,?,?,?,?,?)";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, q.getTitle());
      ps.setString(2, q.getOptionA());
      ps.setString(3, q.getOptionB());
      ps.setString(4, q.getOptionC());
      ps.setString(5, q.getOptionD());
      ps.setString(6, q.getAnswer());
      ps.executeUpdate();
    }
  }

  // 查询所有
  public List<Question> list() throws SQLException {
    String sql = "SELECT * FROM question";
    List<Question> list = new ArrayList<>();
    try (Connection conn = JdbcUtil.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        list.add(new Question(
            rs.getInt("questionId"),
            rs.getString("title"),
            rs.getString("optionA"),
            rs.getString("optionB"),
            rs.getString("optionC"),
            rs.getString("optionD"),
            rs.getString("answer")
        ));
      }
    }
    return list;
  }

  // 根据 ID 查询
  public Question findById(int id) throws SQLException {
    String sql = "SELECT * FROM question WHERE questionId=?";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new Question(
              rs.getInt("questionId"),
              rs.getString("title"),
              rs.getString("optionA"),
              rs.getString("optionB"),
              rs.getString("optionC"),
              rs.getString("optionD"),
              rs.getString("answer")
          );
        }
      }
    }
    return null;
  }

  // 更新
  public void update(Question q) throws SQLException {
    String sql = "UPDATE question SET title=?, optionA=?, optionB=?, optionC=?, optionD=?, answer=? WHERE questionId=?";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, q.getTitle());
      ps.setString(2, q.getOptionA());
      ps.setString(3, q.getOptionB());
      ps.setString(4, q.getOptionC());
      ps.setString(5, q.getOptionD());
      ps.setString(6, q.getAnswer());
      ps.setInt(7, q.getQuestionId());
      ps.executeUpdate();
    }
  }

  // 删除
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM question WHERE questionId=?";
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    }
  }
  public List<Question> getRandomQuestions(int count) throws SQLException {
    String sql = "SELECT * FROM question ORDER BY RAND() LIMIT ?";
    List<Question> list = new ArrayList<>();
    try (Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, count);
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          list.add(new Question(
              rs.getInt("questionId"),
              rs.getString("title"),
              rs.getString("optionA"),
              rs.getString("optionB"),
              rs.getString("optionC"),
              rs.getString("optionD"),
              rs.getString("answer")
          ));
        }
      }
    }
    return list;
  }
}
