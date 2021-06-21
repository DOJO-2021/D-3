<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany|プロフィール検索</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Third.css">
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- ヘッダー ここまで -->
	<div class="bigps">
		<h2 class="ps">プロフィール検索</h2>
		<form action="ProfileSearchServlet" method="post">
			<table class="Third">
				<tr>
					<td><input class="kensaku" type="search" name="search"
						placeholder="出身地や趣味などを入力してみよう" value="${search}" autofocus></td>
					<td><input class="kensaku" type="submit" name="submit"
						value="検索"></td>
				</tr>
			</table>
		</form>

		<div class="kingpink">
		<%int sum = 0; %>
		<%String user =(String)session.getAttribute("user_id"); %>
			<c:forEach var="e" items="${list}">
			<c:if test="${e.user_id != user_id}">
			<%sum++ ;%>
				<div class="pink">
					<form method="POST" action="/SymPany/FollowerServlet">
					<input type="hidden" name="user_id" value="${e.user_id}" >
							<table class="formtable">
								<tr>
									<td>
										<label>名前<br>
											<input type="text" name="name" value="${e.name}" disabled>
										</label>
									</td>
									<td>
										<label>ニックネーム<br>
											<input type="text" name="nickname" value="${e.nickname}" disabled>
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>出身地<br>
											<input type="text" name="birthplace" value="${e.birthplace}" disabled>
										</label>
									</td>
									<td>
										<label>所属企業<br>
											<input type="text" name="company" value="${e.company}"disabled>
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>誕生日<br>
											<input type="text" name="birth" value="${e.birth}"disabled>
										</label>
									</td>
									<td>
										<label>出身大学<br>
											<input type="text" name="school" value="${e.school}"disabled>
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>趣味<br>
											<textarea rows="3"cols="50"wrap="soft" name="hobby" disabled>${e.hobby}</textarea>
										</label>
									</td>
									<td>
										<label>自己紹介文<br>
											<textarea rows="3" cols="50" wrap="soft" name="intro" disabled>${e.intro}</textarea>
										</label>
									</td>
								</tr>
							</table>
							<table id="submit">
								<tr>
									<td>
						<!-- ここではフォローDBに現在表示しているuser_idをフォローしているかの確認
											 フォローしている場合はカウンターが増える -->
										<%int counter = 0; %>
										<c:forEach var="f" items="${follow}">
											<c:if test="${e.user_id == f.f_user_id}">
												<% counter ++;%>
											</c:if>
										</c:forEach>
										<div class="submit2">
										<!-- カウンターが0の場合、フォローしていないとみなす
											 カウンターが0以外の場合、フォローしているとみなす -->
											<%if(counter==0){ %>
												<input type ="submit" name ="submit" value="フォローする">
											<%}
											else{
											%>
												<input type ="submit" name ="submit" value="フォロー解除">
											<%} %>
										</div>
									</td>
								</tr>
							</table>
						</form>
					</div>
					</c:if>
				</c:forEach>
				<%if (sum ==0){ %>
			<div class="icon2"><img src="/SymPany/images/kensaku.png" class="icon"></div>
			<% }%>
			</div>
		</div>
	</body>
</html>