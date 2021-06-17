/**
 **/

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
'use strict';

window.alert('アカウントを作成しました。');
window.alert('プロフィールを作成しました。');

//フォローリストの表示を隠すJavaScript
$(document).ready(function(){
	$('div.f_list input.f_listname').on('click' , function(){
		$(this).next().toggleClass('hidden');
	});
});

$(".burger-btn").on("click", function () { //「burger-btn」をクリックすると
    $("img.ham").toggleClass("close");  //closeというclassを追加/削除。
    $(".nav-header-menu").fadeToggle(500); //0.5秒かけてフェードイン/フェードアウト。
  });

</script>

