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
@WebServlet("/LeftmenuServlet")
public class LeftmenuServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		//所属している部屋の検索処理を行う
		MemberDAO mDao= new MemberDAO();
		List<Member> member = mDao.selectR(new Member(user_id,0));

		// 部屋の名前の検索処理を行う
		List<List<Room>> roomList = new ArrayList<List<Room>>();

		//参加しているルームの検索
		for(int i=0;member.size()>i;i++) {
			Room room =new Room();
			room.setR_id(member.get(i).getR_id());
			RoomDAO Dao = new RoomDAO();
			roomList.add(Dao.selectID(room));
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("roomList", roomList);

		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/leftmenu.jsp");
		dispatcher.forward(request, response);
	}
}

