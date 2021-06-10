package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<Member> select(Member param) {
				Connection conn = null;
				List<Member> RoomList = new ArrayList<Member>();

				try {
					// JDRoomドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "p");

					// SQL文を準備する
					String sql = "select * from Member WHERE user_id LIKE ? AND r_name " ;
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					if (param.getUser_id() != null &&param.getUser_id() != "") {
						pStmt.setString(1, "%" + param.getUser_id() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (param.getR_name() != null &&param.getR_name() != "") {
						pStmt.setString(2, "%" + param.getR_name() + "%");
					}
					else {
						pStmt.setString(2, "%");
					}
					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Member Room = new Member(
						rs.getString("user_id"),
						rs.getString("r_name")
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
			public boolean insert(Member Room) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDRoomドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "p");

					// SQL文を準備する
					String sql = "insert into Room values ( ?, ?, ?, ? )";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (Room.getUser_id() != null) {
						pStmt.setString(1, Room.getUser_id());
					}
					else {
						pStmt.setString(1, "null");
					}
					if (Room.getR_name() != null) {
						pStmt.setString(2, Room.getR_name());
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

			// 引数Roomで指定されたレコードを更新し、成功したらtrueを返す
			public boolean update(Member Room) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDRoomドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "p");

					// SQL文を準備する
					String sql = "update Room set r_name=?, r_comment = ?, release=? ,user_id=?;";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (Room.getUser_id() != null) {
						pStmt.setString(1, Room.getUser_id());
					}
					else {
						pStmt.setString(1, "null");
					}
					if (Room.getR_name() != null) {
						pStmt.setString(2, Room.getR_name());
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
					// JDRoomドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "p");

					// SQL文を準備する
					String sql = "delete from Room where r_name = ?";
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
