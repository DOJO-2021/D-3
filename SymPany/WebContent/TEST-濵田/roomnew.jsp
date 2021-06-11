<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sympany | ルームの新規作成</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Second.css">
</head>

<body class="second">
<jsp:include page="header.jsp"></jsp:include>
<h2>ルームの新規作成</h2>
<!-- ルーム情報を送る -->
<form method="" action="">
ルーム名<input type="text" name="room_name" placeholder="(例)猫好きの会"><br>
一言で説明<input type="text" name="room_comment" placeholder="(例)猫好きなら誰でもOK"><br>
ルームの公開・非公開設定：
<input type="radio" name="open" value="public">公開
<input type="radio" name="open" value="private">非公開<br>
<input type="submit" name="make" value="ルームを作成する">
</form>
</body>
</html>