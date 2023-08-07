package com.StudentApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ApplicantServlet
 */
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantServlet() {
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
		 String fullName = request.getParameter("fullName");
	        String email = request.getParameter("email");
	        String dob = request.getParameter("dob");
	        String gender = request.getParameter("gender");
	        String course = request.getParameter("course");
	        String address = request.getParameter("address");
	        
	        Applicant applicants=new Applicant(fullName,email,dob,gender,course,address);
	        ConnectDB db=new ConnectDB();
	        String rs=db.addApplicant(applicants);
	        if(rs!=null) {
	        	response.sendRedirect("signup.jsp");
	        }else {
	        	response.sendRedirect("apply.jsp");
	        }
	}

	
	
}
