<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|アカウント新規登録</title>
<link rel="stylesheet" href="/SymPany/CSS/First.css">
</head>
<body class="first">
<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
<h1>新規登録</h1>
<div class="first">
<form method="POST" action="/SymPany/LoginServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
<h4>アカウントをお持ちですか？<a href="/SymPany/LoginServlet">ログイン</a></h4>

</div>
</body>
</html>