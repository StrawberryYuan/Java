<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h2>用户登录</h2>

<!-- 显示错误提示（如果有） -->
<%
    String msg = (String) request.getAttribute("msg");
    if(msg != null){
%>
    <p style="color:red;"><%= msg %></p>
<%
    }
%>
<%
    String successParam = request.getParameter("success");
    if ("1".equals(successParam)) {
%>
<p style="color:green;">注册成功，请登录！</p>
<%
    }
%>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    <label for="userName">用户名：</label>
    <input type="text" name="userName" id="userName" required/><br/><br/>

    <label for="password">密 码：</label>
    <input type="password" name="password" id="password" required/><br/><br/>

    <input type="submit" value="登录"/>
</form>

<p>还没有账号？<a href="${pageContext.request.contextPath}/register.jsp">立即注册</a></p>
</body>
</html>