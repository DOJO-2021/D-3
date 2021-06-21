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
<link rel="stylesheet" href = "/SymPany/css/Hamburger.css">

</head>

<body>

<c:if test="${message}">
	<script type="text/javascript">
		alert("メッセージを送信しました。");
	</script>
</c:if>
<c:if test="${delete}">
	<script type="text/javascript">
		alert("リアクションを取り消しました。");
	</script>
</c:if>
<c:if test="${reins}">
	<script type="text/javascript">
		alert("リアクションしました。");
	</script>
</c:if>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="leftmenu.jsp"></jsp:include>
<!-- <iframe src="LeftmenuServlet" name="sample" width="200" height="500" align="left">
		</iframe> -->
<div class="bigth">
<c:if test="${room[0]==null}">
<div class="icon1"><img src="/SymPany/images/talk.png" class="icon"></div>
</c:if>
<c:if test="${room[0] != null}">

<!-- ここにRoomのr_nameを入れる -->
	<h2 class="r_name">${room[0].r_name}</h2>
	<div class="shdiv">
	<c:if test="${room[0].user_id==user_id}">
	 <a href="/SymPany/RoomEditServlet"><img src="/SymPany/images/supana.png" class="supana"></a>
	</c:if>


	<img src="/SymPany/images/ham.png" class="ham"></div>
	<!-- 設定のimg 表示 一番良い方法はsubmitボタンの表示を変更するのが良い-->

	<!-- ドロワーの入力 -->
	<div class="container">

		<div class="hamburger" id="open_nav">
		<img src="ham.png" alt="">
		<script src="../../_common/scripts/jquery-3.4.1.min.js"></script>
		<script>
		'use strict';
		$(document).ready(function(){
		  $('#open_nav').on('click', function(){
		    $('#wrapper, #nav').toggleClass('show');
		  });
		});
		</script>
		<section>
			<div class="content">
			<p>参加者一覧<br></p>
			<!-- 参加者をループで一覧で表示する -->
			<c:forEach var="e" items="${list}">
				・${e.nickname}<br>
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
	 <c:forEach var="f" items="${list}">
	 		<c:if test="${e.user_id ==f.user_id}">
			<form method="POST" action="/SymPany/ChatServlet">
			<input type="hidden" name="message_id" value="${e.message_id }">
							<li class = "mintalk">${f.nickname} :${e.message}
				<%int counter = 0; %>
					<c:forEach var="g" items="${reaction}">
					<c:if test="${g.message_id == e.message_id}">
						<c:if test="${g.user_id == user_id}">
						<% counter ++;%>
						</c:if>
						</c:if>
					</c:forEach>
					<%if(counter==0){ %>
						<input type ="submit" name ="submit" value="リアクション">
					<%}
					else{
					%>
						<input type ="submit" name ="submit" value="解除">
					<%} %>
				</li>
			</form>
			</c:if>
			</c:forEach>
   	 </c:forEach>
	</ul>
	</div>
	<form method="POST" class="chat" action="ChatServlet">
		<input class="ctext" type ="text" name="s_message" placeholder="コメントを入力してください。">
		<input type="submit" name="submit" value="送信">
	</form>
	</c:if>
</div>
</body>
</html>