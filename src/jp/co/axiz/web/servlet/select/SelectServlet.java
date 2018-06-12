package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserInfo;
import service.UserInfoService;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//文字化け対策
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		//入力値のidのところをIntegerに合わせて比較

		//全て未入力の場合
		if ((id ==null && name ==null && tel ==null) || (("".equals(id)) && ("".equals(name) && ("".equals(tel))))) {
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.find();
			request.setAttribute("infoList", list);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//idのみ入力の時の処理
		else if((id != null && name == null && tel == null) || (!("".equals(id)) && ("".equals(name) && ("".equals(tel))))) {
			Integer iId = Integer.parseInt(id);
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.findById(iId);
			if(list != null) {
				request.setAttribute("infoList", list);
			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//user_nameのみ入力の時の処理
		else if((id == null && name != null && tel == null) || ("".equals(id)) && (!("".equals(name)) && ("".equals(tel)))) {
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.findByName(name);
			if(list != null) {
				request.setAttribute("infoList", list);
			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}


			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//telephoneのみ入力の時の処理
		else if((id == null && name == null && tel != null) || ("".equals(id)) && ("".equals(name) && (!("".equals(tel))))) {
			System.out.print(tel);
			System.out.print(id);
			System.out.print(name);
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.findByTel(tel);if(list != null) {
				request.setAttribute("infoList", list);
			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}


			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//idとuser_name入力時の処理
		else if((id != null && name != null && tel == null) || (!("".equals(id)) && (!("".equals(name)) && ("".equals(tel))))) {
			Integer iId = Integer.parseInt(id);
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.findByIdAndName(iId,name);
			if(list != null) {
				request.setAttribute("infoList", list);
			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}


			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//idとtelephone入力時の処理
		else if((id != null && name == null && tel != null) || (!("".equals(id)) && ("".equals(name) && (!("".equals(tel)))))) {
			Integer iId = Integer.parseInt(id);
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.findByIdAndTel(iId,tel);
			if(list != null) {
				request.setAttribute("infoList", list);
			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}


			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//user_nameとtelephone入力時の処理
		else if((id == null && name != null && tel != null) || ("".equals(id)) && (!("".equals(name)) && (!("".equals(tel))))) {
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo> list = userInfoService.findByNameAndTel(name,tel);
			if(list != null) {
				request.setAttribute("infoList", list);
			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}


			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}
		//全部入力
		else{Integer iId = Integer.parseInt(id);
		UserInfoService userInfoService = new UserInfoService();
		List<UserInfo> list = userInfoService.findByIdAndNameAndTel(iId,name,tel);
		if(list != null) {
			request.setAttribute("infoList", list);
		}
		else {
			request.setAttribute("msg", "入力されたデータはありませんでした");
			request.getRequestDispatcher("select.jsp").forward(request, response);
			return;
		}

		// 次画面指定
		request.getRequestDispatcher("selectResult.jsp").forward(request, response);
		return;
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
