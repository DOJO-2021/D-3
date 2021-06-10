<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|アカウント新規登録</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
</head>
<body class="first">
<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
<h1>新規登録</h1>
<form method="POST" action="/SymPany/LoginServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
<h2>アカウントをお持ちですか？</h2>
<form method="POST" action="/SymPany/LoginServlet">
<a href= >ログイン</a>
</form>

</body>
</html>