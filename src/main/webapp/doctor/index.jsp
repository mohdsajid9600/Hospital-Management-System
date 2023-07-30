<%@page import="com.entity.DoctorEntity"%>
<%@page import="com.daoServlet.AppointmentDao"%>
<%@page import="com.dbConnection.DBConnection"%>
<%@page import="com.daoServlet.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Dashboard</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('../img/Hospital-img-2.jpg'); background-size: cover; height: 100vh">

	<c:if test="${empty doctorObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@ include file="navbarDoctor.jsp"%>
	<div class="container-fluid  paint-card">
		<p class="text-center fs-1 p-3 mt-3"
			style="color: #045D5D; font-weight: bolder;">
			<i class="fa-solid fa-user-nurse"></i> Doctor Dashboard
		</p>
		<c:if test="${not empty successMsg }">
			<p class="text-center fw-bold fs-5" style="color: #045D5D; background-color: white;">${successMsg}</p>
			<c:remove var="successMsg" scope="session" />
		</c:if>
		<c:if test="${not empty errorMsg }">
			<p class="text-center fw-bold fs-5" style="color: red;background-color: white;">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
	</div>
	<div class="container p-5 text-center">
		<div class="row offset-md-0">
			<%
			DoctorDao doctor = new DoctorDao(DBConnection.MakeCon());
			%>
			<div class="col col-md-6 mt-5">
				<div class="card paint-card">
					<div class="card-body text-center" style="color: #045D5D;">
						<a href="#" class="fs-5 text-center fw-bold"
							style="text-decoration: none; color: #045D5D;"> <i
							class="fa-solid fa-user-nurse fa-2x"></i><br> Doctor <br>(<%=doctor.countDoctors()%>)
						</a>

					</div>
				</div>
			</div>
			<%
			AppointmentDao apoint = new AppointmentDao(DBConnection.MakeCon());
			DoctorEntity doct = (DoctorEntity) session.getAttribute("doctorObj");
			%>
			<div class="col col-md-6 mt-5">
				<div class="card paint-card">
					<div class="card-body text-center" style="color: #045D5D;">
						<a href="patient.jsp" class="fs-5 text-center fw-bold"
							style="text-decoration: none; color: #045D5D;"> <i
							class="fa-solid fa-calendar-check fa-2x"></i><br> Total
							Appointment <br>(<%=apoint.countAppointmentsByDoctorId(doct.getId())%>)
						</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>