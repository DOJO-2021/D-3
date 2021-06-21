package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.FollowDAO;
import model.Follow;
@WebServlet("/FollowerServlet")
public class FollowerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		HttpSession session = request.getSession();
		String req = request.getParameter("submit");
		String user_id = (String) session.getAttribute("user_id");
		String fuser_id = request.getParameter("user_id");
		FollowDAO fDao = new FollowDAO();
		if (req.equals("フォローする")) {
			Follow follow = new Follow(user_id, fuser_id);
			if (fDao.insert(follow)) {
				request.setAttribute("insert",true);
			}
			else {
				request.setAttribute("insert",false);
			}
		}else if (req.equals("フォロー解除")) {
			if (fDao.delete(user_id, fuser_id)) {
				request.setAttribute("delete",true);
			}
			else {
				request.setAttribute("delete",false);
			}
		}


		// ルームページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileSearchServlet");
		dispatcher.forward(request, response);
	}

}
