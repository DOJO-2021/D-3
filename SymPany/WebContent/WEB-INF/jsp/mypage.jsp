<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page import = "model.User" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%ArrayList<User> use =(ArrayList<User>)request.getAttribute("profile"); %>
		<!-- ヘッダー -->
<jsp:include page="header.jsp"></jsp:include>
		<!-- ヘッダー ここまで -->
 <iframe  src="/SymPany/FollowServlet" name="sample" width="200" height="500" align="left"></iframe>
	<h2>プロフィールの編集</h2>
		<form method="POST" action="/SymPany/MypageServlet">
		<input type ="hidden" name="user_id" value="<%=(String)session.getAttribute("user_id")%>">
		<span>名前</span><input type="text" name="name"  value="<%=use.get(0).getName()%>"required><br>
		<span>ニックネーム</span><input type="text" name="nickname" value="<%=use.get(0).getNickname()%>" required><br>
		<span>出身地</span><input type="text" name="birthplace" value="<%=use.get(0).getBirthplace()%>" ><br>
		<span>所属企業</span><input type="text" name="company" value="<%=use.get(0).getCompany()%>" ><br>
		<span>誕生日</span><input type="text" name="birth" value="<%=use.get(0).getBirth()%>" ><br>
		<span>出身大学</span><input type="text" name="school" value="<%=use.get(0).getSchool()%>" ><br>
		<span>趣味</span><input type="text" name="hobby" value="<%=use.get(0).getHobby()%>" > <br>
		<span>自己紹介文</span><input type="text" name="intro" value="<%=use.get(0).getIntro()%>" ><br>
		<input type="submit" value="更新"><br>
		</form>
	</body>
</html>