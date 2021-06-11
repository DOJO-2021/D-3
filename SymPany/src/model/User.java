package model;
import java.io.Serializable;

public class User  implements Serializable{
	 private String user_id;
	 private String	 name;
	 private String nickname;
	 private String birthplace;
	 private String company;
	 private String	 birth;
	 private String school;
	 private String hobby;
	 private String	 intro;

	 //引数があるコンストラクタ（自動生成）
	 public User(String user_id, String name, String nickname, String birthplace, String company, String birth,
				String school, String hobby, String intro) {
			super();
			this.user_id = user_id;
			this.name = name;
			this.nickname = nickname;
			this.birthplace = birthplace;
			this.company = company;
			this.birth = birth;
			this.school = school;
			this.hobby = hobby;
			this.intro = intro;
		}

	//引数がないコンストラクタ（コピペ＋書き換え）
	 public User() {
			super();
			this.user_id = "";
			this.name = "";
			this.nickname = "";
			this.birthplace = "";
			this.company = "";
			this.birth = "";
			this.school = "";
			this.hobby = "";
			this.intro = "";
	 }

	//getter,setterの自動生成
	 public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
}
