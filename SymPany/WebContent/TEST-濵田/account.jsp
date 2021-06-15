<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | アカウント新規登録</title>
<link rel="stylesheet" href="/SymPany/CSS/First.css">
</head>
<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
<div class="first">
<h1>新規登録</h1>
<div class="first">

<form class="la" method="POST" action="/SymPany/LoginServlet">
<table class="first">
<tr>
 <td>
   <label>ID<br>
   <input type="text" name="ID" required autofocus>
   </label>
 </td>
</tr>
<tr>
 <td>
   <label>PW<br>
   <input type="password" name="PW" required>
   </label>
 </td>
</tr>
</table>
<table id="login">
<tr>
 <td>
<input type="submit" name="LOGIN" value="登録">
 </td>
</tr>
</table>
</form>
<h4>アカウントをお持ちですか？▶<a href="/SymPany/LoginServlet">ログイン</a></h4>
</div>
</div>
</body>
</html>