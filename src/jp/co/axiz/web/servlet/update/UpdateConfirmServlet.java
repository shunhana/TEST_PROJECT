package jp.co.axiz.web.servlet.update;

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
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirmServlet() {
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

		HttpSession session = request.getSession();

		Integer id= (Integer)session.getAttribute("defaultId");
		String name = (String)request.getParameter("newName");
		String tel= (String)request.getParameter("newTel");;

		String rePass = request.getParameter("rePass");

		//updateInput時のPASSをセッションから取得

		String oldPass = (String)session.getAttribute("updatedPass");//セッションから値を取得

		if(rePass.equals(oldPass)) {//user_infoテーブルを更新
			UserInfoService userInfoService = new UserInfoService();
			UserInfo userInfo = new UserInfo(id,name,tel,rePass);
			userInfoService.update(userInfo);
			request.getRequestDispatcher("updateResult.jsp").forward(request, response);
		}
		else {//パスワード不一致
			System.out.println(oldPass);
			System.out.println(rePass);
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");
			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
		}

	}

}
