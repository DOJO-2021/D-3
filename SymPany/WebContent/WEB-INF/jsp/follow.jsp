<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here
		</title>
	</head>
	<body>
		<h2>フォローリスト</h2>
			<!-- ドロワーの入力、名前で展開 -->
		<c:forEach var="e" items="${list}">
			<c:forEach var="f" items="${e}">
				<table class="f_list">
					<tr>
						<td>
							<label>名前:
						 		 <input type="text" name="name" value="${f.name}">
						 	 </label>
						</td>
					</tr>
					<tr>
						<td>
							<label>ニックネーム:
								<input type="text" name="nickname" value="${f.nickname}">
							</label>
						</td>
					</tr>
					<tr>
						<td>
					  		<label>出身地:
								<input type="text" name="birthplace" value="${f.birthplace}">
					 		</label>
					 	</td>
					</tr>
					<tr>
						<td>
							<label>所属企業:
								<input type="text" name="company"value="${f.company}">
					  		</label>
					 	</td>
					</tr>
					<tr>
						<td>
					  		<label>誕生日:
								<input type="text" name="birth" value="${f.birth}">
					  		</label>
					 	</td>
					</tr>
					<tr>
						<td>
					  		<label>出身大学:
								<input type="text" name="school"value="${f.school}">
					  		</label>
					 	</td>
					</tr>
					<tr>
						<td>
							<label>趣味:
								<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby">
									${f.hobby}
								</textarea>
					   		</label>
					 	</td>
					</tr>
					<tr>
						<td>
					  		<label>自己紹介文:
								<textarea rows="3″cols=”50″wrap="soft" type="text" name="intro">
									${f.intro}
								</textarea>
					  		</label>
					 	</td>
					</tr>
				</table>
			</c:forEach>
		</c:forEach>
	</body>
</html>