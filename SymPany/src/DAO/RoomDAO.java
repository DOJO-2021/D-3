package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Room;


public class RoomDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Room> select(Room param) {
			Connection conn = null;
			List<Room> RoomList = new ArrayList<Room>();

			try {
				// JDRoomドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "select * from ROOM WHERE r_name LIKE ? AND r_id=? AND r_comment LIKE ? AND release=? AND user_id LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				if (param.getR_name() != null &&param.getR_name() != "") {
					pStmt.setString(1, "%" + param.getR_name() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}

					pStmt.setInt(2,  param.getR_id() );

				if (param.getR_comment() != null &&param.getR_comment() != "") {
					pStmt.setString(3, "%" + param.getR_comment() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}

					pStmt.setInt(4,  param.getRelease() );


				if (param.getUser_id() != null && param.getUser_id() != "") {
					pStmt.setString(5, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Room Room = new Room(
					rs.getString("r_name"),
					rs.getInt("r_id"),
					rs.getString("r_comment"),
					rs.getInt("release"),
					rs.getString("user_id")
					);
					RoomList.add(Room);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				RoomList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				RoomList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						RoomList = null;
					}
				}
			}

			// 結果を返す
			return RoomList;
		}

		// 引数Roomで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Room Room) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDRoomドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "insert into Room values ( ?, ?, ?, ?, ? )";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (Room.getR_name() != null) {
					pStmt.setString(1, Room.getR_name());
				}
				else {
					pStmt.setString(1, "null");
				}

				pStmt.setInt(2,  Room.getR_id() );

				if (Room.getR_comment() != null) {
					pStmt.setString(3, Room.getR_comment());
				}
				else {
					pStmt.setString(3, "null");
				}
				pStmt.setInt(4,  Room.getRelease() );

				if (Room.getUser_id() != null) {
					pStmt.setString(5, Room.getUser_id());
				}
				else {
					pStmt.setString(5, "null");
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

		// 引数Roomで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Room Room) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDRoomドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "update Room set r_name=?, r_comment = ?, release=?, user_id=? where r_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (Room.getR_name() != null) {
					pStmt.setString(1, Room.getR_name());
				}
				else {
					pStmt.setString(1, "null");
				}

				pStmt.setInt(2,  Room.getR_id() );

				if (Room.getR_comment() != null) {
					pStmt.setString(3, Room.getR_comment());
				}
				else {
					pStmt.setString(3, "null");
				}
				pStmt.setInt(4,  Room.getRelease() );

				if (Room.getUser_id() != null) {
					pStmt.setString(5, Room.getUser_id());
				}
				else {
					pStmt.setString(5, "null");
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
		public boolean delete(int name) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDRoomドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

				// SQL文を準備する
				String sql = "delete from Room where r_id = ?";
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
