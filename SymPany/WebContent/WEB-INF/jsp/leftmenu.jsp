<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="leftmenu-block">
	<div class="leftmenu-item">
		<div class="leftmenu-text">
			<h4>既存ルーム検索</h4>
			<form class="search" method="POST" action="/SymPany/RoomSearchServlet"target="_parent">
			<input type="text" name="search"   placeholder="（例）猫"  >
			<input type="submit" name="submit" value="検索" >
			</form>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<h4><a href="/SymPany/RoomNewServlet"target="_parent">新規作成</a></h4>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<h4>参加中のルーム（sevletできないと分からん）</h4>
			<c:forEach var="e" items="${roomList}">
				<c:forEach var ="f" items="${e}">
				<form method="POST" action="/SymPany/ProfileSearchServlet" target="_parent">
					${f.r_name}<br>
				</form>
				<hr>
				</c:forEach>
			</c:forEach>
		</div>
	</div>
</div>