<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hx.entity.Users" %>
<html>
<head>
  <title>个人信息</title>
</head>
<body>
<h2>个人信息</h2>
<%
  Users personalUser = (Users) request.getAttribute("personalUser");
  if (personalUser == null) {
    out.println("<p style='color:red;'>无法获取用户信息</p>");
    return;
  }
%>
<table border="1">
  <tr><th>用户ID</th><td><%= personalUser.getUserId() %></td></tr>
  <tr><th>用户名</th><td><%= personalUser.getUserName() %></td></tr>
  <tr><th>性别</th><td><%= personalUser.getSex() %></td></tr>
  <tr><th>邮箱</th><td><%= personalUser.getEmail() %></td></tr>
</table>
<!-- 若允许普通用户更新自己 -->
<a href="${pageContext.request.contextPath}/UpdateServlet?userName=<%= personalUser.getUserName() %>">更新个人信息</a>
</body>
</html>