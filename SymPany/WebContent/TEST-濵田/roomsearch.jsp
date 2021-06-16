<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany | ルーム検索</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
<link rel="stylesheet" href="/SymPany/CSS/Second.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<iframe class="iframe" src="leftmenu.jsp" name="sample"  frameborder="0">
この部分はインラインフレームを使用しています。
</iframe>
<div class="bigrm">
<!-- ここに検索に使用した文字を入れる -->
	<h2>検索結果　猫</h2>

	<ul class="rmul">
	<!-- 検索結果をループで一覧で表示する
		それと同時にsubmitボタンを参加としてループに加える-->
	<!-- list を for で取得することがよい -->
	<li class="rmli"><form class="rm2">
	<!-- ここにinput type hiddenの r_nameを追加する-->
		<label class="label1"><strong>猫好きの会</strong></label><br>
		<label class="label2">猫好きな人だれでもどうぞ</label>
		<div class="submit2"><input type="submit" value="参加"></div>
	</form></li>

	<li class="rmli"><form class="rm2">
		<label class="label1"><strong>猫好きの会2</strong></label><br>
		<label class="label2">EX仲良しの猫好きだけ</label>
		<div class="submit2"><input type="submit" value="参加"></div>

	</form></li>

	<li class="rmli"><form class="rm2">
		<label class="label1"><strong>猫になりたい</strong></label><br>
		<label class="label2">生まれ変わったら猫がいいよね</label>
		<div class="submit2"><input type="submit" value="参加"></div>
	</form></li>
	</ul>
</div>
</body>
</html>