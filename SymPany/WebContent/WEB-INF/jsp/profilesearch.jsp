<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|プロフィール検索</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="/SymPany/ProfileSearchServlet" method="post">
  <p>検索したいキーワードを入力してください。</p>
  <input type="text" name="search"  id ="name" placeholder="キーワード入力してね！"  value="${search}">
  <input type="submit" name="submit" value="検索">
</form>

<hr>

<c:forEach var="e" items="${list}" >
	<form method="POST" action="/SymPany/UpdateDeleteServlet">
	<input type="hidden" name = "user_id" value="${e.user_id}">
	名前<input type="text" name="name" value="${e.name}"><br>
	ニックネーム<input type="text" name="nickname" value="${e.nickname}"><br>
	出身地<input type="text" name="birthplace" value="${e.birthplace}"><br>
	所属企業<input type="text" name="company" value="${e.company}"><br>
	誕生日<input type="text" name="birth" value="${e.birth}"><br>
	出身大学<input type="text" name="school" value="${e.school}"><br>
	趣味<input type="text" name="hobby" value="${e.hobby}"><br>
	自己紹介文<input type="text" name="intro" value="${e.intro}"><br>
	<a href= >フォロワーに追加</a>
	<input type="submit" name="submit" value="フォロワーに追加">
	</form>
	<hr>
</c:forEach>
</body>
</html>