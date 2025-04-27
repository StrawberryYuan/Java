<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="hx.entity.Users" %>
<%
  Users u = (Users) request.getAttribute("personalUser");
%>
<h2>欢迎，<%= u.getUserName() %></h2>
<p>用户ID：<%= u.getUserId() %></p>
<p>性别：<%= u.getSex() %></p>
<p>邮箱：<%= u.getEmail() %></p>