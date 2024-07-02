<%@page import="com.entity.Employee"%>
<%@page import="com.connection.DbConnect"%>
<%@page import="com.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
				<div class="card-body">
					<p class="fs-3 text-center">Edit Employee</p>
					
					<%
						int id = Integer.parseInt(request.getParameter("id"));
						EmployeeDao dao = new EmployeeDao(DbConnect.getConn());
						Employee e = dao.getEmployeeById(id);
					%>
					
					
					
					<form  action="update" method="post">
						<div class="mb-3">
							<label  class="form-label">Full Name
							</label> <input type="text" value=<%=e.getFullname() %> name="name" class="form-control">		
						</div>
						<div class="mb-3">
							<label class="form-label">Date Of Birth
							</label> <input type="date" value=<%=e.getDob() %> name="dob" class="form-control">		
						</div>
						<div class="mb-3">
							<label class="form-label">Address
							</label> <input type="text" value=<%=e.getAddress() %> name="address" class="form-control">		
						</div>
						<div class="mb-3">
							<label  class="form-label">Position
							</label> <input type="text" value=<%=e.getPosition() %> name="position" class="form-control">		
						</div>
						<div class="mb-3">
							<label class="form-label">Email
							</label> <input type="email" value=<%=e.getEmail() %> name="email" class="form-control">		
						</div>
						<input type="hidden" name="id" value=<%=e.getId() %>>
						<button type="submit" class="btn btn-primary col-md-12">Update</button>
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>