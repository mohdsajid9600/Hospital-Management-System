<%@page import="com.entity.AppointEntity"%>
<%@page import="com.daoServlet.AppointmentDao"%>
<%@page import="com.entity.DoctorEntity"%>
<%@page import="java.util.List"%>
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
<title>forward another doctor</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body style="background-color: #00827F;">

	<%@ include file="management-navbar.jsp"%>
	<c:if test="${empty managementObj}">
		<c:redirect url="../management_login.jsp"></c:redirect>
	</c:if>

	<div class="container">
		<div class="row pt-3 mt-3">
			<div
				class="col col-md-6 p-3 bg-image mt-3 text-center paint-card rounded mb-3 text-white"
				style="background-image: url('../img/Female-Doctor-img-1.jpg'); background-repeat: no-repeat; background-size: cover;">
				<h1 class="mt-5 p-5 mb-4 h1"><strong>Handle to ANother Doctor</strong></h1>

				<p class="fs-8"><em>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
					Repellendus praesentium labore accusamus sequi, voluptate debitis
					tenetur in deleniti possimus modi voluptatum neque maiores dolorem
					unde? Aut dolorum quod excepturi fugit.</em></p>
			</div>
			<div class="col col-md-6 p-3">
				<div class="card paint-card" style="color: #045D5D;">
					<div class="card-body">
						<p class="text-center fs-5 fw-bold" style="color: #045D5D;">
							<!-- <i class="fa-solid fa-calendar-check"></i> -->
							User Appointment Booking Handle to another Doctor
						</p>
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fw-blod fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AppointmentDao dao = new AppointmentDao(DBConnection.MakeCon());
						DoctorDao doctor = new DoctorDao(DBConnection.MakeCon());
						AppointEntity ap = dao.getAppointDetailsById(id);
						DoctorEntity doct = doctor.getDoctorDetailsById(ap.getDoctorId());
						%>
						<form action="../updateDoctorInAppoint" method="post">
							<div class="row">
								<input type=hidden name="id" value="<%=ap.getId()%>">
								<div class="col-md-6">
									<label class="form-label">Full Name :</label> <input
										type="text" id="form2Example17" class="form-control"
										name="fullname" placeholder="your name"
										value="<%=ap.getFullName()%>" readonly />
								</div>
								<div class="col-md-6">
									<label class="form-label">Gender :</label> <select
										class="form-control" name="gender" value="<%=ap.getGender()%>"
										readonly>
										<option>Male</option>
										<option>Female</option>

									</select>
								</div>
								<div class="col-md-6">
									<label class="form-label">Age :</label> <input type="number"
										maxlength="2" class="form-control" name="age"
										value="<%=ap.getAge()%>" placeholder="in years" readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Appointment Date :</label> <input
										type="date" class="form-control" name="apointDate"
										value="<%=ap.getAppointDate()%>" readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Email Address :</label> <input
										type="email" class="form-control" name="email"
										value="<%=ap.getEmail()%>" placeholder="email id" readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Phone Number :</label> <input
										type="number" maxlength="10" class="form-control"
										placeholder="0123456789" name="phno"
										value="<%=ap.getPhoneNo()%>" readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Diseases :</label> <input type="text"
										class="form-control" name="diseases"
										value="<%=ap.getDiseases()%>" placeholder="diseases name"
										readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Doctor :</label> <select
										class="form-control" name="doctorId" required>
										<option value=""><%=doct.getFullName()%>(<%=doct.getSpecialist()%>)
										</option>

										<%
										List<DoctorEntity> list = doctor.getDoctorsDetails();
										for (DoctorEntity Dentity : list) {
										%>
										<option value="<%=Dentity.getId()%>"><%=Dentity.getFullName()%>(<%=Dentity.getSpecialist()%>)
										</option>
										<%
										}
										%>


									</select>
								</div>
								<div class="col-md-12 text-center mt-3">
									<button type="submit"
										class="btn btn-success btn-block btn-sm col-md-12">Forward</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>