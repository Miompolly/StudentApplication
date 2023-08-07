package com.StudentApplication;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateApplicant
 */
@WebServlet("/UpdateApplicant")
public class UpdateApplicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateApplicant() {
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

		 int Id = 0;
		    String IdStr = request.getParameter("Id");
		    if (IdStr != null && !IdStr.isEmpty()) {
		        try {
		        	Id = Integer.parseInt(IdStr);
		        } catch (NumberFormatException e) {
		          
		            e.printStackTrace(); 
		        }
		    }
		    
		    String review=request.getParameter("review");
		    ConnectDB db=new ConnectDB();
		    db.getCon();
		    String rs=db.updateApplicant(Id, review);
		    if(rs!=null) {
		    	response.sendRedirect("applicant.jsp");
		    }else {
		    	response.sendRedirect("editApplicant.jsp");
		    }
			
		
	}

}
