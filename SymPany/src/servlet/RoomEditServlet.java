package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DAO.RoomDAO;
import model.Member;
import model.Room;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RoomEditServlet")
public class RoomEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;

		}

		// ルームのログイン状態を保持する
		request.setCharacterEncoding("UTF-8");

		int r_id = Integer.parseInt(session.getAttribute("r_id").toString());
		RoomDAO rDao = new RoomDAO();
		request.setAttribute("room", rDao.selectID(new Room(r_id, "", "", 0, "")));

		String user_id = (String) session.getAttribute("user_id");
		MemberDAO mDao = new MemberDAO();
		List<Member> rmember = mDao.selectR(new Member(user_id, 0));

		// 部屋の名前の検索処理を行う
		List<List<Room>> roomList = new ArrayList<List<Room>>();

		//参加しているルームの検索
		for (int i = 0; rmember.size() > i; i++) {
			Room room = new Room();
			room.setR_id(rmember.get(i).getR_id());
			RoomDAO Dao = new RoomDAO();
			roomList.add(Dao.selectID(room));
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("roomList", roomList);
		// ルーム編集画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomedit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int r_id = Integer.parseInt(session.getAttribute("r_id").toString());
		String r_name = request.getParameter("room_name");
		String r_comment = request.getParameter("room_comment");
		int release = Integer.parseInt(request.getParameter("open"));
		String user_id = (String) session.getAttribute("user_id");
		String sub = (String) request.getParameter("submit");

		if (sub.equals("ルームを更新する")) {
			// 更新登録処理を行う
			RoomDAO bDao = new RoomDAO();
			Room user = new Room(r_id, r_name, r_comment, release, user_id);
			if (bDao.update(user)) { // 登録成功
				MemberDAO mDao = new MemberDAO();
				List<Member> rmember = mDao.selectR(new Member(user_id, 0));
				// 部屋の名前の検索処理を行う
				List<List<Room>> roomList = new ArrayList<List<Room>>();

				//参加しているルームの検索
				for (int i = 0; rmember.size() > i; i++) {
					Room room = new Room();
					room.setR_id(rmember.get(i).getR_id());
					RoomDAO Dao = new RoomDAO();
					roomList.add(Dao.selectID(room));
				}
				request.setAttribute("roomList", roomList);
				// チャットサーブレットにリダイレクトする
				response.sendRedirect("/SymPany/ChatServlet");
			} else {
				// 登録失敗
				// ルームページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
				dispatcher.forward(request, response);
			}
		}

		else if (sub.equals("ルームを削除する")) {
			// 更新登録処理を行う
						RoomDAO bDao = new RoomDAO();
						if (bDao.delete(r_id)) { // 登録成功
							MemberDAO mDao = new MemberDAO();
							List<Member> rmember = mDao.selectR(new Member(user_id, 0));
							// 部屋の名前の検索処理を行う
							List<List<Room>> roomList = new ArrayList<List<Room>>();

							//参加しているルームの検索
							for (int i = 0; rmember.size() > i; i++) {
								Room room = new Room();
								room.setR_id(rmember.get(i).getR_id());
								RoomDAO Dao = new RoomDAO();
								roomList.add(Dao.selectID(room));
							}
							session.setAttribute("r_id",0);
							request.setAttribute("roomList", roomList);
							// チャットサーブレットにリダイレクトする
							response.sendRedirect("/SymPany/ChatServlet");
						} else {
							// 登録失敗
							// ルームページにフォワードする
							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
							dispatcher.forward(request, response);
						}
		}

	}

}
