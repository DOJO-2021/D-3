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
	<c:forEach var="e" items="${list}">
		<c:forEach var="f" items="${e}">
			<span>名前:</span>${f.name}<br>
			<span>ニックネーム:</span>${f.nickname}<br>
			<span>出身地:</span>${f.birthplace}<br>
			<span>所属企業:</span>${f.company}<br>
			<span>誕生日:</span>${f.birth}<br>
			<span>出身学校:</span>${f.school}<br>
			<span>趣味:</span>${f.hobby} <br>
			<span>自己紹介文:</span>${f.intro}<br>
		</c:forEach>
	</c:forEach>
</body>
</html>