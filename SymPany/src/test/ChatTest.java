package test;
import DAO.ChatDAO;

public class ChatTest {
	public static void main(String[] args) {
		ChatDAO dao = new ChatDAO();
/*
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Bc> cardList2 = dao.select(new Bc(0, "不動産", null, null, null, null, null, null, null, null, null, null, null, null));
		for (Bc card : cardList2) {
			System.out.println("Id：" + card.getId());
			System.out.println("Company：" + card.getCompany_name());
			System.out.println("Company_kana：" + card.getCompany_name_kana());
			System.out.println("Name：" + card.getName());
			System.out.println("Name_kana：" + card.getName_kana());
			System.out.println("Department：" + card.getDepartment());
			System.out.println("Sex：" + card.getSex());
			System.out.println("Birthday：" + card.getBirthday());
			System.out.println("Zip_code：" + card.getZip_code());
			System.out.println("Address：" + card.getAddress());
			System.out.println("Phone：" + card.getPhone());
			System.out.println("Mail：" + card.getMail());
			System.out.println("registration：" + card.getRegistration());
			System.out.println("Other：" + card.getOther());
			System.out.println();
		}
*/
/*
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Bc insRec = new Bc(0, "NTT東日本","エヌ・ティ・ティヒガシニホン","山本六郎","ヤマモトロクロウ", "営業部","M","1995-09-21","213-2234","東京都港区","080-2299-9800","6ro@docomo.ne.jp","2021-05-21",null);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Bc> cardList3 = dao.select(insRec);
			for (Bc card : cardList3) {
				System.out.println("Id：" + card.getId());
				System.out.println("Company：" + card.getCompany_name());
				System.out.println("Company_kana：" + card.getCompany_name_kana());
				System.out.println("Name：" + card.getName());
				System.out.println("Name_kana：" + card.getName_kana());
				System.out.println("Department：" + card.getDepartment());
				System.out.println("Sex：" + card.getSex());
				System.out.println("Birthday：" + card.getBirthday());
				System.out.println("Zip_code：" + card.getZip_code());
				System.out.println("Address：" + card.getAddress());
				System.out.println("Phone：" + card.getPhone());
				System.out.println("Mail：" + card.getMail());
				System.out.println("registration：" + card.getRegistration());
				System.out.println("Other：" + card.getOther());
				System.out.println();
			}
		}
		else {
			System.out.println("登録失敗！");
		}
*/
/*
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Bc upRec = new Bc(6, "NTT東日本","エヌ・ティ・ティヒガシニホン","山本六郎","ヤマモトロクロウ", "広報部","M","1995-09-21","213-2234","東京都港区","080-2299-9800","6ro@docomo.ne.jp","2021-05-21","小麦粉アレルギー");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Bc> cardList4 = dao.select(upRec);
			for (Bc card : cardList4) {
				System.out.println("Id：" + card.getId());
				System.out.println("Company：" + card.getCompany_name());
				System.out.println("Company_kana：" + card.getCompany_name_kana());
				System.out.println("Name：" + card.getName());
				System.out.println("Name_kana：" + card.getName_kana());
				System.out.println("Department：" + card.getDepartment());
				System.out.println("Sex：" + card.getSex());
				System.out.println("Birthday：" + card.getBirthday());
				System.out.println("Zip_code：" + card.getZip_code());
				System.out.println("Address：" + card.getAddress());
				System.out.println("Phone：" + card.getPhone());
				System.out.println("Mail：" + card.getMail());
				System.out.println("registration：" + card.getRegistration());
				System.out.println("Other：" + card.getOther());
				System.out.println();
			}
		}
		else {
			System.out.println("更新失敗！");
		}
*/

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(6)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}

