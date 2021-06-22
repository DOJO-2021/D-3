<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany | ルームの編集</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
		<link rel="stylesheet" href="/SymPany/CSS/Second.css">
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="leftmenu.jsp"></jsp:include>
		<div class="bigrm">

			<h2>ルームの編集</h2>
	<c:forEach var="e" items="${room}">
				<!-- ルーム情報を送る -->
			<form class="rm" method="post" action="/SymPany/RoomEditServlet">
			<input type="hidden" name="r_id" value="${e.r_id}">
				<table class="room_ps">
					<tr>
						<td><label class="label0">ルーム名</label><br>
							<input type="text" name="room_name" value="${e.r_name}"><br>
						</td>
					</tr>
					<tr>
						<td><label class="label0">一言で説明</label><br>
							<input class="ex" type="text" name="room_comment" value="${e.r_comment}"> <br><br>
						</td>
					</tr>
					<tr>
						<td><label class="label0">ルームの公開・非公開設定：</label>
							<input type="radio" name="open" value=1 checked>公開
							<input type="radio" name="open" value=0>非公開<br>
						</td>
					</tr>
					<tr>
						<td>
							<div class="submit">
								<input type="submit" name="submit" value="ルームを更新する" >
								<input type="submit" name="submit" value="ルームを削除する">
							</div>
						</td>
					</tr>
				</table>
			</form>
				</c:forEach>
		</div>
	</body>
</html>