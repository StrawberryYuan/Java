package hx.service;

import hx.entity.Question;
import java.sql.SQLException;
import java.util.List;

public interface IQuestionService {
  void add(Question q) throws SQLException;
  List<Question> list() throws SQLException;
  Question findById(int id) throws SQLException;
  void update(Question q) throws SQLException;
  void delete(int id) throws SQLException;
}