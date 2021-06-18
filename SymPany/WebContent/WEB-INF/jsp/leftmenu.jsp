<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>

<link rel="stylesheet" href="/SymPany/CSS/common.css">

<div class="left">

			<h4>■既存ルーム検索</h4>
			<form class="search" method="POST" action="/SymPany/RoomSearchServlet">
			<input class="leftmenu" type="text" name="RoomEdit"  class="value" placeholder="（例）猫"  >
			<input class="minsubmit" type="submit" name="submit" value="検索" >
			</form>

			<h4>■<a href="/SymPany/RoomNewServlet" target="_parent" class ="new">新規作成</a></h4>

			<h4>■参加中のルーム</h4>
			<c:forEach var="e" items="${roomList}">
				<c:forEach var ="f" items="${e}">
				<form method="POST" action="/SymPany/ChatServlet" >
					<input type ="hidden" name ="r_id" value="${f.r_id}">
 					${f.r_name}
 					<input type="submit" name="submit" value="参加する">
				</form>
				<hr>
				</c:forEach>
			</c:forEach>
</div>