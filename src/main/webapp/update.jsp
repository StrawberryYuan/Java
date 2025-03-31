<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hx.entity.Users" %>
<html>
<head>
    <title>更新用户信息</title>
</head>
<body>
<h2>更新用户信息</h2>
<%
    Users user = (Users) request.getAttribute("user");
    if (user == null) {
        out.println("未找到用户信息！");
        return;
    }
%>
<form action="${pageContext.request.contextPath}/UpdateServlet" method="post">
    用户名：<input type="text" name="userName" value="<%=user.getUserName()%>" readonly /><br/>
    密 码：<input type="password" name="password" value="<%=user.getPassword()%>" /><br/>
    性 别：
    <input type="radio" name="sex" value="男" <%= "男".equals(user.getSex()) ? "checked" : "" %>/>男
    <input type="radio" name="sex" value="女" <%= "女".equals(user.getSex()) ? "checked" : "" %>/>女<br/>
    邮 箱：<input type="text" name="email" value="<%=user.getEmail()%>" /><br/>
    <input type="submit" value="更新"/>
</form>
</body>
</html>