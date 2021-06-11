package test;
import java.util.List;

import DAO.RoomDAO;
import model.Room;

public class RoomTest {
	public static void main(String[] args) {
		RoomDAO dao = new RoomDAO();
		//message_id,user_id,r_name,message
		// select()のテスト
		//R_name,R_comment,Release,User_id

		System.out.println("---------- select()のテスト ----------");
		List<Room> Room = dao.select(new Room(null,null,1,null));
		for (Room c:Room ) {
			System.out.println("R_name：" + c.getR_name());
			System.out.println("comment：" + c.getR_comment());
			System.out.println("Release：" + c.getRelease());
			System.out.println("User_id：" + c.getUser_id());
		}


		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Room insRec = new Room("犬好きの会","犬好きの人",1,"D3-21");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Room> Room2 = dao.select(insRec);
			for (Room c : Room2) {
				System.out.println("R_name：" + c.getR_name());
				System.out.println("comment：" + c.getR_comment());
				System.out.println("Release：" + c.getRelease());
				System.out.println("User_id：" + c.getUser_id());

			}
		}
		else {
			System.out.println("登録失敗！");
		}


		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Room upRec = new Room("犬好きの会","犬好きな人なら誰でもどうぞ",1,"D3-21！");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Room> Room3 = dao.select(upRec);
			for (Room c : Room3) {
				System.out.println("R_name：" + c.getR_name());
				System.out.println("comment：" + c.getR_comment());
				System.out.println("Release：" + c.getRelease());
				System.out.println("User_id：" + c.getUser_id());

			}
		}
		else {
			System.out.println("更新失敗！");
		}


		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("02")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}

