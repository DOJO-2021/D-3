<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ログイン</h1>
<p>※ID=DOJO, PW=password でログインできます。
<hr>
<form method="POST" action="/SymPany/LoginServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
<h2>アカウントをお持ちでないですか？</h2>
<form method="POST" action="/SymPany/LoginServlet">
</form>

</body>
</html>