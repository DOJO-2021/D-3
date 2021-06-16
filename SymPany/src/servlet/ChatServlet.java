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

import DAO.ChatDAO;
import DAO.MemberDAO;
import DAO.ReactionDAO;
import DAO.RoomDAO;
import DAO.UserDAO;
import model.Chat;
import model.Member;
import model.Reaction;
import model.Room;
import model.User;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
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
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = "222";//(String) session.getAttribute("user_id");
		int r_id = 1;//Integer.parseInt((String)session.getAttribute("r_id"));



		User user = new User();
		user.setUser_id(user_id);
		UserDAO uDao = new UserDAO();

		Room room = new Room();
		room.setR_id(r_id);
		RoomDAO rDao = new RoomDAO();

		Chat chat = new Chat();
		chat.setR_id(r_id);
		ChatDAO cDao = new ChatDAO();

		Member member = new Member();
		member.setR_id(r_id);
		MemberDAO mDao = new MemberDAO();

		Reaction reaction = new Reaction();
		reaction.setUser_id(user_id);
		ReactionDAO reDao = new ReactionDAO();

		List<Room> rList = rDao.select(room);
		List<Chat> cList = cDao.select(chat);
		List<Member> mList = mDao.select(member);
		List<Reaction> reList = reDao.select(reaction);

		List<User> uList = new ArrayList<User>();
		List<User> sum = new ArrayList<User>();

		for(Member m : mList) {
			user = new User();
			user.setUser_id(m.getUser_id());
			uDao = new UserDAO();
			uList = uDao.select(user);
			int j = 0;
			for(User u:uList) {
				for(int i = 0; i<sum.size();i++) {
					if(u.getUser_id()==sum.get(i).getUser_id()) {
						j=i;
						break;
					}
					j=i+1;
				}
				if(j==sum.size()) {
					sum.add(u);
				}

			}

		}

		request.setAttribute("room",rList);
		request.setAttribute("chat", cList);
		request.setAttribute("member", mList);
		request.setAttribute("reaction",reList);
		request.setAttribute("list", sum);


		System.out.println("");
		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		int r_id = Integer.parseInt((String)session.getAttribute("r_id"));
		String submit = request.getParameter("submit");


		ChatDAO cDao = new ChatDAO();

		if(submit.equals("送信")) {
			String message = request.getParameter("message");

			if(cDao.insert(new Chat(0,user_id,r_id,message))) {
				request.setAttribute("insert", true);
			}
			else {
				request.setAttribute("insert",false);
			}
		}

		User user = new User();
		user.setUser_id(user_id);
		UserDAO uDao = new UserDAO();

		Room room = new Room();
		room.setR_id(r_id);
		RoomDAO rDao = new RoomDAO();

		Chat chat = new Chat();
		chat.setR_id(r_id);
		 cDao = new ChatDAO();

		Member member = new Member();
		member.setR_id(r_id);
		MemberDAO mDao = new MemberDAO();

		Reaction reaction = new Reaction();
		reaction.setUser_id(user_id);
		ReactionDAO reDao = new ReactionDAO();

		List<Room> rList = rDao.select(room);
		List<Chat> cList = cDao.select(chat);
		List<Member> mList = mDao.select(member);
		List<Reaction> reList = reDao.select(reaction);

		List<User> uList = new ArrayList<User>();
		List<User> sum = new ArrayList<User>();

		for(Member m : mList) {
			user = new User();
			user.setUser_id(m.getUser_id());
			uDao = new UserDAO();
			uList = uDao.select(user);
			int j = 0;
			for(User u:uList) {
				for(int i = 0; i<sum.size();i++) {
					if(u.getUser_id()==sum.get(i).getUser_id()) {
						j=i;
						break;
					}
					j=i+1;
				}
				if(j==sum.size()) {
					sum.add(u);
				}
			}
		}

		request.setAttribute("room",rList);
		request.setAttribute("chat", cList);
		request.setAttribute("member", mList);
		request.setAttribute("reaction",reList);
		request.setAttribute("list", sum);


		System.out.println("");
		// ルームページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileSearchServlet");
		dispatcher.forward(request, response);
	}
}
