<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h2>用户注册</h2>
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    用户名：<input type="text" name="userName" /><br/>
    密 码：<input type="password" name="password" /><br/>
    性 别：<input type="radio" name="sex" value="男" checked />男
           <input type="radio" name="sex" value="女" />女 <br/>
    邮 箱：<input type="text" name="email" /><br/>
    <input type="submit" value="注册" />
    <input type="reset" value="重置" />
</form>
</body>
</html>