<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany|プロフィール新規登録</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
	</head>

	<body>
		<form method="POST" action="">
		<span>名前</span><input type="text" name="name" required><br>
		<span>ニックネーム</span><input type="text" name="nickname" required><br>
		<span>出身地</span><input type="text" name="birthplace"><br>
		<span>所属企業</span><input type="text" name="company"><br>
		<span>誕生日</span><input type="text" name="birth"><br>
		<span>出身大学</span><input type="text" name="school"><br>
		<span>趣味</span><input type="text" name="hobby"> <br>
		<span>自己紹介文</span><input type="text" name="intro"><br>
		<input type="submit" value="登録"><br>
		</form>
	</body>
</html>