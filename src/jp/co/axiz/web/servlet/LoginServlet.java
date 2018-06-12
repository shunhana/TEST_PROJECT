package jp.co.axiz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		// ログインID、パスワードを取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// 未入力のチェック
		if ((id == null || pass == null) || ("".equals(id)) || ("".equals(pass))) {
			// メッセージ設定
			request.setAttribute("msg", "IDまたはPASSが間違っています");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;//画面移動して何も処理せずに終了
		}

		LoginService ls = new LoginService();
		Admin ad = ls.authentication(id, pass);
		boolean isSuccess = (ad != null);

		// 表示メッセージの受け渡し
		if (isSuccess) {

			// メッセージ設定（セッションに保存）
			request.setAttribute("msg", "ログインできました。");
			HttpSession session = request.getSession();
			session.setAttribute("name",ad.getAdminName());
			// 次画面指定
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			// メッセージ設定
			request.setAttribute("msg", "IDまたはPASSが間違っています");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}


	}


