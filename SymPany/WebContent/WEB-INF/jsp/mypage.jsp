<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SymPany | マイページ</title>
		<link rel="stylesheet" href="/SymPany/CSS/common.css">
		<link rel="stylesheet" href="/SymPany/CSS/Second.css">
	</head>
	<body>

	<c:if test="${update}">
	<script type="text/javascript">
		alert("プロフィールを更新しました。");
	</script>
</c:if>
		<!-- ヘッダー -->
			<jsp:include page="header.jsp"></jsp:include>
			<jsp:include page ="follow.jsp"></jsp:include>
		<!-- ヘッダー ここまで -->
	<div class="bigrm">
	<h2>プロフィールの編集</h2>
	<c:forEach var="e" items="${profile}" >
		<form method="POST" action="/SymPany/MypageServlet">
			<table>
				<tr>
					<td>
						<label class="mypage1">
							<input type ="hidden" name="user_id" value="${e.user_id}">
								名前<br>
								<input type="text" name="name" value="${e.name}" required><br>
						</label>
					</td>
					<td>
						<label class="mypage1">
							ニックネーム<br>
							<input type="text" name="nickname" value="${e.nickname}" required><br>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label class="mypage1">
							出身地<br>
							<input type="text" name="birthplace" value="${e.birthplace}" ><br>
						</label>
					</td>
					<td>
						<label class="mypage1">
							所属企業<br>
							<input type="text" name="company" value="${e.company}" ><br>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label class="mypage1">
							誕生日<br>
							<input type="text" name="birth" value="${e.birth}" ><br>
						</label>
					</td>
					<td>
						<label class="mypage1">
							出身大学<br>
							<input type="text" name="school" value="${e.school}" ><br>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label class="mypage1">
							趣味<br>
							<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" >
								${e.hobby}
							</textarea><br>
						</label>
					</td>
					<td>
						<label class="mypage1">
							自己紹介文<br>
								<textarea rows="3″cols=”50″wrap="soft" type="text" name="intro">
									${e.intro}
								</textarea><br>
						</label>
					</td>
				</table>
				<table>
					<tr>
						<td>
							<input type="submit" value="更新"><br>
						</td>
					</tr>
				</table>
			</form>
		</c:forEach>
		 </div>
	</body>
</html>