<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|ログイン</title>
<link rel="stylesheet" href="/SymPany/CSS/First.css">
</head>
<body>

<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
<div class="first">
<h1>ログイン</h1>
<form class="la" method="POST" action="/SymPany/LoginServlet" >
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
<h4>アカウントをお持ちでないですか？<a href="/SymPany/AccountServlet">新規登録</a></h4>

</div>
</body>
</html>