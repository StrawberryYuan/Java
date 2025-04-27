<%@ page contentType="text/html;charset=UTF-8" %>
<html><head><title>编辑试题</title></head><body>
<form action="${pageContext.request.contextPath}/question/update" method="post">
  <input type="hidden" name="id" value="${q.questionId}"/>
  题目：<input name="title" value="${q.title}"/><br/>
  A: <input name="optionA" value="${q.optionA}"/><br/>
  B: <input name="optionB" value="${q.optionB}"/><br/>
  C: <input name="optionC" value="${q.optionC}"/><br/>
  D: <input name="optionD" value="${q.optionD}"/><br/>
  正确答案：<select name="answer">
  <option${q.answer=='A'?' selected':''}>A</option>
  <option${q.answer=='B'?' selected':''}>B</option>
  <option${q.answer=='C'?' selected':''}>C</option>
  <option${q.answer=='D'?' selected':''}>D</option>
</select><br/>
  <button type="submit">更新</button>
</form>
</body></html>
