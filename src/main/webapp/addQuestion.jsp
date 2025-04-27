<%@ page contentType="text/html;charset=UTF-8" %>
<html><head><title>添加试题</title></head><body>
<form action="${pageContext.request.contextPath}/question/add" method="post">
  题目：<input name="title"/><br/>
  A: <input name="optionA"/><br/>
  B: <input name="optionB"/><br/>
  C: <input name="optionC"/><br/>
  D: <input name="optionD"/><br/>
  正确答案：<select name="answer">
  <option>A</option><option>B</option><option>C</option><option>D</option>
</select><br/>
  <button type="submit">保存</button>
</form>
</body></html>