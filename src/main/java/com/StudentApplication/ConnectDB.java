package com.StudentApplication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectDB {

	String dburl="jdbc:mysql://localhost:3307/ApplicationDB";
	String dbuser="root";
	String dbpwd="";
	String dbdriver="com.mysql.cj.jdbc.Driver";
	Connection con=null;
	
	public void loadDriver() {
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
		try {
			con=DriverManager.getConnection(dburl,dbuser,dbpwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		System.out.println("DB not connected"+e.getMessage());
		}
		return con;
		
	}
	public String addApplicant(Applicant applicant) {
	    String message = "Applicant Registered Successfully";

	    loadDriver();
	    Connection cnx = getCon();

	    String sql = "INSERT INTO applicants (full_name, email, dob, gender, course, address) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setString(1, applicant.getFullName());
	        stm.setString(2, applicant.getEmail());
	        stm.setString(3, applicant.getDob());
	        stm.setString(4, applicant.getGender());
	        stm.setString(5, applicant.getCourse());
	        stm.setString(6, applicant.getAddress());

	        int rs = stm.executeUpdate();

	        if (rs > 0) {
	            JOptionPane.showMessageDialog(null, "Applicant Registered Successfully,Go to signup");
	        } else {
	            JOptionPane.showMessageDialog(null, "Applicant Registration Failed");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Applicant Registration Failed, " + e.getMessage());
	    } 
	    return message;
	}
	
	
	public boolean isEmailRegistered(String email) {
	    loadDriver();
	    Connection cnx = getCon();
	    
	    String sql = "SELECT COUNT(*) FROM users WHERE email=?";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setString(1, email);
	        ResultSet result = stm.executeQuery();
	        result.next();
	        int count = result.getInt(1);
	        return count > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public String addUser(User user1) {
	    String message = "Created Successfully";

	    loadDriver();
	    Connection cnx = getCon();

	    if (isEmailRegistered(user1.getEmail())) {
	    	 message="User Already Exist";
	    } else {
	    	  String sql = "INSERT INTO users (FullName, email, password) VALUES (?, ?, ?)";
		        try {
		            PreparedStatement stm = cnx.prepareStatement(sql);
		            stm.setString(1, user1.getFullname());
		            stm.setString(2, user1.getEmail());

		            String hashedPassword = hashMD5(user1.getPassword()); 
		            stm.setString(3, hashedPassword); 

		            
		            int rs = stm.executeUpdate();

		            if (rs > 0) {
		                message = "User Created Successfully";
		            } else {
		                message = "User not Created !!! Try again";
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            message = "User not created, " + e.getMessage();
		        }
	    }
	    return message;
	}

	public ResultSet getUser(Login loguser1) {
	    ResultSet row = null;
	    loadDriver();
	    Connection cnx = getCon();
	    String sql = "SELECT * FROM users WHERE email=? AND password=?";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setString(1, loguser1.getEmail());
	        String hashedPassword = hashMD5(loguser1.getPassword()); 
	        stm.setString(2, hashedPassword); 
	        row = stm.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return row;
	}


	private String hashMD5(String input) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(input.getBytes());
	        StringBuilder hexString = new StringBuilder();

	        for (byte b : messageDigest) {
	            hexString.append(String.format("%02x", b));
	        }

	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException(e);
	    }
	}

	public ResultSet getAllUsers(){
		ResultSet row=null;
	
	    loadDriver();
	    Connection cnx = getCon();
	    String sql = "SELECT * FROM users";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql); 
	        row = stm.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return row;
	}

	public ResultSet getAllApplicants(){
		ResultSet row=null;
	
	    loadDriver();
	    Connection cnx = getCon();
	    String sql = "SELECT * FROM applicants";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql); 
	        row = stm.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return row;
	}

	public String updateApplicant(int ID,String review) {
		String mssg="Success";
		   loadDriver();
		 Connection cnx =getCon();
		 String sql="UPDATE applicants SET Review=? WHERE ID=?";
		 try {
			PreparedStatement stmt = cnx.prepareStatement(sql);
			stmt.setInt(2, ID);
			stmt.setString(1, review);
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mssg;
		
	}
	

	
	public boolean deleteApplicant(int Id) {
	    loadDriver();
	    Connection cnx = getCon();
	    
	    String sql = "DELETE FROM applicants WHERE ID=?";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setLong(1, Id);
	        int rowsAffected = stm.executeUpdate();
	        if (rowsAffected > 0) {
	            return true; 
	        }
	    } catch (SQLException e) {
	        System.out.println("Failed to delete " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return false; 
	}

	public String updateUser(String fullname,String email,String role,int ID) {
		String mssg="Success";
		   loadDriver();
		 Connection cnx =getCon();
		 String sql="UPDATE users SET FullName=?,email=?,role=? WHERE ID=?";
		 try {
			PreparedStatement stmt = cnx.prepareStatement(sql);
			stmt.setString(1, fullname);
			stmt.setString(2, email);
			stmt.setString(3, role);
			stmt.setInt(4, ID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mssg;
		
	}
	
	public String addUser2(addUser user1) {
	    String message = "Created Successfully";

	    loadDriver();
	    Connection cnx = getCon();

	    if (isEmailRegistered(user1.getEmail())) {
	    	 message="User Already Exist";
	    } else {
	    	  String sql = "INSERT INTO users (FullName, email, password,role) VALUES (?, ?, ?,?)";
		        try {
		            PreparedStatement stm = cnx.prepareStatement(sql);
		            stm.setString(1, user1.getFullname());
		            stm.setString(2, user1.getEmail());

		            String hashedPassword = hashMD5(user1.getPassword()); 
		            stm.setString(3, hashedPassword); 
		            stm.setString(4, user1.getRole());
		            
		            int rs = stm.executeUpdate();

		            if (rs > 0) {
		                message = "User Created Successfully";
		            } else {
		                message = "User not Created !!! Try again";
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            message = "User not created, " + e.getMessage();
		        }
	    }
	    return message;
	}
	public boolean deleteUser(int Id) {
	    loadDriver();
	    Connection cnx = getCon();
	    
	    String sql = "DELETE FROM users WHERE ID=?";
	    try {
	        PreparedStatement stm = cnx.prepareStatement(sql);
	        stm.setLong(1, Id);
	        int rowsAffected = stm.executeUpdate();
	        if (rowsAffected > 0) {
	            return true; 
	        }
	    } catch (SQLException e) {
	        System.out.println("Failed to delete " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return false; 
	}

	
}