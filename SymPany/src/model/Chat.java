package model;
import java.io.Serializable;

public class Chat implements Serializable{
	private  int message_id;
	private String user_id;
	private int r_id;
	private String message;

	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

//引数のないコンストラクタ(形として作らなくちゃいけないルール)
public Chat() {
message_id=0;
 user_id="";
r_id=0;
message="";
}
//引数のあるコンストラクタ(フォームに入力されたものを箱詰め)
public Chat(int message_id, String user_id, int r_id, String message) {
	super();
	this.message_id = message_id;
	this.user_id = user_id;
	this.r_id = r_id;
	this.message = message;
}
//Insertの時使う
public Chat(String user_id, int r_id, String message) {
	super();
	this.user_id = user_id;
	this.r_id = r_id;
	this.message = message;
}
}
