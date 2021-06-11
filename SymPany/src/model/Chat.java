package model;
import java.io.Serializable;

public class Chat implements Serializable{
	private  String message_id;
	private String user_id;
	private String r_name;
	private String message;

	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

//引数のないコンストラクタ(形として作らなくちゃいけないルール)
public Chat() {
message_id="";
 user_id="";
r_name="";
message="";
}
//引数のあるコンストラクタ(フォームに入力されたものを箱詰め)
public Chat(String message_id, String user_id, String r_name, String message) {
	super();
	this.message_id = message_id;
	this.user_id = user_id;
	this.r_name = r_name;
	this.message = message;
}
}
