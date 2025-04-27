package hx.service;

import hx.dao.QuestionDAO;
import hx.entity.Question;
import hx.service.IQuestionService;

import java.sql.SQLException;
import java.util.List;

public class QuestionService implements IQuestionService {
  private final QuestionDAO dao = new QuestionDAO();

  @Override
  public void add(Question q) throws SQLException {
    dao.add(q);
  }

  @Override
  public List<Question> list() throws SQLException {
    return dao.list();
  }

  @Override
  public Question findById(int id) throws SQLException {
    return dao.findById(id);
  }

  @Override
  public void update(Question q) throws SQLException {
    dao.update(q);
  }

  @Override
  public void delete(int id) throws SQLException {
    dao.delete(id);
  }
  public List<Question> getRandomQuestions(int count) throws SQLException {
    return dao.getRandomQuestions(count);
  }}

