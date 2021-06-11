package model;
import java.io.Serializable;

public class Member implements Serializable{
	private String user_id;
	private String r_name;

	//引数があるコンストラクタ（自動生成）
	public Member(String user_id, String r_name) {
		super();
		this.user_id = user_id;
		this.r_name = r_name;
	}

	//引数がないコンストラクタ（コピペ＋書き換え）
	public Member() {
		super();
		this.user_id = "";
		this.r_name = "";
	}

	//getter,setterの自動生成
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

}
