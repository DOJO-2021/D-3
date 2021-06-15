<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany | マイページ</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
	</head>
	<body>
		<!-- ヘッダー -->
			<jsp:include page="header.jsp"></jsp:include>
		<!-- ヘッダー ここまで -->
	<!-- iframe  src="follow.jsp" name="sample" width="200" height="500" align="left" -->

	<h2>プロフィールの編集</h2>
		<form method="POST" action="">
		<table>
		  <tr>
		   <td>
			名前<input type="text" name="name" required><br>
			</td>
			<td>
			ニックネーム<input type="text" name="nickname" required><br>
			</td>
		  </tr>
		  <tr>
		   <td>
			出身地<input type="text" name="birthplace"><br>
		   </td>
		   <td>
			所属企業<input type="text" name="company"><br>
		   </td>
		  </tr>
		  <tr>
		   <td>
			誕生日<input type="text" name="birth"><br>
		   </td>
		   <td>
			出身大学<input type="text" name="school"><br>
		   </td>
		 </tr>
		 <tr>
		  <td>
			趣味<input type="text" name="hobby"> <br>
		  </td>
		  <td>
			自己紹介文<input type="text" name="intro"><br>
		  </td>
		</table>
		<table>
		 <tr>
		  <td>
		<input type="submit" value="更新"><br>
		  </td>
		 </tr>
		</table>
		</form>
	</body>
</html>