<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>SymPany|ルーム検索</title>
	<link rel="stylesheet" href="/SymPany/CSS/common.css">
	<link rel="stylesheet" href="/SymPany/CSS/Second.css">
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="leftmenu.jsp"></jsp:include>
		<div class="bigrm">
		<!-- ここに検索に使用した文字が入ります -->
		<h2>検索結果 ${search}</h2>
			<c:forEach var="e" items="${list}">
				<ul class="rmul">
				<!-- ここでは表示・非表示の比較をしています
					 1（表示）だった場合は表示する
					 それ以外は表示しません-->
					<c:if test="${e.release==1}">
						<li class="rmli">
							<form action="MemberServlet" >
									<input type="hidden" name="r_id" value="${e.r_id}">
									<label class="label1"><strong>${e.r_name}</strong></label><br>
									<label class="label2">${e.r_comment}</label>
									<!-- ここではメンバーDBに現在表示しているルームに参加しているかの確認
										 参加している場合はカウンターが増える -->
									<%int counter = 0; %>
									<c:forEach var="f" items="${member}">
										<c:if test="${e.r_id == f.r_id}">
											<% counter ++;%>
										</c:if>
									</c:forEach>
									<div class="submit2">
									<!-- カウンターが0の場合、参加していないとみなす
										 カウンターが0以外の場合、参加しているとみなす -->
										<%if(counter==0){ %>
											<input type ="submit" name ="submit" value="参加">
										<%}
										else{
										%>
											<input type ="submit" name ="submit" value="脱退">
										<%} %>
									</div>
							</form>
						</li>
					</c:if>
				</ul>
			</c:forEach>
		</div>
	</body>
</html>