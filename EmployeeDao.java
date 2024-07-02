package com.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Employee;
import com.mysql.cj.protocol.Resultset;

public class EmployeeDao {

	private Connection con;

	public EmployeeDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addEmployee(Employee employee) {
		boolean f = false;
		try {
			String sql = "insert into employee(name,dob,address,position,email) values(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getFullname());
			ps.setString(2, employee.getDob());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getPosition());
			ps.setString(5, employee.getEmail());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// show student list

	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		Employee e = null;
		try {

			String sql = "select * from employee";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt(1));
				e.setFullname(rs.getString(2));
				e.setDob(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setPosition(rs.getString(5));
				e.setEmail(rs.getString(6));
				list.add(e);
			}
		} catch (Exception l) {
			l.printStackTrace();
		}

		return list;
	}

	public Employee getEmployeeById(int id) {
		Employee e = null;
		try {

			String sql = "select * from employee where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt(1));
				e.setFullname(rs.getString(2));
				e.setDob(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setPosition(rs.getString(5));
				e.setEmail(rs.getString(6));
			}
		} catch (Exception l) {
			l.printStackTrace();
		}
		return e;

	}
	
	//update Employee
	public boolean UpdateEmployee(Employee employee) {
		boolean f = false;
		try {
			String sql = "update employee set name=?,dob=?,address=?,position=?,email=? where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getFullname());
			ps.setString(2, employee.getDob());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getPosition());
			ps.setString(5, employee.getEmail());
			ps.setInt(6, employee.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteEmployee(int id)
	{
		boolean f = false;
		
		try {
			String sql="delete from employee where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
			
		}catch (Exception l) {
			l.printStackTrace();
		}
		
		return f;
	}
	
	
}
