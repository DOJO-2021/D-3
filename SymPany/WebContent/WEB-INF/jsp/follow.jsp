<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="follow_list">
	<h2 class="f_list">フォローリスト</h2>
		<div class="f_list">
		<c:forEach var="e" items="${list}" >
			<c:forEach var = "f" items="${e}">
				<table class="f_list">
				<tr>
				 <td>
				 <input type ="hidden" name="user_id" value="${f.user_id}">
				 <input type="text" name="name" class="f_listname" value="${f.name}" disabled>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label class="f_list">ニックネーム :
				<input type="text" name="nickname" class="f_list" value="${f.nickname}" disabled>
			  </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label class="f_list">出身地　　　 :
				<input type="text" name="birthplace" class="f_list" value="${f.birthplace}" disabled>
			 </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label class="f_list">所属企業　　 :
				<input type="text" name="company" class="f_list" value="${f.company}" disabled>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label class="f_list">誕生日　　　 :
				<input type="text" name="birth" class="f_list" value="${f.birth}" disabled>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label class="f_list">出身大学　　 :
				<input type="text" name="school" class="f_list" value="${f.school}" disabled>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label class="f_list">趣味　　　　 :
				<textarea rows="3"cols="50"wrap="soft"  name="hobby" class="f_list" disabled>${f.hobby}</textarea>
			   </label>
			 </td>
			</tr>

			<tr>
			 <td>
			  <label class="f_list">自己紹介文　 :
			<textarea rows="3"cols="0" wrap="soft" name="intro" class="f_list" disabled>${efintro}</textarea>
			  </label>
			 </td>
			</tr>
			</table>
			</c:forEach>
		</c:forEach>
		</div>
	</div>
