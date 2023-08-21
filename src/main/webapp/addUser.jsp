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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>


.hed{
  height: 30px;
  border-bottom: 2px solid black;
  text-align: left;

  display: flex;
}


nav label{
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
input{
padding: 1rem;}
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
       <div class="signup-form">
    <h2>Add User</h2>
    <form action="addUser2Servlet" method="post">
      <div class="form-group">
        <label for="fullname">Full Name:</label>
        <input type="text" name="fullname" id="fullname" class="form-control" placeholder="Enter User full name" required>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" class="form-control" placeholder="Enter User email" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Enter User password" required>
      </div>
        <div class="form-group">
        <label for="password">Role:</label>
        <input type="text" name="role" id="role" class="form-control" placeholder="Enter User Role" required>
      </div>
   
      <button type="submit" class="btn btn-primary">Add </button>

    </form>
    </div>
      
      
    </div>
  
  
  </div>
 </div>




</div>

  

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>

  
</body>
</html>