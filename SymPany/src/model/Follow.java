package model;

public class Follow {
	private String user_id;
	private String f_user_id;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getF_user_id() {
		return f_user_id;
	}
	public void setF_user_id(String f_user_id) {
		this.f_user_id = f_user_id;
	}

	//引数のないコンストラクタ(形として作らなくちゃいけないルール)
	public Follow() {
		user_id="";
		f_user_id="";
	}
	//引数のあるコンストラクタ(フォームに入力されたものを箱詰め)
	public Follow(String user_id, String f_user_id) {
		super();
		this.user_id = user_id;
		this.f_user_id = f_user_id;
	}
}

