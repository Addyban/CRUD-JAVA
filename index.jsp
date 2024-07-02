<%@page import="com.entity.Employee"%>
<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.connection.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: cyan">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="card w-125">
			<div class="card-body text-dark">
				<p class="text-center fs-2">All Employee Status</p>
					
					<a:if test="${not empty sucsMsg }">
							<p class="text-center text-success">${ sucsMsg }</p>
							<a:remove var="sucsMsg" />
						</a:if>

						<a:if test="${not empty errorMsg }">
							<p class="text-center text-danger">${ errorMsg }</p>
							<a:remove var="errorMsg" />
						</a:if>
					
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Date of Birth</th>
							<th scope="col">Address</th>
							<th scope="col">Position</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					
					<%
						EmployeeDao dao = new EmployeeDao(DbConnect.getConn());
						List<Employee> list = dao.getAllEmployee();
						for(Employee e : list){
					%>
						<tr>
							<th scope="row"><%=e.getFullname()%></th>
							<td><%=e.getDob() %></td>
							<td><%=e.getAddress() %></td>
							<td><%=e.getPosition() %></td>
							<td><%=e.getEmail()%></td>
							<td><a href="edit_employee.jsp?id=<%=e.getId() %>"
								class="btn btn-sm btn-primary">Edit</a> 
								
								<a href="delete?id=<%=e.getId() %>"
								class="btn btn-sm btn-danger ms-1">Delete</a></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>




</body>
</html>