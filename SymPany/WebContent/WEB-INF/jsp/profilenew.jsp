<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany|プロフィール新規検索</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
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

					名前<input type="text" name="NAME" value="${e.name}"><br>
					ニックネーム<input type="text" name="NIKNAME" value="${e.nikname}"><br>
					出身地<input type="text" name="BIRTHPLACE" value="${e.birthplace}"><br>
					所属企業<input type="text" name="COMPANY" value="${e.company}"><br>
					誕生日<input type="text" name="BIRTH" value="${e.birth}"><br>
					出身大学<input type="text" name="SCHOOL" value="${e.school}"><br>
					趣味<input type="text" name="HOBBY" value="${e.hobby}"><br>
					自己紹介文<input type="text" name="INTRO" value="${e.intro}"><br>
				<a href= >フォロワーに追加</a>
				<input type="submit" name="submit" value="フォロワーに追加">
				</form>
		<hr>
			</c:forEach>
	</body>
</html>