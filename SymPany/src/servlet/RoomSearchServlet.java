package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RoomDAO;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RoomSearch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String r_name = request.getParameter("r_name");
		String r_comment = request.getParameter("r_comment");
		int release = Integer.parseInt (request.getParameter("release"));
		String user_id = request.getParameter("user_id");

		// 検索処理を行う
		RoomDAO bDao = new RoomDAO();
		List<Room> cardList = bDao.select(new Room(r_name, r_comment, release, user_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RoomSearch.jsp");
		dispatcher.forward(request, response);
		}
	}