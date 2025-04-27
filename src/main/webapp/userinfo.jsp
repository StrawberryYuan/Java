<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, hx.entity.Users" %>
<html>
<head><title>所有用户</title></head>
<body>
<h2>管理员 - 所有用户信息</h2>
<table border="1">
    <tr>
        <th>ID</th><th>用户名</th><th>性别</th><th>邮箱</th><th>操作</th>
    </tr>
    <%
        List<Users> userList = (List<Users>) request.getAttribute("userList");
        if (userList != null) {
            for (Users u : userList) {
    %>
    <tr>
        <td><%=u.getUserId()%></td>
        <td><%=u.getUserName()%></td>
        <td><%=u.getSex()%></td>
        <td><%=u.getEmail()%></td>
        <td>
            <a href="UpdateServlet?userName=<%=u.getUserName()%>">更新</a>
            <a href="DeleteServlet?userName=<%=u.getUserName()%>">删除</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="5">暂无用户数据</td></tr>
    <%
        }
    %>
</table>
</body>
</html>