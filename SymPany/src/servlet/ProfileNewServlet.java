package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/ProfileNewServlet")
public class ProfileNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;
		}

		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profilenew.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String birthplace = request.getParameter("birthplace");
		String company = request.getParameter("company");
		String birth = request.getParameter("birth");
		String school = request.getParameter("school");
		String hobby = request.getParameter("hobby");
		String intro = request.getParameter("intro");



		// 登録処理を行う
		UserDAO bDao = new UserDAO();
		User user = new User(user_id,name,nickname,birthplace,company,birth,school,hobby,intro);
		if (bDao.insert(user)) { // 登録成功

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/SymPany/HomeServlet");
		} else {
			// 登録失敗
			// プロフィール登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			dispatcher.forward(request, response);
		}
	}

}

