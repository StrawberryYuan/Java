<%@ page contentType="text/html;charset=UTF-8" %>
<html><head><title>试题列表</title></head><body>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>试题列表</h2>
<a href="${pageContext.request.contextPath}/addQuestion.jsp">添加新试题</a>
<table border="1">
    <tr><th>ID</th><th>题目</th><th>A</th><th>B</th><th>C</th><th>D</th><th>答案</th><th>操作</th></tr>
    <c:forEach var="q" items="${questions}">
        <tr>
            <td>${q.questionId}</td>
            <td>${q.title}</td>
            <td>${q.optionA}</td>
            <td>${q.optionB}</td>
            <td>${q.optionC}</td>
            <td>${q.optionD}</td>
            <td>${q.answer}</td>
            <td>
                <a href="${pageContext.request.contextPath}/question/update?id=${q.questionId}">编辑</a>
                <a href="${pageContext.request.contextPath}/question/delete?id=${q.questionId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body></html>