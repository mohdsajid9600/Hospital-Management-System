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
<title>Patient appointments</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('../img/hospital-building-img.jpg'); background-size: cover; height: 100vh">
	<%@ include file="navbarDoctor.jsp"%>
	<c:if test="${empty doctorObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<div class="container mt-5 pt-5 offset-md-1">

		<div class="card paint-card" >
			<div class="card-body">
				<p class="text-center fs-5 fw-bold" style="color: #045D5D;">
					<i class="fa-solid fa-person-half-dress"></i> Patients Appointment
					Details :-
				</p>
				<c:if test="${not empty successMsg }">
					<p class="text-center text-success fw-blod fs-5">${successMsg}</p>
					<c:remove var="successMsg" scope="session" />
				</c:if>
				<c:if test="${not empty errorMsg }">
					<p class="text-center text-danger fw-blod fs-5">${errorMsg}</p>
					<c:remove var="errorMsg" scope="session" />
				</c:if>

				<table class="table table-hover text-center">
					<thead style="color: #045D5D;">
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment Date</th>
							<th scope="col">Email Address</th>
							<th scope="col">Phone No.</th>
							<th scope="col">Diseases</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
							<th scope="col">Response</th>

						</tr>
					</thead>
					<tbody>
						<!-- 	<th scope="row">1</th> -->
						<%
						DoctorEntity doctor = (DoctorEntity) session.getAttribute("doctorObj");
						AppointmentDao Ddao = new AppointmentDao(DBConnection.MakeCon());
						List<AppointEntity> list1 = Ddao.getUserAppointDetailsByDoctorId(doctor.getId());

						UserDao userd = new UserDao(DBConnection.MakeCon());

						for (AppointEntity Aentity : list1) {
							/* UserEntity userE = userd.getUserDetailsById(Aentity.getUserId()); */
						%>
						<tr>

							<td scope="row" class="fw-bold" style="color: #045D5D;"><%=Aentity.getFullName()%></td>
							<td><%=Aentity.getGender()%></td>
							<td><%=Aentity.getAge()%></td>
							<td><%=Aentity.getAppointDate()%></td>
							<td><%=Aentity.getEmail()%></td>
							<td><%=Aentity.getPhoneNo()%></td>
							<td><%=Aentity.getDiseases()%></td>
							<td><%=Aentity.getAddress()%></td>

							<%
							if ("Pending".equals(Aentity.getStatus())) {
							%>
							<td>
								<Button class="btn btn-block btn-sm btn-warning active">Pending</Button>
							</td>
							<td><a href="commentPage.jsp?id=<%=Aentity.getId()%>"
								class="btn btn-block btn-sm btn-success ">Comment</a></td>

							<%
							} else {
							%>

							<td>
								<p class="text-success"><%=Aentity.getStatus()%></p>
							</td>
							<td><a href=""
								class="btn btn-block btn-sm btn-success disabled" >Accepted</a></td>

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