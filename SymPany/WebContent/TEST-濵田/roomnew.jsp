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
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="leftmenu.jsp"></jsp:include>
<div class="bigrm">

<h2>ルームの新規作成</h2>
<!-- ルーム情報を送る -->
<form class="rm" method="" action="">
	<table class="room_ps">
		<tr>
		<td>
			<label class="label0">ルーム名</label><br>
			<input type="text" name="room_name" placeholder="(例)猫好きの会"><br>
		</td>
		</tr>
		<tr>
		<td>
			<label class="label0">一言で説明</label><br>
			<input class="ex" type="text" name="room_comment" placeholder="(例)猫好きなら誰でもOK"><br><br>
		</td>
		</tr>
		<tr>
		<td>
			<label class="label0">ルームの公開・非公開設定：</label>
			<input type="radio" name="open" value="public">公開
			<input type="radio" name="open" value="private">非公開<br>
		</td>
		</tr>
		<tr>
		<td>
		<div class="submit">
		<input type="submit" name="make" value="ルームを作成する">
		</div>
		</td>
		</tr>
</table>
</form>

</div>
</body>
</html>