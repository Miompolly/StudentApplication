package com.StudentApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String form_email=request.getParameter("email");
		String form_password=request.getParameter("password");
		Login loguser1=new Login(form_email,form_password);
		ConnectDB db=new ConnectDB();
		db.getCon();
	
		
		
	ResultSet result=db.getUser(loguser1);

		if(result!=null) {
			try {
				if(result.next()) {
			String	userRole=result.getString("Role");			
				if(userRole.equals("admin")) {
					response.sendRedirect("admin.jsp");
				}else {
					response.sendRedirect("userDashboard.jsp");
				}
				}
			} catch (SQLException e) {
				response.sendRedirect("index.jsp");
				e.printStackTrace();
			}
			}
		
		
	}

}
