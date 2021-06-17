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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String user_id = (String)session.getAttribute("user_id");
		//検索処理を行う(ユーザー検索)
		User user = new User();
		user.setUser_id(user_id);
		UserDAO uDao = new UserDAO();

		// セッションスコープにIDを格納する

		request.setAttribute("profile", uDao.select(user));

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
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
				String birth = request.getParameter("birth");
				String school= request.getParameter("school");
				String hobby = request.getParameter("hobby");
				String intro = request.getParameter("intro");
				//更新処理を行う(ユーザー更新)
				User user = new User();
				user.setUser_id(user_id);
				user.setName(name);
				user.setNickname(nickname);
				user.setBirthplace(birthplace);
				user.setBirth(birth);
				user.setSchool(school);
				user.setHobby(hobby);
				user.setIntro(intro);
				UserDAO uDao = new UserDAO();
				if(uDao.update(user)) {
					request.setAttribute("update", true);
				}
				else {
					request.setAttribute("update", false);
				}
				user = new User();
				user.setUser_id(user_id);
				uDao = new UserDAO();

				// セッションスコープにIDを格納する

				request.setAttribute("profile", uDao.select(user));
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
				dispatcher.forward(request, response);
	}
}
