<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany | マイページ</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
		<link rel="stylesheet" href="/SymPany/CSS/Second.css">
	</head>
	<body>

	<c:if test="${update}">
	<script type="text/javascript">
		alert("プロフィールを更新しました。");
	</script>
</c:if>
		<!-- ヘッダー -->
			<jsp:include page="header.jsp"></jsp:include>
			<jsp:include page ="follow.jsp"></jsp:include>
		<!-- ヘッダー ここまで -->
	<div class="bigrm">
	<h2>プロフィールの編集</h2>
	<c:forEach var="e" items="${profile}" >
		<form class="rm" method="POST" action="/SymPany/MypageServlet">
			<table class="mypage1">
		  <tr>
		   <td>
		    <input type ="hidden" name="user_id" value="${e.user_id}">
			<label class="mypage1">名前<br>
			<input type="text" name="name" class="mypage1" value="${e.name}" required>
			</label>
			</td>
			<td>
			<label class="mypage1">ニックネーム<br>
			<input type="text" name="nickname" class="mypage1"  value="${e.nickname}" required>
			</label>
			</td>
		  </tr>
		  <tr>
		   <td>
		    <label class="mypage1">出身地<br>
			<input type="text" name="birthplace" class="mypage1" value="${e.birthplace}"  required>
			</label>
		   </td>
		   <td>
		   <label class="mypage1">所属企業<br>
			<input type="text" name="company" class="mypage1" value="${e.company}" required>
			</label>
		   </td>
		  </tr>
		  <tr>
		   <td>
		     <label class="mypage1">誕生日<br>
			<input type="text" name="birth" class="mypage1" value="${e.birth}">
			</label>
		   </td>
		   <td>
		     <label class="mypage1">出身大学<br>
			<input type="text" name="school" class="mypage1" value="${e.school}" >
			</label>
		   </td>
		 </tr>
		 <tr>
		  <td>
		   <label class="mypage1">趣味<br>
				<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" class="mypage1">${e.hobby}</textarea>
			   </label>

		  </td>
		  <td>
		    <label class="mypage1">自己紹介文<br>
			<textarea rows="3″cols=”50″wrap="soft" type="text" name="intro" class="mypage1">${e.intro}</textarea>
			  </label>
		  </td>
		</table>
		<table>
			<tr>
				<td>
					<input type="submit" value="更　　新" class="mypage2"><br>
				</td>
			</tr>
		</table>
	</form>
	</c:forEach>
</div>
</body>
</html>