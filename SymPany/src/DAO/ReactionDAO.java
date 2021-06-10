package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reaction;

//message_id,user_id,r_name,message

public class ReactionDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Reaction> select(Reaction param) {
			Connection conn = null;
			List<Reaction> ReactionList = new ArrayList<Reaction>();

			try {
				// JDReactionドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "select * from Reaction WHERE user_id LIKE ? AND message_id LIKE ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				if (param.getUser_id() != null &&param.getUser_id() != "") {
					pStmt.setString(1, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getMessage_id() != null &&param.getMessage_id() != "") {
					pStmt.setString(2, "%" + param.getMessage_id() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Reaction Reaction = new Reaction(
					rs.getString("user_id"),
					rs.getString("message_id")
					);
					ReactionList.add(Reaction);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ReactionList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ReactionList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ReactionList = null;
					}
				}
			}

			// 結果を返す
			return ReactionList;
		}

		// 引数Reactionで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Reaction Reaction) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDReactionドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "insert into Reaction values ( ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (Reaction.getUser_id() != null) {
					pStmt.setString(1, Reaction.getUser_id());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (Reaction.getMessage_id() != null) {
					pStmt.setString(2, Reaction.getMessage_id());
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

		// 引数Reactionで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Reaction Reaction) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDReactionドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "update Reaction set user_id=?, message_id =?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (Reaction.getUser_id() != null) {
					pStmt.setString(1, Reaction.getUser_id());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (Reaction.getMessage_id() != null) {
					pStmt.setString(2, Reaction.getMessage_id());
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
		public boolean delete(String name) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDReactionドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "delete from Reaction where message_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, name);

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
