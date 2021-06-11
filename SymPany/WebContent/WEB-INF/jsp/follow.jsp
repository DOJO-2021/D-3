<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>フォローリスト</h2>
	<!-- ドロワーの入力、名前で展開 -->
<c:forEach var = "e" items ="${list}">
		<span>名前</span><input type="text" name="name" value="${e.name}"><br>
		<span>ニックネーム</span><input type="text" name="nickname"value="${e.nickname}"><br>
		<span>出身地</span><input type="text" name="birthplace"value="${e.birthplace}"><br>
		<span>所属企業</span><input type="text" name="company"value="${e.company}"><br>
		<span>誕生日</span><input type="text" name="birth"value="${e.birth}"><br>
		<span>出身大学</span><input type="text" name="school"value="${e.school}"><br>
		<span>趣味</span><input type="text" name="hobby"value="${e.hobby}"> <br>
		<span>自己紹介文</span><input type="text" name="intro"value="${e.intro}"><br>
</c:forEach>

</body>
</html>