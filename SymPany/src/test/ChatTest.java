package test;
import java.util.List;

import DAO.ChatDAO;
import model.Chat;

public class ChatTest {
	public static void main(String[] args) {
		ChatDAO dao = new ChatDAO();
		//message_id,user_id,r_name,message
		// select()のテスト

		System.out.println("---------- select()のテスト ----------");
		List<Chat> Chat = dao.select(new Chat(null,null,0,null));
		for (Chat c:Chat ) {
			System.out.println("Message_id：" + c.getMessage_id());
			System.out.println("user_id" + c.getUser_id());
			System.out.println("r_name：" + c.getR_id());
			System.out.println("message：" + c.getMessage());

		}


		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Chat insRec = new Chat("2","D3-21",2,"お願いします");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Chat> Chat2 = dao.select(insRec);
			for (Chat c : Chat2) {
				System.out.println("message：" + c.getMessage_id());
				System.out.println("user_id：" + c.getUser_id());
				System.out.println("r_name：" + c.getR_id());
				System.out.println("message：" + c.getMessage());
			}
		}
		else {
			System.out.println("登録失敗！");
		}


		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Chat upRec = new Chat("1","D3",1,"夢の国だよ！");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Chat> Chat3 = dao.select(upRec);
			for (Chat c : Chat3) {
				System.out.println("message_id：" + c.getMessage_id());
				System.out.println("user_id：" + c.getUser_id());
				System.out.println("r_name：" + c.getR_id());
				System.out.println("message：" + c.getMessage());

			}
		}
		else {
			System.out.println("更新失敗！");
		}


		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("2")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}

	}
}

