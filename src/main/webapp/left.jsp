<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>左侧菜单</title>
  <style>
    body {
      margin: 10px;
      font-family: "Microsoft YaHei", sans-serif;
    }
    ul {
      list-style-type: disc;
      padding-left: 20px;
    }
    li {
      margin: 8px 0;
    }
    a {
      text-decoration: none;
      color: #333;
    }
    a:hover {
      color: #007BFF;
    }
  </style>
</head>
<body>
<ul>
  <li><a href="login.jsp" target="mainFrame">登录</a></li>
  <li><a href="register.jsp" target="mainFrame">注册</a></li>
  <li><a href="${pageContext.request.contextPath}/QueryServlet" target="mainFrame">查询</a></li>
  <li><a href="deleteUser.jsp" target="mainFrame">删除</a></li>
</ul>
</body>
</html>