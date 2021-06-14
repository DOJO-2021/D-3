package test;
import java.util.List;

import DAO.FollowDAO;
import model.Follow;

public class FollowTest {
	public static void main(String[] args) {
		FollowDAO dao = new FollowDAO();
		//message_id,user_id,r_name,message
		// select()のテスト

		System.out.println("---------- select()のテスト ----------");
		List<Follow> Follow = dao.select(new Follow(null,null));
		for (Follow c:Follow ) {
			System.out.println("User_id：" + c.getUser_id());
			System.out.println("F_user_id" + c.getF_user_id());
		}

/*
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Follow insRec = new Follow("D4","D3-22");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Follow> Follow2 = dao.select(insRec);
			for (Follow c : Follow2) {

				System.out.println("user_id：" + c.getUser_id());
				System.out.println("F_user_id：" + c.getF_user_id());

			}
		}
		else {
			System.out.println("登録失敗！");
		}
*/
/*
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Follow upRec = new Follow("D5","D3-21");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Follow> Follow3 = dao.select(upRec);
			for (Follow c : Follow3) {
				System.out.println("user_id：" + c.getUser_id());
				System.out.println("F_user_id：" + c.getF_user_id());
			}
		}
		else {
			System.out.println("更新失敗！");
		}
*/

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("D4","D3-22")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}

