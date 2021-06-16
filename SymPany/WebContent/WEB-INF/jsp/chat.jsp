<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | チャット</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Third.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<iframe src="LeftmenuServlet" name="sample" width="200" height="500" align="left">
		</iframe>
<div class="bigth">
<!-- ここにRoomのr_nameを入れる -->
	<h2 class="r_name">${room[0].r_name}</h2>
	<div class="shdiv"> <a href="/SymPany/RoomEditServlet"><img src="/SymPany/images/supana.png" class="supana"></a>
	<img src="/SymPany/images/ham.png" class="ham"></div>
	<!-- 設定のimg 表示 一番良い方法はsubmitボタンの表示を変更するのが良い-->

	<!-- ドロワーの入力 -->
	<div class="container">
		<div class="hamburger" id="open_nav">
		<!--
		<img src="" alt"">
		 -->
		<section>
			<div class="content">
			参加者一覧
			<!-- 参加者をループで一覧で表示する -->
			<c:forEach var="e" items="${list}">
				${e.nickname}
			</c:forEach>
			</div>
		</section>

		</div>
	</div>
	<div class="mainchat">
	<ul class="talk">
	<!-- 参加者をループで一覧で表示する -->
	<!-- list を for で取得することがよい -->
	<c:forEach var="e" items="${chat}" >
			<form method="POST" action="/SymPany/UpdateDeleteServlet">
				<li>${e.user_id}${e.message}</li>
			</form>
   	 </c:forEach>
	</ul>
	</div>
	<form method="POST" class="chat" action="ChatServlet">
		<input class="ctext" type ="text" name="s_message" placeholder="コメントを入力してください。">
		<input type="submit" name="submit" value="送信">
	</form>
</div>
</body>
</html>