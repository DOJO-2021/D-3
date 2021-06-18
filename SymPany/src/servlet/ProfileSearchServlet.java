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
				HttpSession session = request.getSession();

				String search = request.getParameter("search");
				String user_id = "";
				String name = "";
				String nickname = "";
				String birthplace ="";
				String company ="";
				String birth = "";
				String school = "";
				String hobby = "";
				String intro = "";

				List<User> sum  =new ArrayList<User>();
				UserDAO bDao = new UserDAO();

				// 検索処理を行う（名前）
				List<User> list = bDao.select(new User(user_id, search, nickname, birthplace, company, birth,  school, hobby, intro));
				for(User a:list) {
					int j = 0;
					//重複がないかのチェック
					for(int i = 0;i<sum.size();i++) {
						if(sum.get(i).getUser_id()==a.getUser_id()) {
							j=i;
							break;
						}
						j=i+1;
					}
					if(j==sum.size()) {//重複がない場合は追加する。
						sum.add(a);
					}
				}

				// 検索処理を行う（ニックネーム）
				 list = bDao.select(new User(user_id, name, search, birthplace, company, birth,  school, hobby, intro));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}

				// 検索処理を行う（出身地）
				 list = bDao.select(new User(user_id, name, nickname, search, company, birth,  school, hobby, intro));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}

				// 検索処理を行う（所属企業）
				 list = bDao.select(new User(user_id, name, nickname, birthplace, search, birth,  school, hobby, intro));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}

				// 検索処理を行う（誕生日）
				 list = bDao.select(new User(user_id, name, nickname, birthplace, company, search,  school, hobby, intro));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}

				// 検索処理を行う（出身学校）
				 list = bDao.select(new User(user_id, name, nickname, birthplace, company, birth,  search, hobby, intro));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}

				// 検索処理を行う（趣味）
				 list = bDao.select(new User(user_id, name, nickname, birthplace, company, birth,  school, search, intro));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}

				// 検索処理を行う（自己紹介）
				 list = bDao.select(new User(user_id, name, nickname, birthplace, company, birth,  school, hobby, search));
				 for(User a:list) {
						int j = 0;
						for(int i = 0;i<sum.size();i++) {
							if(sum.get(i).getUser_id()==a.getUser_id()) {
								j=i;
								break;
							}
							j=i+1;
						}
						if(j==sum.size()) {
							sum.add(a);
						}
					}
				 FollowDAO fDao = new FollowDAO();
				 List<Follow> follow= fDao.select(new Follow((String)session.getAttribute("user_id"),""));
				 
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("list", sum);
				request.setAttribute("search", search);
				request.setAttribute("follow", follow);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profilesearch.jsp");
				dispatcher.forward(request, response);
			}
}