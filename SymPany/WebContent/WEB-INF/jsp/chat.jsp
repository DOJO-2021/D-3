<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | チャット</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<iframe src="LeftmenuServlet.jsp" name="sample" width="200" height="500" align="left">
この部分はインラインフレームを使用しています。
</iframe>
<!-- ここにRoomのr_nameを入れる -->
	<h2>#猫好きの会　*</h2>
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
			</div>
		</section>

		</div>
	</div>
	<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/SymPany/UpdateDeleteServlet">
	メッセージID<input type="text" name="MESSAGE_ID" value="${e.Message_id}"><br>
	ユーザーID<input type="text" name="USER_ID" value="${e.user_id}"><br>
	ルームID<input type="text" name="R_ID" value="${e.r_id}"><br>
	メッセージ<input type="text" name="MESSAGE" value="${e.message}"><br>
	<a href= >フォロワーに追加</a>
	<input type ="text" name="s_message" placeholder="コメントを入力してください。">
	<input type ="submit" name="submit"value="送信">
	</form>
    </c:forEach>

</body>
</html>