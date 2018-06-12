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
import service.UserInfoService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		if(id == null || "".equals(id)) {//idが未入力の場合
			request.setAttribute("msg", "必須項目を入力してください");
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else {//idに入力値あり。IDに合致するレコードを取得し、セッションに保存
			Integer iId = Integer.parseInt(id);
			UserInfoService userInfoService = new UserInfoService();
			List<UserInfo>list = userInfoService.findById(iId);
			if(list != null) {
			    HttpSession session = request.getSession();
			    //useridデータで取得したテーブルをsessionスコープで保存
			    session.setAttribute("updateUser", list);


			}
			else {
				request.setAttribute("msg", "入力されたデータはありませんでした");
				request.getRequestDispatcher("update.jsp").forward(request, response);
				return;
			}
			// 次画面指定
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
			return;
		}

	}

}
