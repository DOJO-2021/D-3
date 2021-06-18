package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import model.Member;
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {

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
		String user_id = (String)session.getAttribute("user_id");
		int r_id = Integer.parseInt(request.getParameter("r_id"));

		// ルームに参加メンバーを追加する
		MemberDAO mDao = new MemberDAO();
		if (req.equals("参加")) {
			Member member = new Member(user_id, r_id);
			if (mDao.insert(member)) {
				request.setAttribute("insert",true);
			}
			else {
				request.setAttribute("insert",false);
			}
		}
		//ルームからメンバーを削除する
		else if (req.equals("脱退")) {
			if (mDao.delete (r_id)) {
				request.setAttribute("delete",true);
				session.setAttribute("r_id", 0);
			}
			else {
				request.setAttribute("delete",false);
			}
		}


		// ルームページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("ChatServlet");
		dispatcher.forward(request, response);
	}

}
