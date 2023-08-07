package com.StudentApplication;

public class Applicant {

	  String fullName;
      String email;
      String dob ;
      String gender;
      String course ;
      String address ;
	public Applicant() {
		super();
	}
	public Applicant(String fullName, String email, String dob, String gender, String course, String address) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.course = course;
		this.address = address;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
