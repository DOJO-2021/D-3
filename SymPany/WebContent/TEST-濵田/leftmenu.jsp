<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | ルーム検索</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Second.css">
</head>
<body>
<div class="left">
			<h4>■既存ルーム検索</h4>
			<form class="search" method="POST" action="/Sympany/roomedit.jsp">
			<input class="leftmenu" type="text" name="RoomEdit" class="value"  placeholder="（例）猫"  >
			<input class="minsubmit" type="submit" name="submit" value="検索" >
			</form>
			<h4>■<a href="/Sympany/roomnew.jsp" class="new">新規作成</a></h4>
			<h4>■参加中のルーム（sevletできないと分からん）</h4>
</div>
</body>