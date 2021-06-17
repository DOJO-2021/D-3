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

import DAO.MemberDAO;
import DAO.RoomDAO;
import model.Member;
import model.Room;

/**
 * Servlet implementation class RoomSearchServlet
 */
@WebServlet("/RoomSearchServlet")
public class RoomSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// profile画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomsearch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String search =request.getParameter("search");
		HttpSession session = request.getSession();

		int r_id = 0;
		String r_name = "";
		String r_comment = "";
		int release = 0;
		String user_id = "";
		//合計
		List<Room> sum = new ArrayList<Room>();
		RoomDAO bDao = new RoomDAO();

		// 検索処理を行う(ルーム名)
		List<Room> list = bDao.selectR(new Room(r_id,search, r_comment, release, user_id));
		for(Room a:list) {
			int j = 0;
			//重複がないかのチェック
			for(int i = 0;i<sum.size();i++) {
				if(sum.get(i).getR_id()==a.getR_id()) {
					j=i;
					break;
				}
				j=i+1;
			}
			if(j==sum.size()) {//重複がない場合は追加する。
				sum.add(a);
			}
		}

		//検索処理を行う（一言コメント）
		list = bDao.selectR(new Room(r_id,r_name, search, release, user_id));
		for(Room a:list) {
			int j = 0;
			//重複がないかのチェック
			for(int i = 0;i<sum.size();i++) {
				if(sum.get(i).getR_id()==a.getR_id()) {
					j=i;
					break;
				}
				j=i+1;
			}
			if(j==sum.size()) {//重複がない場合は追加する。
				sum.add(a);
			}
		}
		//参加しているルームの検索
		Member member= new Member();
		member.setUser_id((String)session.getAttribute("user_id"));
		MemberDAO mDao = new MemberDAO();

		List<Member> memList = mDao.selectR(member);


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("list", sum);
		request.setAttribute("search", search);
		request.setAttribute("member",memList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/roomsearch.jsp");
		dispatcher.forward(request, response);
		}
	}