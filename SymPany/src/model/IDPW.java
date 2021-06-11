package model;
import java.io.Serializable;

public class IDPW implements Serializable{
 private String user_id;
 private String password;

 public IDPW(String user_id,String password) {
	 this.user_id = user_id;
	 this.password = password;
 }

 public IDPW(){
	 this.user_id="";
	 this.password="";
 }

public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
