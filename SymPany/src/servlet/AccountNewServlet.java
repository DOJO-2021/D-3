package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.IDPWDAO;
import model.IDPW;

@WebServlet("/AccountNewServlet")
public class AccountNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			dispatcher.forward(request, response);
		} else {

			response.sendRedirect("HomeServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("ID");
		String user_p = request.getParameter("PW");

		// 登録処理を行う
		IDPWDAO bDao = new IDPWDAO();
		if (bDao.insert(user_id, user_p)) { // 登録成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new IDPW(user_id, user_p));
			session.setAttribute("user_id", user_id);
			request.setAttribute("login", true);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profilenew.jsp");
			dispatcher.forward(request, response);

			// メニューサーブレットにリダイレクトする
			//response.sendRedirect("ProfileNewServlet");
		} else {
			// 登録失敗
			// 結果ページにフォワードする
			request.setAttribute("error",true);
			request.setAttribute("login", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			dispatcher.forward(request, response);
		}
	}

}
