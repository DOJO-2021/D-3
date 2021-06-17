<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="cgi-bin/example.cgi" method="post">
  <table class="Third">
  <tr>
   <td>
  <input class="kensaku" type="search" name="seach" placeholder="出身地や趣味などを入力してみよう">
   </td>
   <td>
  <input class="kensaku" type="submit" name="submit" value="検索">
   </td>
  </tr>
  </table>
</form>
<div class="kingpink">
<div class="icon2"><img src="/SymPany/images/kensaku.png" class="icon"></div>
</div>
 </div>
</body>
</html>