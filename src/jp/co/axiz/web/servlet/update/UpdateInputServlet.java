package jp.co.axiz.web.servlet.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserInfo;

/**
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
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

		String id = request.getParameter("id");//入力値を取得
		String newName = request.getParameter("newName");//入力値を取得
		String newTel = request.getParameter("newTel");//入力値を取得
		String newPass = request.getParameter("newPass");//入力値を取得
		//request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
		HttpSession session = request.getSession();

		Integer iId = Integer.parseInt(id);
		List<UserInfo>list = (List)session.getAttribute("updateUser");//セッションから値を取得
		UserInfo userInfo = list.get(0);

		Integer ID = userInfo.getUserId();
		String oldName = userInfo.getUserName();
		String oldTel = userInfo.getTelephone();
		String oldPass = userInfo.getPassword();

		if(oldPass.equals(newPass)) {//入力値とidから探したPASSが一致するかどうか
			request.setAttribute("samePass", oldPass);
		}else {//入力値とidから探したPASSが一致しない

		}

		if(newName.equals(oldName) && newTel.equals(oldTel) && newPass.equals(oldPass)) {//未変更の場合
			request.setAttribute("msg", "1項目以上変更して下さい");
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
		}
		else {//変更があった場合
			session.setAttribute("defaultId", ID);//idに合致するレコードをセッションに保存
			session.setAttribute("updatedName", oldName);//idに合致するレコードをセッションに保存
			session.setAttribute("updatedTel", oldTel);//idに合致するレコードをセッションに保存
			session.setAttribute("updatedPass", newPass);//入力値をセッションに保存
			session.setAttribute("inputId", ID);//入力値をセッションに保存
			session.setAttribute("inputName", newName);//入力値をセッションに保存
			session.setAttribute("inputTel", newTel);//入力値をセッションに保存
			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
		}

	}

}
