<%@page import="javax.swing.JOptionPane"%>
<%@ page import="com.StudentApplication.ConnectDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
try {
    int IdToDelete = Integer.parseInt(request.getParameter("Id"));
    ConnectDB db = new ConnectDB();
    db.getCon();
    boolean deleted = db.deleteUser(IdToDelete);
    
    if (deleted) {
        response.sendRedirect("admin.jsp"); 
    } else {
        out.println("Deletion failed. Please try again.");
    }
} catch (Exception e) {
    e.printStackTrace();
    System.out.println("Failed "+e.getMessage());
}
%>
