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
@WebServlet("/RoomNewServlet")
public class RoomNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;
		}

		String user_id =(String)session.getAttribute("user_id");
		MemberDAO mDao =new MemberDAO();
		List<Member> rmember = mDao .selectR(new Member(user_id,0));

		// 部屋の名前の検索処理を行う
		List<List<Room>> roomList = new ArrayList<List<Room>>();

		//参加しているルームの検索
		for(int i=0;rmember.size()>i;i++) {
			Room room =new Room();
			room.setR_id(rmember.get(i).getR_id());
			RoomDAO Dao = new RoomDAO();
			roomList.add(Dao.selectID(room));
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("roomList",roomList);
		// ルーム作成画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomnew.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		//String user_id = request.getParameter("user_id");
		String room_name = request.getParameter("room_name");
		String room_comment = request.getParameter("room_comment");
		int pub = Integer.parseInt(request.getParameter("open"));
		MemberDAO mDao =new MemberDAO();
		List<Member> rmember = mDao .selectR(new Member(user_id,0));

		// 部屋の名前の検索処理を行う
		List<List<Room>> roomList = new ArrayList<List<Room>>();

		//参加しているルームの検索
		for(int i=0;rmember.size()>i;i++) {
			Room room =new Room();
			room.setR_id(rmember.get(i).getR_id());
			RoomDAO Dao = new RoomDAO();
			roomList.add(Dao.selectID(room));
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("roomList",roomList);
		// 登録処理を行う
		RoomDAO bDao = new RoomDAO();
		Room user = new Room(room_name,room_comment,pub,user_id);
		if (bDao.insert(user)) { // 登録成功

			// チャットサーブレットにリダイレクトする
			response.sendRedirect("/SymPany/ChatServlet");
			request.setAttribute("login", true);
		} else {
			// 登録失敗
			// チャットページにフォワードする
			request.setAttribute("error",true);
			request.setAttribute("login", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
			dispatcher.forward(request, response);
		}
	}

}

