package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RoomDAO;
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

		// ルーム作成画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomnew.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String user_id = request.getParameter("user_id");
		String room_name = request.getParameter("room_name");
		String room_comment = request.getParameter("room_comment");
		int pub = Integer.parseInt(request.getParameter("open"));

		// 登録処理を行う
		RoomDAO bDao = new RoomDAO();
		Room user = new Room(room_name,room_comment,pub,user_id);
		if (bDao.insert(user)) { // 登録成功

			// チャットサーブレットにリダイレクトする
			response.sendRedirect("/SymPany/ChatServlet");
		} else {
			// 登録失敗
			// チャットページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
			dispatcher.forward(request, response);
		}
	}

}

