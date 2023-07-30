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
<title>User-appointment details</title>
<%@ include file="component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('img/loby-hospital.jpg'); background-size: cover; height: 100vh">
	<c:if test="${empty userObj}">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<%@ include file="component/navbar_file.jsp"%>

	<div class="container mt-5 pt-5 ">

		<div class="card paint-card text-light"
					style="background-color: #00827F;">
			<div class="card-body">
				<p class="text-center fs-3 fw-bold">
					<i class="fa-solid fa-receipt"></i> <ins> Your Appointment Details :-</ins>
				</p>
				<c:if test="${not empty successMsg }">
							<p class="text-center text-light fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>
				<table class="table table-hover text-center text-light">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment Date</th>
							<th scope="col">Email Address</th>
							<th scope="col">Phone No.</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>

						</tr>
					</thead>
					<tbody>
						<!-- 	<th scope="row">1</th> -->
						<%
						UserEntity user = (UserEntity) session.getAttribute("userObj");
						AppointmentDao Ddao = new AppointmentDao(DBConnection.MakeCon());
						List<AppointEntity> list1 = Ddao.getUserAppointDetailsByUserId(user.getId());
						DoctorDao Doctor = new DoctorDao(DBConnection.MakeCon());

						for (AppointEntity Aentity : list1) {

							DoctorEntity doctor = Doctor.getDoctorDetailsById(Aentity.getDoctorId());
						%>
						<tr>

							<td scope="row" class="fw-bold"><%=Aentity.getFullName()%></td>
							<td><%=Aentity.getGender()%></td>
							<td><%=Aentity.getAge()%></td>
							<td><%=Aentity.getAppointDate()%></td>
							<td><%=Aentity.getEmail()%></td>
							<td><%=Aentity.getPhoneNo()%></td>
							<td><%=Aentity.getDiseases()%></td>
							<td><%=doctor.getFullName()%></td>
							<td><%=Aentity.getAddress()%></td>

							<%
							if ("Pending".equals(Aentity.getStatus())) {
							%>
							<td><Button
									class="btn btn-block btn-md btn-warning disabled">Pending</Button></td>
							<%
							} else {
							%>

							<td><Button
									class="btn btn-block btn-sm btn-light disabled"><%=Aentity.getStatus()%></Button></td>

							<%
							}
							%>
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