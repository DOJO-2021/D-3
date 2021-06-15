<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|プロフィール検索</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Third.css">
</head>

<body>
<!-- ヘッダー -->
<jsp:include page="header.jsp"></jsp:include>
<!-- ヘッダー ここまで -->
<h1>プロフィール検索</h1>
<form action="cgi-bin/example.cgi" method="post">
  <table class="Third">
  <tr>
   <td>
  <input type="search" name="seach" placeholder="出身地や趣味などを入力してみよう">
   </td>
   <td>
  <input type="submit" name="submit" value="検索">
   </td>
  </tr>
  </table>
</form>

 <div id="test">

 </div>
	<div class="pink">
	<form method="POST" action="/SymPany/UpdateDeleteServlet">
	<table>
	 <tr>
	  <td>
	    <label>名前<br>
		 <input type="text" name="name" value="${e.name}">
		</label>
	  </td>
	  <td>
	    <label>ニックネーム<br>
		<input type="text" name="nickname" value="${e.nikname}">
		</label>
	  </td>
	 </tr>
	 <tr>
	  <td>
	    <label>出身地<br>
		<input type="text" name="birthplace" value="${e.birthplace}">
		</label>
	   </td>
	   <td>
		<label>所属企業<br>
		<input type="text" name="company" value="${e.company}">
		</label>
	  </td>
	</tr>
	<tr>
	  <td>
	    <label>誕生日<br>
			<input type="text" name="birth" value="${e.birth}">
		</label>
	   </td>
	   <td>
		<label>出身大学<br>
			<input type="text" name="school" value="${e.school}">
		</label>
	  </td>
	</tr>
	<tr>
	  <td>
	    <label>趣味<br>
		  <textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" value="${e.hobby}"></textarea>
		</label>
	  </td>
	  <td>
	    <label>自己紹介文<br>
		  <textarea rows="3″cols=”50″wrap="soft" name="intro" value="${e.intro}"></textarea>
		</label>
	  </td>
	</tr>
	</table>
	<table id="submit">
	 <tr>
	  <td>
	   <input type="submit" name="submit" value="フォローする">
	  </td>
	 </tr>
	</table>
	</form>
  </div>
  <div class="pink">
	<form method="POST" action="/SymPany/UpdateDeleteServlet">
	<table>
	 <tr>
	  <td>
	    <label>名前<br>
		 <input type="text" name="name" value="${e.name}">
		</label>
	  </td>
	  <td>
	    <label>ニックネーム<br>
		<input type="text" name="nickname" value="${e.nikname}">
		</label>
	  </td>
	 </tr>
	 <tr>
	  <td>
	    <label>出身地<br>
		<input type="text" name="birthplace" value="${e.birthplace}">
		</label>
	   </td>
	   <td>
		<label>所属企業<br>
		<input type="text" name="company" value="${e.company}">
		</label>
	  </td>
	</tr>
	<tr>
	  <td>
	    <label>誕生日<br>
			<input type="text" name="birth" value="${e.birth}">
		</label>
	   </td>
	   <td>
		<label>出身大学<br>
			<input type="text" name="school" value="${e.school}">
		</label>
	  </td>
	</tr>
	<tr>
	  <td>
	    <label>趣味<br>
		  <textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" value="${e.hobby}"></textarea>
		</label>
	  </td>
	  <td>
	    <label>自己紹介文<br>
		  <textarea rows="3″cols=”50″wrap="soft" name="intro" value="${e.intro}"></textarea>
		</label>
	  </td>
	</tr>
	</table>
	<table id="submit">
	 <tr>
	  <td>
	   <input type="submit" name="submit" value="フォローする">
	  </td>
	 </tr>
	</table>
	</form>
  </div>

   <div class="pink">
	<form method="POST" action="/SymPany/UpdateDeleteServlet">
	<table>
	 <tr>
	  <td>
	    <label>名前<br>
		 <input type="text" name="name" value="${e.name}">
		</label>
	  </td>
	  <td>
	    <label>ニックネーム<br>
		<input type="text" name="nickname" value="${e.nikname}">
		</label>
	  </td>
	 </tr>
	 <tr>
	  <td>
	    <label>出身地<br>
		<input type="text" name="birthplace" value="${e.birthplace}">
		</label>
	   </td>
	   <td>
		<label>所属企業<br>
		<input type="text" name="company" value="${e.company}">
		</label>
	  </td>
	</tr>
	<tr>
	  <td>
	    <label>誕生日<br>
			<input type="text" name="birth" value="${e.birth}">
		</label>
	   </td>
	   <td>
		<label>出身大学<br>
			<input type="text" name="school" value="${e.school}">
		</label>
	  </td>
	</tr>
	<tr>
	  <td>
	    <label>趣味<br>
		  <textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" value="${e.hobby}"></textarea>
		</label>
	  </td>
	  <td>
	    <label>自己紹介文<br>
		  <textarea rows="3″cols=”50″wrap="soft" name="intro" value="${e.intro}"></textarea>
		</label>
	  </td>
	</tr>
	</table>
	<table id="submit">
	 <tr>
	  <td>
	   <input type="submit" name="submit" value="フォローする">
	  </td>
	 </tr>
	</table>
	</form>
  </div>
</body>
</html>