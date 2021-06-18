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
@WebServlet("/RoomEditServlet")
public class RoomEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;

		}

		// ルームのログイン状態を保持する
					request.setCharacterEncoding("UTF-8");

		// ルーム編集画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomedit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		int r_id = Integer.parseInt(request.getParameter("r_id"));
		String r_name = request.getParameter("r_name");
		String r_comment = request.getParameter("r_comment");
		int release = Integer.parseInt(request.getParameter("release"));
		String user_id = request.getParameter("user_id");

		// 更新登録処理を行う
		RoomDAO bDao = new RoomDAO();
		Room user =  new Room(r_id,r_name,r_comment,release,user_id);
		if (bDao.update(user)) { // 登録成功

			// チャットサーブレットにリダイレクトする
			response.sendRedirect("/SymPany/RoomServlet");
		} else {
			// 登録失敗
			// ルームページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
			dispatcher.forward(request, response);
		}
	}

}
