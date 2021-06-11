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
				List<Member> MemberList = new ArrayList<Member>();

				try {
					// JDMemberドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

					// SQL文を準備する
					String sql = "select * from Member WHERE user_id LIKE ? AND r_name LIKE ? " ;
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
						Member Member = new Member(
						rs.getString("user_id"),
						rs.getString("r_name")
						);
						MemberList.add(Member);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					MemberList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					MemberList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							MemberList = null;
						}
					}
				}

				// 結果を返す
				return MemberList;
			}

			// 引数Memberで指定されたレコードを登録し、成功したらtrueを返す
			public boolean insert(Member Member) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDMemberドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

					// SQL文を準備する
					String sql = "insert into Member values ( ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (Member.getUser_id() != null) {
						pStmt.setString(1, Member.getUser_id());
					}
					else {
						pStmt.setString(1, "null");
					}
					if (Member.getR_name() != null) {
						pStmt.setString(2, Member.getR_name());
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

			// 引数Memberで指定されたレコードを更新し、成功したらtrueを返す
			public boolean update(Member Member) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDMemberドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

					// SQL文を準備する
					String sql = "update Member set user_id=? wherer_name=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (Member.getUser_id() != null) {
						pStmt.setString(1, Member.getUser_id());
					}
					else {
						pStmt.setString(1, "null");
					}
					if (Member.getR_name() != null) {
						pStmt.setString(2, Member.getR_name());
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
					// JDMemberドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-3/D-3", "sa", "path");

					// SQL文を準備する
					String sql = "delete from Member WHERE r_name =?";
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
