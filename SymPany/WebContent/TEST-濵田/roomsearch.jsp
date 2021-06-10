<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SymPany</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<iframe src="leftmenu.jsp" name="sample" width="200" height="500" align="left">
この部分はインラインフレームを使用しています。
</iframe>
<!-- ここに検索に使用した文字を入れる -->
	<h2>検索結果　猫</h2>

	<ul>
	<!-- 検索結果をループで一覧で表示する
		それと同時にsubmitボタンを参加としてループに加える-->
	<!-- list を for で取得することがよい -->
	<li><form>
	<!-- ここにinput type hiddenの r_nameを追加する-->
	猫好きの会 猫好きな人だれでもどうぞ
	<input type="submit" value="参加">
	</form></li>

	<li><form>
	猫好きの会 EX仲良しの猫好きだけ
	<input type="submit" value="参加">
	</form><li>

	<li><form>
	猫になりたい 生まれ変わったら猫がいいよね
	<input type="submit" value="参加">
	</form><li>

	</ul>

</body>
</html>