<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>删除用户</title>
</head>
<body>
<h2>删除用户</h2>
<form action="${pageContext.request.contextPath}/DeleteServlet" method="get">
  用户名：<input type="text" name="userName" required/><br/><br/>
  <input type="submit" value="删除"/>
</form>
</body>
</html>