package com.StudentApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Servlet implementation class addUser2Servlet
 */

@WebServlet("/addUser2Servlet")
public class addUser2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser2Servlet() {
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
	     String email = request.getParameter("email");
	        String fullname = request.getParameter("fullname");
	        String password = request.getParameter("password");
	        String role = request.getParameter("role");
	        addUser user1 = new addUser(fullname, email, password,role);

	        ConnectDB db = new ConnectDB();
	        db.getCon();
	        String message = db.addUser2(user1);
if(message!=null) {
	response.sendRedirect("admin.jsp");
}else {
	JOptionPane.showMessageDialog(null,"Failed to add user" );
	response.sendRedirect("addUser.jsp");
}
	}

	}


