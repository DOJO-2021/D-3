<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany | アカウント新規登録</title>
		<link rel="stylesheet" href="/SymPany/CSS/First.css">
	</head>
	<body>

		<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
		<div class="first">

		<h1>新規登録</h1>
		<div class="pink">
		<form class="la" method="POST"
			action="/SymPany/AccountNewServlet">
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
						<input type="submit" name="LOGIN" value="登　　録">
 					</td>
				</tr>
			</table>
		</form>
		<h4>アカウントをお持ちですか？▶<a
			href="/SymPany/LoginServlet">ログイン</a></h4>
			<!-- 何かしらの原因で登録に失敗した場合ここが表示される -->
			<c:if test="${error}">
			<c:if test="${!login}">
			<h3 class="error">※そのＩＤは既に使用されています※</h3>
			</c:if>
			</c:if>
		</div>
		</div>
	</body>
</html>