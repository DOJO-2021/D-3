<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|ログイン</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
</head>
<body>
<h1>ログイン</h1>
<hr>
<form method="POST" action="/LoginServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
<h2>アカウントをお持ちでないですか？</h2>
<form method="POST" action="/SymPany/LoginServlet">
<a href= >新規登録</a>
</form>

</body>
</html>