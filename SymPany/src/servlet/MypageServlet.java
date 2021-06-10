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

@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/login.servlet");
			return;
		}

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TEST-濱田/mypage.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("test");

		//検索処理を行う(ユーザー検索)
		User user = new User();
		user.setUser_id(user_id);
		UserDAO uDao = new UserDAO();

		// セッションスコープにIDを格納する
		HttpSession session = request.getSession();
		session.setAttribute("profile", uDao.select(user));

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TEST-濱田/mypage.jsp");
		dispatcher.forward(request, response);
	}
}
