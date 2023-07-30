<%@page import="java.util.ArrayList"%>
<%@page import="com.daoServlet.UserDao"%>
<%@page import="com.entity.UserEntity"%>
<%@page import="com.entity.DoctorEntity"%>
<%@page import="com.daoServlet.DoctorDao"%>
<%@page import="com.entity.AppointEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.dbConnection.DBConnection"%>
<%@page import="com.daoServlet.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users details</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('../img/loby-hospital.jpg'); background-size: cover; height: 100vh">

	<%@ include file="management-navbar.jsp"%>
	<c:if test="${empty managementObj}">
		<c:redirect url="../management_login.jsp"></c:redirect>
	</c:if>
	<div class="container mt-5 pt-5">
		<div class="card paint-card">
			<div class="card-body">
				<p class="text-center fs-5 fw-bold pb-3 mb-3"
					style="color: #045D5D;">
					<i class="fa-solid fa-person-half-dress"></i> Users Details :-
				</p>
				<c:if test="${not empty successMsg }">
					<p class="text-center text-success fw-blod fs-5">${successMsg}</p>
					<c:remove var="successMsg" scope="session" />
				</c:if>
				<c:if test="${not empty errorMsg }">
					<p class="text-center text-danger fs-5">${errorMsg}</p>
					<c:remove var="errorMsg" scope="session" />
				</c:if>

				<table class="table table-hover text-center">
					<thead style="color: #045D5D;">
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">DOB</th>
							<th scope="col">Address</th>
							<th scope="col">Email Address</th>
							<th scope="col">Delete</th>

						</tr>
					</thead>
					<tbody>
						<!-- 	<th scope="row">1</th> -->
						<%
						UserDao uDao = new UserDao(DBConnection.MakeCon());
						List<UserEntity> list = new ArrayList<UserEntity>();
						list = uDao.getAllUsersDetails();

						for (UserEntity ue : list) {
						%>
						<tr>
							<td scope="row" class="fw-bold" style="color: #045D5D;"><%=ue.getFullname()%></td>
							<td scope="row"><%=ue.getDob()%></td>
							<td scope="row"><%=ue.getAddress()%></td>
							<td scope="row"><%=ue.getEmail()%></td>
							<td scope="row"><a href="../deleteUserDetails?id=<%=ue.getId() %>" role="button"
								class="btn btn-danger active btn-block">Delete</a></td>
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