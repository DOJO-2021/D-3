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
		<!-- ヘッダー -->
			<jsp:include page="header.jsp"></jsp:include>
		<!-- ヘッダー ここまで -->
	<iframe  src="/SymPany/FollowServlet" name="follow" width="200" height="500" align="left" >
	</iframe>
	<h2>プロフィールの編集</h2>
	<c:forEach var="e" items="${profile}" >
		<form method="POST" action="/SymPany/MypageServlet">
			<table>
				<tr>
					<td>
						<label>
							<input type ="hidden" name="user_id" value="${e.user_id}">
								名前<input type="text" name="name" value="${e.name}" required><br>
						</label>
					</td>
					<td>
						<label>
							ニックネーム<input type="text" name="nickname" value="${e.nickname}" required><br>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							出身地<input type="text" name="birthplace" value="${e.birthplace}" ><br>
						</label>
					</td>
					<td>
						<label>
							所属企業<input type="text" name="company" value="${e.company}" ><br>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							誕生日<input type="text" name="birth" value="${e.birth}" ><br>
						</label>
					</td>
					<td>
						<label>
							出身大学<input type="text" name="school" value="${e.school}" ><br>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							趣味
							<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby" >
								${e.hobby}
							</textarea><br>
						</label>
					</td>
					<td>
						<label>
							自己紹介文
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
	</body>
</html>