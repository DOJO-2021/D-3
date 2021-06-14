package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChatDAO;
import model.Room;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RoomNewServlet")
public class RoomEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;
		}

		// ルーム編集画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomedit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String r_name = request.getParameter("r_name");
		String r_comment = request.getParameter("r_comment");
		String release = request.getParameter("release");
		int pub = Integer.parseInt(request.getParameter("user_id"));

		// 更新登録処理を行う
		ChatDAO bDao = new ChatDAO();
		Room user = new Room(r_name_r_comment,release,user_id);
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
