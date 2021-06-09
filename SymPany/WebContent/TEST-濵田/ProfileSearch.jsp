<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィールの検索</title>
</head>
<body>
<form action="cgi-bin/example.cgi" method="post">
  <p>検索したいキーワードを入力してください。</p>
  <input type="search" name="seach" placeholder="キーワード入力してね！">
  <input type="submit" name="submit" value="検索">
</form>

<hr>

<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/SymPany/UpdateDeleteServlet">
	名前、ニックネーム<input type="text" name="NAME" value="${e.company}"><br>
	出身地<input type="text" name="BIRTHPLACE" value="${e.department}"><br>
	所属企業<input type="text" name="COMPANY" value="${e.name}"><br>
	誕生日<input type="text" name="BIRTH" value="${e.zipcode}"><br>
	出身大学<input type="text" name="SCHOOL" value="${e.address}"><br>
	趣味<input type="text" name="HOBBY" value="${e.phone}"><br>
	自己紹介文<input type="text" name="INTRO" value="${e.remarks}"><br>
	<input type="submit" name="SUBMIT" value="更新">
	<input type="submit" name="SUBMIT" value="削除"><br>
	</form>
	<hr>

<a href= >フォロワーに追加</a>
</body>
</html>