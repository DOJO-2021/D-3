package model;

public class Reaction {
	private String user_id;
	private String message_id;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	//引数のないコンストラクタ(形として作らなくちゃいけないルール)
	public Reaction() {
		user_id="";
		message_id="";
	}
	//引数のあるコンストラクタ(フォームに入力されたものを箱詰め)
	public Reaction(String user_id, String message_id) {
		super();
		this.user_id = user_id;
		this.message_id = message_id;
	}

}
