<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="pink">
		<form class="la" method="POST" action="/SymPany/LoginServlet" >
			<table class="first">
	 			<tr>
	  				<td>
						<label>ID<br>
							<input type="text" name="ID" required autofocus><br>
	  					</label>
	  				</td>
	 			</tr>
	 			<tr>
	  				<td>
						<label>	PW<br>
							<input type="password" name="PW" required ><br>
	  					</label>
	  				</td>
	 			</tr>
			</table>
			<table id="login">
	 			<tr>
	 				 <td>
						<input type="submit" name="LOGIN" value="ログイン">
	  				</td>
	 			</tr>
			</table>
		</form>
			<h4>アカウントをお持ちでないですか？
			▶<a href="/SymPany/AccountNewServlet">新規登録</a></h4>
			<c:if test="${error}">
			<c:if test="${!login}">
			<h3 class="error">※ＩＤまたはパスワードが正しくありません※</h3>
			</c:if>
			</c:if>
			</div>
		</div>
	</body>
</html>