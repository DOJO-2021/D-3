package model;
import java.io.Serializable;

public class Member implements Serializable{
	private String user_id;
	private int r_id;

	//引数があるコンストラクタ（自動生成）
	public Member(String user_id, int r_id) {
		super();
		this.user_id = user_id;
		this.r_id = r_id;
	}

	//引数がないコンストラクタ（コピペ＋書き換え）
	public Member() {
		super();
		this.user_id = "";
		this.r_id = 0;
	}

	//getter,setterの自動生成
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

}
