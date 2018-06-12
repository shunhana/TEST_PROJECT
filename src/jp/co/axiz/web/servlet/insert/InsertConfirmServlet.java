package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserInfo;
import service.UserInfoService;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet("/insertConfirm")
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//文字化け対策

		//入力値（再入力パスワード）
		String repass = request.getParameter("rePass");

		//セッションから値を取得
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("userName");//以前に入力したpassをセッションから所得
		String tel = (String)session.getAttribute("telephone");//以前に入力したtelをセッションから所得
		String pass = (String)session.getAttribute("password");//以前に入力したpassをセッションから所得

		//1度目のパスと2度目のパスを比較
		if(pass.equals(repass)) {//パスが同じだったとき
			//user_infoテーブルに値を保存
			try {
				UserInfoService useｒInfoService = new UserInfoService();
				UserInfo userInfo = new UserInfo(name, tel, pass);

				session.setAttribute("defaultId", useｒInfoService.insert(userInfo));//登録したレコードをセッションに保存

				request.getRequestDispatcher("insertResult.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			request.getRequestDispatcher("insertResult.jsp").forward(request, response);
			return;

			//次画面指定

		}
		else {//パスが違ったとき
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
		}

	}

}
