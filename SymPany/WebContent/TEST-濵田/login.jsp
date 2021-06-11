<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | ログイン</title>
<link rel="stylesheet" href="/SymPany/CSS/First.css">
</head>
<body>

<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
<div class="first">
<h1>ログイン</h1>
<form class="la" method="POST" action="/SymPany/LoginServlet" >
<table>
 <tr>
  <td>
	ID<input type="text" name="ID" required autofocus><br>
  </td>
 </tr>
 <tr>
  <td>
	PW<input type="password" name="PW" required ><br>
  </td>
 </tr>
</table>
<table>
 <tr>
  <td>
	<input type="submit" name="LOGIN" value="ログイン">
  </td>
 </tr>
</table>
</form>
<h4>アカウントをお持ちでないですか？▶<a href="/SymPany/AccountServlet">新規登録</a></h4>

</div>
</body>
</html>