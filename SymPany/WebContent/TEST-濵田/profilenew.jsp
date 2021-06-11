<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany|プロフィール新規登録</title>
		<link rel="stylesheet" href="/SymPany/CSS/First.css">
	</head>

	<body class="first">
	<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
	<h1>プロフィール新規登録</h1>
		<div class="first">
			<form method="POST" action="">
			<div class="pn">
			<input type="hidden" name="user_id" value ="<%session.getAttribute("user_id");%>">
			名前<input type="text" name="name" required autofocus><br>
			ニックネーム<input type="text" name="nickname" required><br>
			出身地<input type="text" name="birthplace" required><br>
			所属企業<input type="text" name="company" required><br>
			誕生日<input type="text" name="birth"><br>
			出身大学<input type="text" name="school"><br>
			趣味<input type="text" name="hobby"> <br>
			</div>
			自己紹介文<input type="text" name="intro"><br>
			<input type="submit" value="登録"><br>
			</form>
		</div>
	</body>
</html>