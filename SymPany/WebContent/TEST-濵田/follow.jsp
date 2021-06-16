<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="follow_list">
	<h2>フォローリスト</h2>
	<!-- ドロワーの入力、名前で展開 -->

		<table class="f_list">
			<tr>
			 <td>
			  <label>名前　　　　:
			  <input type="text" name="name">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>ニックネーム:
				<input type="text" name="nickname">
			  </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label>出身地　　　:
				<input type="text" name="birthplace" >
			 </label>
			 </td>
			</tr>
		   <tr>
			 <td>
			  <label>所属企業　　:
				<input type="text" name="company">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>誕生日　　　:
				<input type="text" name="birth" >
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>出身大学　　:
				<input type="text" name="school">
			  </label>
			 </td>
			</tr>
			<tr>
			 <td>
			  <label>趣味　　　　:
				<textarea rows="3″cols=”50″wrap="soft" type="text" name="hobby"></textarea>
			   </label>
			 </td>
			</tr>

			<tr>
			 <td>
			  <label>自己紹介文　:
			<textarea rows="3″cols=”50″wrap="soft" type="text" name="intro"></textarea>
			  </label>
			 </td>
			</tr>
			</table>
</div>