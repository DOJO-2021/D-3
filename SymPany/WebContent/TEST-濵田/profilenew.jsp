<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany|プロフィール新規登録</title>

		<link rel="stylesheet" href="/SymPany/CSS/First.css">

	</head>

	<body class="first">
	<div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
	<h1>プロフィール新規登録</h1>
		<div class="first">
			<form method="POST" action="">
			<table class="first">
			<tr>
			 <td>
			  <label>名前<br>
			  <input type="text" name="name" required autofocus>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>ニックネーム<br>
				<input type="text" name="nickname" required>
			  </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label>出身地<br>
				<input type="text" name="birthplace" required>
			 </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label>所属企業<br>
				<input type="text" name="company" required>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>誕生日<br>
				<input type="text" name="birth">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>出身大学<br>
				<input type="text" name="school">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>趣味<br>
				<input type="text" name="hobby">
			   </label>
			 </td>
			</tr>

			<tr>
			 <td>
			  <label>自己紹介文<br>
			<input type="text" name="intro">
			  </label>
			 </td>
			</tr>
			</table>
			<table id="login">
			<tr>
			 <td>
			<input type="submit" value="登録"><br>
			 </td>
			</tr>
			</table>
			</form>
		</div>
	</body>
</html>