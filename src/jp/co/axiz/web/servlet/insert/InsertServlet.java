package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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

		//入力値取得
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String pass = request.getParameter("pass");

		//名前、TEL、PASSの未入力対策
		if((name ==null || tel ==null || pass ==null) || (("".equals(name)) || ("".equals(tel) || ("".equals(pass))))) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		//セッションに値を保存
		HttpSession session = request.getSession();
		session.setAttribute("userName",name);
		session.setAttribute("telephone",tel);
		session.setAttribute("password",pass);

		//次画面指定
		request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);

	}

}
