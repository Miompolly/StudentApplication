<%@page import="com.StudentApplication.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="style.css">
 <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
   
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>


.hed{
  height: 30px;
  border-bottom: 2px solid black;
  text-align: left;

  display: flex;
}


label{
    color: white;
    font-size: 25px;
    padding-top: 25px;
}
.up{
    height: 15%;
      background-color: #3498db; 
    display:flex;
    justify-content: space-between;
    padding: 0 2rem ;
    
}
.up .rightbar{
 padding:15px;
}


.nav2 {
    width: 100%;
}

a{
text-decoration: none;
font-size: 1.3rem;

}
ul{
list-style: none;}



body {
font-family: Arial, sans-serif;
margin: 0;
padding: 0;
background-color: #f5f5f5;
}

.container {
max-width: 800px;
margin: 50px auto;
padding: 20px;
background-color: #ffffff;
border-radius: 10px;
box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h1 {
text-align: center;
}

.user-table {
width: 100%;
border-collapse: collapse;
margin-top: 20px;
}

.user-table th, .user-table td {
padding: 10px;
text-align: left;
border-bottom: 1px solid #ccc;
}

.user-table th {
background-color: #f2f2f2;
font-weight: bold;
}

.user-table tr:nth-child(even) {
background-color: #f2f2f2;
}

.user-table tr:hover {
background-color: #e0e0e0;
cursor: pointer;
}

.reply-button, .delete-button {
    padding: 5px 10px;
    margin-right: 5px;
    border: none;
    cursor: pointer;
    color: #fff;
    font-size: 14px;
    border-radius: 5px;
}

.reply-button {
    background-color: #3498db;
}

.delete-button {
    background-color: #e74c3c;
}
</style> </head>
<body>

       <div class="nav2">
        <div class="up"> 
        <div class="rightbar"> <label for="">DevLearn</label></div> 
        <div class="rightbar"> <label for=""><a href="index.jsp">Logout</a></label></div> 
        </div>
 <div class="hed">
 <div class="leftBody" style="width: 20%;height: 90vh;background-color: #e6e6e6;">
 
 <ul>
 <li><a href="admin.jsp">Users</a></li>
 <li><a href="applicant.jsp">Applicants</a></li>
 </ul>
 
 </div>
  <div class="rightBody" style="width: 80%;height: 90vh;">
  
  <div class="container">
        <h1>User List</h1>
        <table class="user-table">
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Role</th>
                <th>ACtions</th>
           <%
try {
    ConnectDB db = new ConnectDB();
    db.getCon();
    ResultSet rs = db.getAllUsers();
    while (rs.next()) {
        int Id = rs.getInt("ID");
        String fullname = rs.getString("FullName");
        String email = rs.getString("email");
        String role = rs.getString("role");
%>
        <tr>
            <td><%= Id %></td>
            <td><%= fullname %></td>
            <td><%= email %></td>
            <td><%= role %></td>
            <td>
                <button class="reply-button">Edit</button>
                <button class="delete-button">Delete</button>
            </td>
        </tr>
<% 
    }
   } catch (Exception e) {
    e.printStackTrace();
   }
%>
           
        </table>
    </div>
  
  
  </div>
 </div>




</div>

  


  
</body>
</html>