package test;
import java.util.List;

import DAO.ReactionDAO;
import model.Reaction;

public class ReactionTest {
	public static void main(String[] args) {
		ReactionDAO dao = new ReactionDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Reaction> Reaction = dao.select(new Reaction(null,0));
		for (Reaction c:Reaction ) {
			System.out.println("user_id:" + c.getUser_id());
			System.out.println("Message_id：" + c.getMessage_id());
		}



		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Reaction insRec = new Reaction("D3-21");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Reaction> Reaction2 = dao.select(insRec);
			for (Reaction c : Reaction2) {
				System.out.println("user_id：" + c.getUser_id());
			}
		}
		else {
			System.out.println("登録失敗！");
		}


		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Reaction upRec = new Reaction("D3-2",2);
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Reaction> Reaction3 = dao.select(upRec);
			for (Reaction c : Reaction3) {
				System.out.println("user_id：" + c.getUser_id());
				System.out.println("message_id：" + c.getMessage_id());
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

