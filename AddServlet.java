package com.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnect;
import com.dao.EmployeeDao;
import com.entity.Employee;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String position = req.getParameter("position");
		String email = req.getParameter("email");
		
		Employee employee = new Employee(name,dob,address,position,email);
		
		EmployeeDao dao = new EmployeeDao(DbConnect.getConn());
		
		HttpSession session = req.getSession();
		
		boolean f =dao.addEmployee(employee);
		if(f)
		{	
			session.setAttribute("sucsMsg", "Employee details add sucessfully");
			resp.sendRedirect("index.jsp");
			//System.out.println("Employee Details Add Succesfully");
		}
		else {
			session.setAttribute("errorMsg", "Employee details are not added");
			resp.sendRedirect("index.jsp");
			//System.out.println("Something went wrong");
		}
		
		
	}
}
