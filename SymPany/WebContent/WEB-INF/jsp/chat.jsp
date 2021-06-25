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
<link rel="stylesheet" href = "/SymPany/CSS/Hamburger.css">
<style>
span.mine{
color:red;
}

</style>

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
<c:if test="${del}">
	<script type="text/javascript">
		alert("ルームから脱退しました。");
	</script>
</c:if>
<c:if test="${reins}">
	<script type="text/javascript">
		alert("リアクションしました。");
	</script>
</c:if>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="leftmenu.jsp"></jsp:include>

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

<input id="drawer-checkbox" type="checkbox">
<label id="drawer-icon" for="drawer-checkbox"><span></span></label>
<label id="drawer-close" for="drawer-checkbox"></label>
<div id="drawer-content"><ul>
	  <c:forEach var="e" items="${list}">
	   <li>${e.nickname}<br>
	  </c:forEach>
	 </ul></div>


	<!--  <img src="/SymPany/images/ham.png" class="ham">--></div>
	<!-- 設定のimg 表示 一番良い方法はsubmitボタンの表示を変更するのが良い-->

	<div class="mainchat">
	<ul class="talk">
	<!-- 参加者をループで一覧で表示する -->
	<!-- list を for で取得することがよい -->
	<c:forEach var="e" items="${chat}" >
	 <c:forEach var="f" items="${list}">
	 		<c:if test="${e.user_id ==f.user_id}">
			<form method="POST" action="/SymPany/ChatServlet">
			<input type="hidden" name="message_id" value="${e.message_id }">
							<li class = "mintalk">

							<c:if test="${f.user_id == user_id}">
							${f.nickname}:<span class ="mine">${e.message}</span>
							</c:if>
							<c:if test="${f.user_id != user_id}">
							${f.nickname}:${e.message}
							</c:if>
				<%int counter = 0; %>
					<c:forEach var="g" items="${reaction}">
					<c:if test="${g.message_id == e.message_id}">
						<c:if test="${g.user_id == user_id}">
						<% counter ++;%>
						</c:if>
						</c:if>
					</c:forEach>
					<%if(counter==0){ %>
						<input class="reaction" type ="submit" name ="submit" value="good&#x1f44d;">
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