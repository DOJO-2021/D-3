<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<iframe  src="/SymPany/FollowServlet" name="follow" width="200" height="500" align="left" ></iframe>

	<h2>プロフィールの編集</h2>
	<c:forEach var="e" items="${profile}" >
		<form method="POST" action="/SymPany/MypageServlet">
		<table>
		  <tr>
		   <td>
		   <input type ="hidden" name="user_id" value="${e.user_id}">
			名前<input type="text" name="name" value="${e.name}" required><br>
			</td>
			<td>
			ニックネーム<input type="text" name="nickname" value="${e.nickname}" required><br>
			</td>
		  </tr>
		  <tr>
		   <td>
			出身地<input type="text" name="birthplace" value="${e.birthplace}" ><br>
		   </td>
		   <td>
			所属企業<input type="text" name="company" value="${e.company}" ><br>
		   </td>
		  </tr>
		  <tr>
		   <td>
			誕生日<input type="text" name="birth" value="${e.birth}" ><br>
		   </td>
		   <td>
			出身大学<input type="text" name="school" value="${e.school}" ><br>
		   </td>
		 </tr>
		 <tr>
		  <td>
			趣味<input type="text" name="hobby" value="${e.hobby}" > <br>
		  </td>
		  <td>
			自己紹介文<input type="text" name="intro" value="${e.intro}" ><br>
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
		</c:forEach>
	</body>
</html>