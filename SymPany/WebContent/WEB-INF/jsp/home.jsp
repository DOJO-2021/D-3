<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sympany|ホーム</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">
</head>
<body>
<!-- ヘッダー -->
<jsp:include page="header.jsp"></jsp:include>
<!-- ヘッダー ここまで -->

<!-- 画像を後で付ける -->
<h2>機能紹介</h2>
<div class="menu-block">
	<div class="menu-item">
		<div class="menu-text">
			<h4>マイページ</h4>
			<p>
			マイプロフィールは必須項目は全部埋めてね！<br>
			自己紹介文も長いと自分がどういう性格か分かりやすいからgood!<br>
			趣味や好きなものを書いておくと相手からのマッチング率がUP‼‼<br>
			<br>
			▶<a href="/WEB-INF/mypage.jsp">『マイページ』</a>はこちらから
			</p>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<h4>プロフィール検索</h4>
			<p>
			キーワードで検索すると、同じ趣味の人や好きなものが同じ人が表示されるよ！<br>
			気になる人をフォローしてみよう‼<br>
			個人的にチャットをしてみたり、ルームに招待してみよう！<br>
			<br>
			▶<a href="/WEB=INF/profilesearch.jsp">『プロフィール検索』</a>はこちらから
			</p>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<h4>チャット</h4>
			<p>
			グループを作成して、趣味や好きな物同士で集まろう！<br>
			<br>
			またルーム作成者はいつでもルーム名やルームの一言紹介文、<br>
			ルームの公開非公開設定、削除が編集可能！<br>
			<br>
			既存のルームを検索して参加するともできるぞ！<br>
			<br>
			チャット画面の左側に参加しているルームも一覧で出ているから、<br>
			いつものルームに瞬時に移動も可能に‼<br>
			<br>
			▶<a href="/WEB-INF/chat.jsp">『チャット』</a>はこちらから
			</p>
		</div>
	</div>
	<div class="menu-item">
		<div class="menu-text">
			<h4>ログアウト</h4>
			<p>
			このボタンを押すと現実に連れ戻されるよ！<br>
			<br>
			▶<a href="/WEB-INF/login.jsp">『ログアウト』</a>はこちらから
			</p>
		</div>
	</div>
</div>


</body>
</html>