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
		<table>
		  <tr>
		   <td>
			<label>名前<br>
			<input type="text" name="name" required>
			</label>
			</td>
			<td>
			<label>ニックネーム<br>
			<input type="text" name="nickname" required>
			</label>
			</td>
		  </tr>
		  <tr>
		   <td>
		    <label>出身地<br>
			<input type="text" name="birthplace">
			</label>
		   </td>
		   <td>
		   <label>所属企業<br>
			<input type="text" name="company">
			</label>
		   </td>
		  </tr>
		  <tr>
		   <td>
		     <label>誕生日<br>
			<input type="text" name="birth">
			</label>
		   </td>
		   <td>
		     <label>出身大学<br>
			<input type="text" name="school">
			</label>
		   </td>
		 </tr>
		 <tr>
		  <td>
		   <label>趣味<br>
				<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" ></textarea>
			   </label>

		  </td>
		  <td>
		    <label>自己紹介文<br>
			<textarea rows="3″cols=”50″wrap="soft" type="text" name="intro"></textarea>
			  </label>
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
	  </div>
	</body>
</html>