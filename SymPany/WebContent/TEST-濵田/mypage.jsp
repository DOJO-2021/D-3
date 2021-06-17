<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany | マイページ</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
		<link rel="stylesheet" href="/SymPany/CSS/Second.css">
	</head>
	<body>
		<!-- ヘッダー -->
			<jsp:include page="header.jsp"></jsp:include>
		<!-- ヘッダー ここまで -->

		<!-- フォローリスト -->
		<jsp:include page="follow.jsp"></jsp:include>
	<div class="bigrm">
	<h2>プロフィールの編集</h2>
		<form class="rm" method="POST" action="">
		<table class="mypage1">
		  <tr>
		   <td>
			<label class="mypage1">名前<br>
			<input type="text" name="name" class="mypage1" required>
			</label>
			</td>
			<td>
			<label class="mypage1">ニックネーム<br>
			<input type="text" name="nickname" class="mypage1" required>
			</label>
			</td>
		  </tr>
		  <tr>
		   <td>
		    <label class="mypage1">出身地<br>
			<input type="text" name="birthplace" class="mypage1" required>
			</label>
		   </td>
		   <td>
		   <label class="mypage1">所属企業<br>
			<input type="text" name="company" class="mypage1" required>
			</label>
		   </td>
		  </tr>
		  <tr>
		   <td>
		     <label class="mypage1">誕生日<br>
			<input type="text" name="birth" class="mypage1">
			</label>
		   </td>
		   <td>
		     <label class="mypage1">出身大学<br>
			<input type="text" name="school" class="mypage1">
			</label>
		   </td>
		 </tr>
		 <tr>
		  <td>
		   <label class="mypage1">趣味<br>
				<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" class="mypage1"></textarea>
			   </label>

		  </td>
		  <td>
		    <label class="mypage1">自己紹介文<br>
			<textarea rows="3″cols=”50″wrap="soft" type="text" name="intro" class="mypage1"></textarea>
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
	  </div>
	</body>
</html>