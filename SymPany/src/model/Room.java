package model;

public class Room {
	private String r_name;
	private String r_comment;
	private int release;
	private String user_id;

	//引数があるコンストラクタ（自動生成）
	public Room(String r_name, String r_comment, int release, String user_id) {
		super();
		this.r_name = r_name;
		this.r_comment = r_comment;
		this.release = release;
		this.user_id = user_id;
	}

	//引数がないコンストラクタ（コピペ＋書き換え）
	public Room() {
		super();
		this.r_name = "";
		this.r_comment = "";
		this.release = 1;
		this.user_id = "";
	}

	//getter,setterの自動生成
	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_comment() {
		return r_comment;
	}

	public void setR_comment(String r_comment) {
		this.r_comment = r_comment;
	}

	public int getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = Integer.parseInt(release);
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


}

