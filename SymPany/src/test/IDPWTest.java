package test;
import java.util.List;

import DAO.IDPWDAO;
import model.IDPW;

public class IDPWTest {
	public static void main(String[] args) {
		IDPWDAO dao = new IDPWDAO();
		//message_id,user_id,r_name,message
		// select()のテスト

		System.out.println("---------- select()のテスト ----------");
		List<IDPW> IDPW = dao.insert(new IDPW(null,null));
		for (IDPW c:IDPW ) {
			System.out.println("user_id" + c.getUser_id());
			System.out.println("Message_id：" + c.getPassword());
		}


	}
}

