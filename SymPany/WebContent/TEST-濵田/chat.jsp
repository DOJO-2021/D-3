<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany</title>
</head>

<body>
<jsp:include page="Header.jsp"></jsp:include>
<iframe src="Leftmenu.jsp" name="sample" width="200" height="500" align="left">
この部分はインラインフレームを使用しています。
</iframe>
<!-- ここにRoomのr_nameを入れる -->
	<h2>#猫好きの会　*</h2>
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
	<ul>
	<!-- 参加者をループで一覧で表示する -->
	<!-- list を for で取得することがよい -->
		<li>川島：インスタのアカウント作成うまくいくといいね</li>
		<li>西郷：私自撮りしないんですよ</li>
		<li>川島：データベースに入れたいですね</li>
	</ul>
	<form>
	<input type ="text" name="s_message" placeholder="コメントを入力してください。">
	<input type ="submit" name="submit" value="送信">
	</form>

</body>
</html>