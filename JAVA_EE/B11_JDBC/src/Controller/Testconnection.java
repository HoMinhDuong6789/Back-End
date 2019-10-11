package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Users;
import DAO.UsersDAO;
import DB.DBConnection;

/**
 * Servlet implementation class Testconnection
 */
@WebServlet("/Testconnection")
public class Testconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testconnection() {
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
		
		//insert Data
		/*
		try {
			Connection conn= DBConnection.CreateConnection();
			PrintWriter out= response.getWriter();
			int id= Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			int win= Integer.parseInt(request.getParameter("win"));
			int lose= Integer.parseInt(request.getParameter("lose"));
			int score= Integer.parseInt(request.getParameter("score"));
			Users user= new Users(id, name, password, win, lose, score);
			boolean so=UsersDAO.InsertUsers(conn, user);
			
			if(conn!=null && so ==true) {
				
				out.println("<h1>Success <h1>");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//Select
		
		try {
			Connection conn = DBConnection.CreateConnection();
			PrintWriter out= response.getWriter();
			List<Users> list= UsersDAO.selection(conn);
			if(list.size()!=0) {
				request.setAttribute("list",list);
				RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/view/SelectPage.jsp");
				rd.forward(request, response);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
