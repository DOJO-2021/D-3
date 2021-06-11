<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|ログイン</title>
<link rel="stylesheet" href="/SymPany/CSS/First.css">
</head>
<body class="first">
<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
<h1>ログイン</h1>
<div class="first">
<form method="POST" action="/SymPany/LoginServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
<a href="/SymPany/LoginServlet">アカウントをお持ちでないですか？</a>

</div>
</body>
</html>