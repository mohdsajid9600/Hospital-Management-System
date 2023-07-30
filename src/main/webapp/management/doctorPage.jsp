<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.DoctorEntity"%>
<%@page import="com.daoServlet.DoctorDao"%>
<%@page import="com.entity.SpecialistEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.dbConnection.DBConnection"%>
<%@page import="com.daoServlet.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor details</title>
<%@include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('../img/loby-hospital.jpg'); background-size: cover; height: 100vh">
	<%@include file="management-navbar.jsp"%>
	<c:if test="${empty managementObj}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<div class="container mt-5 pt-3">

		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-5 fw-bold text-center" style="color: #045D5D;">
							<i class="fa-solid fa-user-nurse"></i> Doctor Details :-
						</p>
						<c:if test="${not empty successMsg }">
							<p class="text-center fw-blod fs-5" style="color: #045D5D;">${successMsg}</p>
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
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email Address</th>
									<th scope="col">Mob No.</th>
									<!-- <th scope="col">Password</th> -->
									<th scope="col">Action</th>

								</tr>
							</thead>
							<tbody>
								<!-- 	<th scope="row">1</th> -->
								<%
								DoctorDao Ddao = new DoctorDao(DBConnection.MakeCon());
								List<DoctorEntity> list1 = Ddao.getDoctorsDetails();

								for (DoctorEntity Dentity : list1) {
								%>
								<tr>
									<td scope="row" class="fw-bold" style="color: #045D5D;"><%=Dentity.getFullName()%></td>
									<td><%=Dentity.getDob()%></td>
									<td><%=Dentity.getQualification()%></td>
									<td><%=Dentity.getSpecialist()%></td>
									<td><%=Dentity.getEmail()%></td>
									<td><%=Dentity.getMobileNo()%></td>
									<%-- <td><%=Dentity.getPassword() %></td> --%>
									<td><a href="updateDoctor.jsp?id=<%=Dentity.getId()%>"
										class="btn btn-block btn-sm btn-info active">Update</a> <a
										href="../deleteDoctor?id=<%=Dentity.getId()%>"
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
		</div>
	</div>
</body>
</html>