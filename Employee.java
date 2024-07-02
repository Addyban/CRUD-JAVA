package com.entity;

public class Employee {
	
	private int id;
	private String fullname;
	private String dob;
	private String address;
	private String position;
	private String email;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String fullname, String dob, String address, String position, String email) {
		super();
		this.fullname = fullname;
		this.dob = dob;
		this.address = address;
		this.position = position;
		this.email = email;
	}
	public Employee(int id, String fullname, String dob, String address, String position, String email) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.dob = dob;
		this.address = address;
		this.position = position;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", dob=" + dob + ", address=" + address + ", position="
				+ position + ", email=" + email + "]";
	}
	
	
}
