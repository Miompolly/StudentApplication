package com.StudentApplication;

public class addUser {
	String fullname,email,password,role;

	public addUser() {
		super();
	}

	public addUser(String fullname, String email, String password, String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
