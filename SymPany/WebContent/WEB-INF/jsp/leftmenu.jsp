<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="leftmenu-block">
	<div class="leftmenu-item">
		<div class="leftmenu-text">
			<h4>既存ルーム検索</h4>
			<form class="search" method="POST" action="/Sympany/roomedit.jsp">
			<input type="text" name="RoomEdit" class="value"  placeholder="（例）猫"  >
			<input type="submit" name="submit" value="検索" >
			</form>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<h4><a href="/Sympany/roomnew.jsp">新規作成</a></h4>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<h4>参加中のルーム（sevletできないと分からん）</h4>
		</div>
	</div>
</div>