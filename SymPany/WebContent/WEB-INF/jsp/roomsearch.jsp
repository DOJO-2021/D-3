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
	<iframe src="LeftmenuServlet" name="sample" width="200" height="500"
		align="left">  </iframe>
	<!-- ここに検索に使用した文字を入れる -->
	<h2>検索結果 ${search}</h2>
	<c:forEach var="e" items="${list}">
		<ul>
			<c:if test="${e.release==1}">
				<li><form>
						<input type="hidden" name="r_id" value="${e.r_id}">
						${e.r_name} ${e.r_comment}

					</form></li>
			</c:if>
		</ul>
	</c:forEach>
</body>
</html>