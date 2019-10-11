package Controller;

import java.io.EOFException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.User;
import DAO.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String name, pass;
		name=request.getParameter("name");
		pass= request.getParameter("pass");
		request.setAttribute("name",name);
		boolean kt= LoginDAO.Validate(name, pass);
		
		if(kt==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("session",name);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/view/Home.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("name","Ten dang nhap or tai khoan chua dung");
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
		}
	}

}
