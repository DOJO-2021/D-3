package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<User> select(User param) {
		Connection conn = null;
		List<User> UserList = new ArrayList<User>();

		try {
			// JDUserドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "select * from User WHERE user_id LIKE ? AND name LIKE ? AND nickname LIKE ?  "
					+ "AND birthplace LIKE ? AND company LIKE ? AND birth LIKE ? AND school LIKE ?"
					+ " AND hobby LIKE ?  AND intro LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getUser_id() != null &&param.getUser_id() != "") {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getName() != null &&param.getName() != "") {
				pStmt.setString(2, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getNickname() != null && param.getNickname() != "") {
				pStmt.setString(3, "%" + param.getNickname() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getBirthplace() != null && param.getBirthplace() != "") {
				pStmt.setString(4, "%" + param.getBirthplace() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getCompany() != null && param.getCompany() != "") {
				pStmt.setString(5, "%" + param.getCompany() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getBirth() != null && param.getBirth() != "") {
				pStmt.setString(6, "%" + param.getBirth() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}
			if (param.getSchool() != null && param.getSchool() != "") {
				pStmt.setString(7, "%" + param.getSchool() + "%");
			}
			else {
				pStmt.setString(7, "%");
			}
			if (param.getHobby() != null && param.getHobby() != "") {
				pStmt.setString(8, "%" + param.getHobby() + "%");
			}
			else {
				pStmt.setString(8, "%");
			}
			if (param.getIntro() != null && param.getIntro() != "") {
				pStmt.setString(9, "%" + param.getIntro() + "%");
			}
			else {
				pStmt.setString(9, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				User User = new User(
				rs.getString("user_id"),
				rs.getString("name"),
				rs.getString("nickname"),
				rs.getString("birthplace"),
				rs.getString("company"),
				rs.getString("birth"),
				rs.getString("school"),
				rs.getString("hobby"),
				rs.getString("intro")
				);
				UserList.add(User);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			UserList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			UserList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					UserList = null;
				}
			}
		}

		// 結果を返す
		return UserList;
	}

	// 引数Userで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User User) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDUserドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "insert into User values ( ?, ?, ?, ? ,? ,? ,? ,? ,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (User.getUser_id() != null) {
				pStmt.setString(1, User.getUser_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (User.getName() != null) {
				pStmt.setString(2, User.getName());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (User.getNickname() != null) {
				pStmt.setString(3, User.getNickname());
			}
			else {
				pStmt.setString(3, "null");
			}

			if (User.getBirthplace() != null) {
				pStmt.setString(4, User.getBirthplace());
			}
			else {
				pStmt.setString(4, "null");
			}

			if (User.getCompany() != null) {
				pStmt.setString(5, User.getCompany());
			}
			else {
				pStmt.setString(5, "null");
			}
			if (User.getBirth() != null) {
				pStmt.setString(6, User.getBirth());
			}
			else {
				pStmt.setString(6, "null");
			}
			if (User.getSchool() != null) {
				pStmt.setString(7, User.getSchool());
			}
			else {
				pStmt.setString(7, "null");
			}
			if (User.getHobby() != null) {
				pStmt.setString(8, User.getHobby());
			}
			else {
				pStmt.setString(8, "null");
			}
			if (User.getIntro() != null) {
				pStmt.setString(9, User.getIntro());
			}
			else {
				pStmt.setString(9, "null");
			}
			// SQL文を実行する

		if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数Userで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(User User) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDUserドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "update User set name=?,nickname=?,"
					+ "birthplace=?,company=?,birth=?,school=?,"
					+ "hobby=?,intro=? where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (User.getName() != null) {
				pStmt.setString(1, User.getName());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (User.getNickname() != null) {
				pStmt.setString(2, User.getNickname());
			}
			else {
				pStmt.setString(2, "null");
			}

			if (User.getBirthplace() != null) {
				pStmt.setString(3, User.getBirthplace());
			}
			else {
				pStmt.setString(3, "null");
			}

			if (User.getCompany() != null) {
				pStmt.setString(4, User.getCompany());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (User.getBirth() != null) {
				pStmt.setString(5, User.getBirth());
			}
			else {
				pStmt.setString(5, "null");
			}
			if (User.getSchool() != null) {
				pStmt.setString(6, User.getSchool());
			}
			else {
				pStmt.setString(6, "null");
			}
			if (User.getHobby() != null) {
				pStmt.setString(7, User.getHobby());
			}
			else {
				pStmt.setString(7, "null");
			}
			if (User.getIntro() != null) {
				pStmt.setString(8, User.getIntro());
			}
			else {
				pStmt.setString(8, "null");
			}
			if (User.getUser_id() != null) {
				pStmt.setString(9, User.getUser_id());
			}
			else {
				pStmt.setString(9, "null");
			}
			System.out.println(pStmt);
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDUserドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "delete from User where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


}
