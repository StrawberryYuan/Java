<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page import="java.util.List, hx.entity.Users" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>用户信息</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>用户信息列表</h2>--%>

<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>用户ID</th>--%>
<%--        <th>用户名</th>--%>
<%--        <th>性别</th>--%>
<%--        <th>邮箱</th>--%>
<%--        <th>操作</th>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        List<Users> userList = (List<Users>) request.getAttribute("userList");--%>
<%--        if(userList != null){--%>
<%--            for(Users u : userList){--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%=u.getUserId()%></td>--%>
<%--        <td><%=u.getUserName()%></td>--%>
<%--        <td><%=u.getSex()%></td>--%>
<%--        <td><%=u.getEmail()%></td>--%>
<%--        <td>--%>
<%--            <!-- 注意，这里改为传 userName 做删除和更新 -->--%>
<%--            <a href="${pageContext.request.contextPath}/UpdateServlet?userName=<%=u.getUserName()%>">更新</a>--%>
<%--            <a href="${pageContext.request.contextPath}/DeleteServlet?userName=<%=u.getUserName()%>">删除</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--            }--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, hx.entity.Users" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<h2>管理员 - 所有用户信息</h2>
<table border="1">
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>操作</th>
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
            <!-- 如果需要更新/删除功能 -->
            <a href="${pageContext.request.contextPath}/UpdateServlet?userName=<%=u.getUserName()%>">更新</a>
            <a href="${pageContext.request.contextPath}/DeleteServlet?userName=<%=u.getUserName()%>">删除</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>