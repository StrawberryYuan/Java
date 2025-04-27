<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>考试系统菜单</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: "Segoe UI", sans-serif;
      background-color: #f9f9f9;
    }
    .sidebar {
      width: 220px;
      height: 100vh;
      background-color: #f0f0f0;
      padding: 20px;
      box-shadow: 2px 0 6px rgba(0,0,0,0.1);
    }
    h3 {
      color: #2e8b57;
      border-bottom: 1px solid #ccc;
      padding-bottom: 5px;
    }
    ul {
      list-style-type: none;
      padding-left: 0;
    }
    li {
      margin: 10px 0;
    }
    a {
      text-decoration: none;
      color: #333;
    }
    a:hover {
      color: #2e8b57;
    }
    .footer {
      margin-top: 20px;
      font-size: 14px;
      color: #2e8b57;
    }
  </style>
</head>
<body>
<div class="sidebar">
  <h3>用户管理</h3>
  <ul>
    <li><a href="register.jsp" target="main">注册用户</a></li>
    <li><a href="QueryServlet" target="main">查询用户</a></li>
  </ul>

  <h3>试题管理</h3>
  <ul>
    <li><a href="addQuestion.jsp" target="main">添加试题</a></li>
    <li><a href="question/list" target="main">查询试题</a></li>
  </ul>

  <h3>考试管理</h3>
  <ul>
    <li><a href="exam" target="main">参加考试</a></li>
    <li><a href="score.jsp" target="top">查看成绩</a></li>
  </ul>

  <div class="footer">
    当前在线人数：<%= hx.listener.UserSessionListener.getUserCount() %> 人
  </div>
</div>
</body>
</html>