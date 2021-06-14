package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chat;

//message_id,user_id,r_name,message

public class ChatDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Chat> select(Chat param) {
			Connection conn = null;
			List<Chat> ChatList = new ArrayList<Chat>();

			try {
				// JDChatドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "select * from Chat WHERE message_id=? AND user_id LIKE ? AND r_id=?  AND message LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setInt(1, param.getMessage_id());
				if (param.getUser_id() != null &&param.getUser_id() != "") {
					pStmt.setString(2, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}

					pStmt.setInt(3, param.getR_id());


				if (param.getMessage() != null && param.getMessage() != "") {
					pStmt.setString(4, "%" + param.getMessage() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Chat Chat = new Chat(
					rs.getInt("message_id"),
					rs.getString("user_id"),
					rs.getInt("r_id"),
					rs.getString("message")
					);
					ChatList.add(Chat);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ChatList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ChatList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ChatList = null;
					}
				}
			}

			// 結果を返す
			return ChatList;
		}

		// 引数Chatで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Chat Chat) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDChatドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "insert into Chat(user_id,r_id,message) values( ?, ?, ? )";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				if (Chat.getUser_id() != null) {
					pStmt.setString(1, Chat.getUser_id());
				}
				else {
					pStmt.setString(1, "null");
				}

					pStmt.setInt(2, Chat.getR_id());

				if (Chat.getMessage() != null) {
					pStmt.setString(3, Chat.getMessage());
				}
				else {
					pStmt.setString(3, "null");
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

		// 引数Chatで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Chat Chat) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDChatドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "update Chat set user_id = ?, r_id=? ,message=? where message_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				if (Chat.getUser_id() != null) {
					pStmt.setString(1, Chat.getUser_id());
				}
				else {
					pStmt.setString(1, "null");
				}

					pStmt.setInt(2, Chat.getR_id());

				if (Chat.getMessage() != null) {
					pStmt.setString(3, Chat.getMessage());
				}
				else {
					pStmt.setString(3, "null");
				}pStmt.setInt(4, Chat.getMessage_id());


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
		public boolean delete(int name) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDChatドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "delete from Chat where message_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, name);

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
