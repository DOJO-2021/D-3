package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

@WebServlet("/ProfileSearchServlet")
public class ProfileSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profilesearch.jsp");
		dispatcher.forward(request, response);
	}
	//test
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = request.getParameter("ID");
				String name = request.getParameter("NAME");
				String nickname = request.getParameter("NICKNAME");
				String birthplace = request.getParameter("BIRTHPLACE");
				String company = request.getParameter("COMPANY");
				String birth = request.getParameter("BIRTH");
				String school = request.getParameter("SCHOOL");
				String hobby = request.getParameter("HOBBY");
				String intro = request.getParameter("INTRO");

				// 検索処理を行う
				UserDAO bDao = new UserDAO();
				List<User> cardList = bDao.select(new User(user_id, name, nickname, birthplace, company, birth,  school, hobby, intro));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profilesearch.jsp");
				dispatcher.forward(request, response);
			}
}