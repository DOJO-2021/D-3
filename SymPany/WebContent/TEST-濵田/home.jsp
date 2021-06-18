<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sympany | ホーム</title>
<link rel="stylesheet" href="/SymPany/CSS/common.css">

</head>
<body class="homebody">
<!-- ヘッダー -->
<jsp:include page="header.jsp"></jsp:include>
<!-- ヘッダー ここまで -->

<!-- 画像を後で付ける -->
<div class="HOME">
<div class="setumei">
<h2 class="ugokuh2">
	<span>S</span>
	<span>y</span>
	<span>m</span>
	<span>P</span>
	<span>a</span>
	<span>n</span>
	<span>y</span>
	<span>っ</span>
	<span>て</span>
	<span>な</span>
	<span>～</span>
	<span>に</span>
	<span>？</span>
	</h2>
<p>
<span class="s">研修生用コミュニケーションツールSymPany</span>へようこそ！<br>
「Sympany」は２つのことばを合わせて作り出した造語です。<br>
<span class="s">思いやり</span>、<span class="s">共感</span>という意味を持つ<span class="s">「Sympacy」</span>と、<br>
いろいろな<span class="s">異なった要素</span>がまじり合って、ある効果を生み出しているという意味をもつ<span class="s">「Sympyony」</span><br>
<br>
会社もバックグラウンドも違うひととも<span class="s">交流</span>ができる。<br>
仕事のことだけでなく、<span class="s">趣味や好きなもの</span>、お互いが共感できるプライベートな話ができる。<br>
<br>
SymPanyはそんな<span class="s">コミュにケーションのきっかけ</span>になることを願って生まれました。<br>
<br>
</p>
</div>
<div class="man">
<img src="/SymPany/images/man.png" class="man">
</div>
<div class="link">
<h3>下のリンクから各機能の説明に飛べるよ</h3>
<a href="#mypage">マイページ</a><br>
<a href="#profile">プロフィール検索</a><br>
<a  href="#chat">チャット</a><br>
<a href="#logout">ログアウト</a><br>
</div>
</div>

<div class="menu-block">
<h2>機能説明</h2>
	<div class="menu-item">
		<div class="menu-photo1">
			<img src="/SymPany/images/friends.png" class="home">
		</div>
		<div class="menu-text">

		<a id="mypage"><h4>マイページ</h4></a>
			<p>
			マイプロフィールは必須項目は全部埋めてね！<br>
			自己紹介文も長いと自分がどういう性格か分かりやすいからgood!<br>
			趣味や好きなものを書いておくと相手からのマッチング率がUP‼‼<br>
			<br>
			▶<a href="/SymPany/mypage.jsp">『マイページ』</a>はこちらから
			</p>
		</div>
	</div>

	<div class="menu-item">
		<div class="menu-text">
			<a id="profile"><h4>プロフィール検索</h4></a>
			<p>
			キーワードで検索すると、同じ趣味の人や好きなものが同じ人が<br>表示されるよ！<br>
			気になる人をフォローしてみよう‼<br>
			個人的にチャットをしてみたり、ルームに招待してみよう！<br>
			<br>
			▶<a href="/SymPany/profilesearch.jsp">『プロフィール検索』</a>はこちらから
			</p>
		</div>
		<div class="menu-photo2">
			<img src="/SymPany/images/hatena.png" class="home">
		</div>
	</div>

	<div class="menu-item">
	  	<div class="menu-photo1">
			<img src="/SymPany/images/sns.png" class="home">
		</div>
		<div class="menu-text">
			<a id="chat"><h4>チャット</h4></a>
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
			▶<a href="/SymPany/chat.jsp">『チャット』</a>はこちらから
			</p>
		</div>
	</div>
	<div class="menu-item">
		<div class="menu-text">
			<a id="logout"><h4>ログアウト</h4></a>
			<p>
			このボタンを押すと現実に連れ戻されるよ！<br>
			<br>
			▶<a href="/SymPany/login.jsp">『ログアウト』</a>はこちらから
			</p>
		</div>
		<div class="menu-photo2">
			<img src="/SymPany/images/bed.png" class="home">
		</div>
	</div>
</div>
<a href="#" id="page-top">TOP</a>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<script type="text/javascript">
const CLASSNAME = "-visible";
const TIMEOUT = 1500;
const TIME=1500000;
const $target = $(".ugokuh2");

setInterval(() => {
  $target.addClass(CLASSNAME);
  setTimeout(() => {
    $target.removeClass(CLASSNAME);
  }, TIME);
}, TIMEOUT );
</script>
</body>
</html>