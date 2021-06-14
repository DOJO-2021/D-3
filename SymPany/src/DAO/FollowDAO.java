package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Follow;


public class FollowDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Follow> select(Follow param) {
		Connection conn = null;
		List<Follow> FollowList = new ArrayList<Follow>();

		try {
			// JDFollowドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "select * from FOLLOW WHERE user_id LIKE ? AND f_user_id LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getUser_id() != null &&param.getUser_id() != "") {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getF_user_id() != null &&param.getF_user_id() != "") {
				pStmt.setString(2, "%" + param.getF_user_id() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Follow Follow = new Follow(
				rs.getString("user_id"),
				rs.getString("f_user_id")
				);
				FollowList.add(Follow);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			FollowList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			FollowList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					FollowList = null;
				}
			}
		}

		// 結果を返す
		return FollowList;
	}

	// 引数Followで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Follow Follow) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDFollowドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "insert into Follow values (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (Follow.getUser_id() != null) {
				pStmt.setString(1, Follow.getUser_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (Follow.getF_user_id() != null) {
				pStmt.setString(2, Follow.getF_user_id());
			}
			else {
				pStmt.setString(2, "null");
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

	// 引数Followで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Follow Follow) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDFollowドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql =  "update Follow set user_id=? where f_user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (Follow.getUser_id() != null) {
				pStmt.setString(1, Follow.getUser_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (Follow.getF_user_id() != null) {
				pStmt.setString(2, Follow.getF_user_id());
			}
			else {
				pStmt.setString(2, "null");
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

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String name,String name2) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDFollowドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

			// SQL文を準備する
			String sql = "delete from Follow where user_id=? and f_user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, name);
			pStmt.setString(2, name2);

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
