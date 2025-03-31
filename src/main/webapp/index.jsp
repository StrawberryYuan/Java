<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>用户管理系统</title>
</head>
<!-- 将页面分为左右两列，左侧为菜单，右侧为主内容区域 -->
<frameset cols="200,*">
  <!-- 左侧菜单 -->
  <frame src="left.jsp" name="menuFrame" />
  <!-- 右侧主内容区，默认显示登录页面 -->
  <frame src="login.jsp" name="mainFrame" />
</frameset>
</html>