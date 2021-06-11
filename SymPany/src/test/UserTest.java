package test;
import java.util.List;

import DAO.UserDAO;
import model.User;

public class UserTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		//message_id,user_id,r_name,message
		// select()のテスト

		System.out.println("---------- select()のテスト ----------");
		List<User> User = dao.select(new User(null,null,null,null,null,null,null,null,null));
		for (User c:User ) {
			System.out.println("User_id：" + c.getUser_id());
			System.out.println("Name" + c.getName());
			System.out.println("Nickname：" + c.getNickname());
			System.out.println("Birthplace：" + c.getBirthplace());
			System.out.println("Company：" + c.getCompany());
			System.out.println("Birth" + c.getBirth());
			System.out.println("School：" + c.getSchool());
			System.out.println("Hobby：" + c.getHobby());
			System.out.println("Intro" + c.getIntro());

		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		User insRec = new User("D3-21","黒クマ次郎","黒クマ","北極3-21-2","株式会社温暖化防止","1998-07-09","北極南大学","素潜り","");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<User> User2 = dao.select(insRec);
			for (User c : User2) {
				System.out.println("User_id：" + c.getUser_id());
				System.out.println("Name" + c.getName());
				System.out.println("Nickname：" + c.getNickname());
				System.out.println("Birthplace：" + c.getBirthplace());
				System.out.println("Company：" + c.getCompany());
				System.out.println("Birth" + c.getBirth());
				System.out.println("School：" + c.getSchool());
				System.out.println("Hobby：" + c.getHobby());
				System.out.println("Intro" + c.getIntro());

			}
		}
		else {
			System.out.println("登録失敗！");
		}


		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		User upRec = new User("D3","白クマ太郎","白クマ","北極3-21-4","株式会社温暖化防止","1998-04-22","北極南大学","素潜り","よろしくな");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<User> User3 = dao.select(upRec);
			for (User c : User3) {
				System.out.println("User_id：" + c.getUser_id());
				System.out.println("Name" + c.getName());
				System.out.println("Nickname：" + c.getNickname());
				System.out.println("Birthplace：" + c.getBirthplace());
				System.out.println("Company：" + c.getCompany());
				System.out.println("Birth" + c.getBirth());
				System.out.println("School：" + c.getSchool());
				System.out.println("Hobby：" + c.getHobby());
				System.out.println("Intro" + c.getIntro());
			}
		}
		else {
			System.out.println("更新失敗！");
		}


		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("D3-21")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}

