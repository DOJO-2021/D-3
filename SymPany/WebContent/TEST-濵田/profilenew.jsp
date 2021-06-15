<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta charset="UTF-8">
  <title>SymPany|プロフィール新規登録</title>
  <link rel="stylesheet" href="/SymPany/CSS/First.css">
 </head>

  <body>
   <div class="logo_bear"><img src="/SymPany/images/logo30.png"></div>
   <div class="first">
   <h1>プロフィール新規登録</h1>
    <div class="pink">
    <p>自分のプロフィールを登録しよう！<br>
        *は必須項目だよ</p>
			<form method="POST" action="">
			<table class="first">
			<tr>
			 <td>
			  <label>名前*<br>
			  <input type="text" name="name" placeholder="（例）白クマ太郎" required autofocus>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>ニックネーム*<br>
				<input type="text" name="nickname" placeholder="（例）白クマ" required>
			  </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label>出身地*<br>
				<input type="text" name="birthplace" placeholder="（例）北極3-21-4" required>
			 </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label>所属企業*<br>
				<input type="text" name="company"  placeholder="（例）株式会社温暖化防止" required>
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>誕生日<br>
				<input type="text" name="birth" placeholder="（例）1998-04-22">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>出身大学<br>
				<input type="text" name="school" placeholder="（例）北極北大学">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>趣味<br>
				<input type="text" name="hobby" placeholder="（例）魚のつかみ取り">
			   </label>
			 </td>
			</tr>

			<tr>
			 <td>
			  <label>自己紹介文<br>
			<input type="text" name="intro" placeholder="（例）一緒に北極に行きましょう">
			  </label>
			 </td>
			</tr>
			</table>
			<table id="login2">
			<tr>
			 <td>
			<input type="submit" value="登　　録"><br>
			 </td>
			</tr>
			</table>
			</form>
		  </div>
		</div>
	</body>
</html>