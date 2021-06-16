<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | チャット</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Third.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="leftmenu.jsp"></jsp:include>
<div class="bigth">
<!-- ここにRoomのr_nameを入れる -->
	<h2 class="r_name">#猫好きの会</h2>
	<div class="shdiv"><img src="/SymPany/images/supana.png" class="supana">
	<img src="/SymPany/images/ham.png" class="ham"></div>
	<!-- 設定のimg 表示 一番良い方法はsubmitボタンの表示を変更するのが良い-->

	<!-- ドロワーの入力 -->
	<div class="container">
		<div class="hamburger" id="open_nav">
		<!--
		<img src="" alt"">
		 -->
		<section>
			<div class="content">
			参加者一覧
			<!-- 参加者をループで一覧で表示する -->
			</div>
		</section>

		</div>
	</div>
	<div class="mainchat">
	<ul class="talk">
	<!-- 参加者をループで一覧で表示する -->
	<!-- list を for で取得することがよい -->
		<li class="mintalk">川島：インスタのアカウント作成うまくいくといいね</li>
		<li class="mintalk">西郷：私自撮りしないんですよ</li>
		<li class="mintalk">川島：データベースに入れたいですね</li>
	</ul>
	</div>
	<form class="chat">
	<input class="ctext" type ="text" name="s_message" placeholder="コメントを入力してください。">
	<input type ="submit" name="submit" value="送信">
	</form>
</div>
</body>
</html>