<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<link rel="stylesheet" href="/SymPany/CSS/follow.css">
<div class="follow_list">
	<h2 class="f_list">フォローリスト</h2>
		<div class="f_list">
​<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
​<%int menu=1; %>
				<c:forEach var="e" items="${list}" >
					<c:forEach var = "f" items="${e}">

					<script>

					$('label.cp_menu_bar<%=menu%>').css({
									'display':'block',
									'margin':'0 0 2px 0',
									'line-height':'1',
									'coursor':'pointer'});

					$('label.menu_bar<%=menu%>:after').css({
									'content':'▼',
									'font-size':'20px',
									'margin':'0'});

					$('#menu_bar<%=menu%>:checked ~ #link1 li').css({
									'height':'50px',
									'opacity':'1';})

					</script>
​					<div class="cp_menu">
							<input type ="hidden" name="user_id" value="${f.user_id}">
​
						<label class="cp_menu_bar<%=menu%>" for="menu_bar<%=menu%>" >
							<input type="text" name="name" class="f_listname" value="${f.name}" disabled>
							</label>
							<input type="checkbox" id="menu_bar<%=menu%>"><%menu++;%>
								<ul id="link1">
						<li>
							<label class="f_list">ニックネーム :
								<input type="text" name="nickname" class="f_list" value="${f.nickname}" disabled>
							</label>
						</li>
						<li>
							<label class="f_list">出身地　　　 :
								<input type="text" name="birthplace" class="f_list" value="${f.birthplace}" disabled>
							</label>
						</li>
						<li>
							<label class="f_list">所属企業　　 :
								<input type="text" name="company" class="f_list" value="${f.company}" disabled>
							</label>
						</li>
						<li>
							<label class="f_list">誕生日　　　 :
								<input type="text" name="birth" class="f_list" value="${f.birth}" disabled>
							</label>
						</li>
						<li>
							<label class="f_list">出身大学　　 :
								<input type="text" name="school" class="f_list" value="${f.school}" disabled>
							</label>
						</li>
						<li>
							<label class="f_list">趣味　　　　 :
								<textarea rows="3"cols="28"wrap="soft"
								name="hobby" class="f_list,textarea" disabled>${f.hobby}</textarea>
							</label>
						</li>
						<li>
							<label class="f_list">自己紹介文　 :
								<textarea rows="3"cols="28" wrap="soft"
								name="intro" class="f_list,textarea" disabled>${f.intro}</textarea>
							</label>
						</li>
						</ul>
​				</div>

					</c:forEach>
				</c:forEach>
​
	</div>
</div>
