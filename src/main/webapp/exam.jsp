<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<body>
<h2>考试题目（共4题，每题25分）</h2>

<!-- 返回首页按钮 -->
<div style="margin-bottom: 20px;">
    <a href="index.jsp" target="_top">🏠 返回首页</a>
</div>

<form action="exam" method="post" target="_top">
    <c:forEach var="q" items="${questions}">
        <p>${q.title}</p>
        <input type="radio" name="answer_${q.questionId}" value="A"/>A. ${q.optionA}<br/>
        <input type="radio" name="answer_${q.questionId}" value="B"/>B. ${q.optionB}<br/>
        <input type="radio" name="answer_${q.questionId}" value="C"/>C. ${q.optionC}<br/>
        <input type="radio" name="answer_${q.questionId}" value="D"/>D. ${q.optionD}<br/><hr/>
    </c:forEach>
    <input type="submit" value="提交试卷"/>
</form>

</body>
</html>