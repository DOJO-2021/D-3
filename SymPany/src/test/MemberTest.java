package test;
import java.util.List;

import DAO.MemberDAO;
import model.Member;

public class MemberTest {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		//message_id,user_id,r_name,message
		// select()のテスト

		System.out.println("---------- select()のテスト ----------");
		List<Member> Member = dao.select(new Member(null,0));
		for (Member c:Member ) {
			System.out.println("user_id" + c.getUser_id());
			System.out.println("r_name：" + c.getR_id());
		}


		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Member insRec = new Member("D3",2);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Member> Member2 = dao.select(insRec);
			for (Member c : Member2) {
				System.out.println("user_id：" + c.getUser_id());
				System.out.println("r_name：" + c.getR_id());
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Member upRec = new Member("D3-2",1);
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Member> Member3 = dao.select(upRec);
			for (Member c : Member3) {
				System.out.println("user_id：" + c.getUser_id());
				System.out.println("r_name：" + c.getR_id());
			}
		}
		else {
			System.out.println("更新失敗！");
		}


		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(2)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}

