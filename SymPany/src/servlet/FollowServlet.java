package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.FollowDAO;
import DAO.UserDAO;
import model.Follow;
import model.User;
@WebServlet("/FollowServlet")
public class FollowServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/SymPany/LoginServlet");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String user_id = (String)session.getAttribute("user_id");

		//検索処理を行う（フォロー検索）
		Follow follow = new Follow();
		follow.setUser_id(user_id);
		FollowDAO fDao = new FollowDAO();

		//検索処理を行う（フォロープロフィール検索）
		List<Follow> followList =new ArrayList<Follow>();
		List<User> user = new ArrayList<User>();
		List<List<User>> userList = new ArrayList<List<User>>();
		followList = fDao.select(follow);

		//フォローしている人のプロフィールの検索
		for(int i=0;followList.size()>i;i++) {
			User fUser =new User();
			fUser.setUser_id(followList.get(i).getF_user_id());
			UserDAO Dao = new UserDAO();
			userList.add(Dao.select(fUser));
		}
		// セッションスコープにIDを格納する

		request.setAttribute("follow",fDao.select(follow));
		request.setAttribute("list", userList);

		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/follow.jsp");
		dispatcher.forward(request, response);
	}
}
