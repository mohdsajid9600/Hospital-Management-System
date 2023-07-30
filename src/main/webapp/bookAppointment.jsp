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
<title>User-appointment booking</title>
<%@ include file="component/all_css_files.jsp"%>
</head>
<body style="background-color: #00827F">

	<%@include file="component/navbar_file.jsp"%>
	<c:if test="${empty userObj}">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row">
			<!-- <div class=" "> -->
			<!-- Jumbotron -->
			<div
				class="col col-md-6 p-3 bg-image mt-3 text-center shadow-1-strong rounded mb-3 f-color"
				style="background-image: url('img/appointment-img-5.jpg'); background-repeat: no-repeat; background-size: cover;">
				<h1 class="mt-5 p-5 mb-4 h1"><strong>Make Appointment</strong></h1>

				<p class="fs-5"><em>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
					Repellendus praesentium labore accusamus sequi, voluptate debitis
					tenetur in deleniti possimus modi voluptatum neque maiores dolorem
					unde? Aut dolorum quod excepturi fugit.</em></p>
			</div>
			<div class="col col-md-6 p-3">
				<div class="card paint-card text-light"
					style="background-color: #00827F;">
					<div class="card-body">
						<p class="text-center fs-5 fw-bold">
							<i class="fa-solid fa-calendar-check"></i> User Appointment
							Booking :-
						</p>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-light fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<form action="bookAppointment" method="post">
							<div class="row">
								<input type=hidden name="userid" value="${userObj.id }">
								<div class="col-md-6">
									<label class="form-label">Full Name :</label> <input
										type="text" id="form2Example17" class="form-control"
										name="fullname" placeholder="your name" required />
								</div>
								<div class="col-md-6">
									<label class="form-label">Gender :</label> <select
										class="form-control" name="gender" required>
										<option>Male</option>
										<option>Female</option>

									</select>
								</div>
								<div class="col-md-6">
									<label class="form-label">Age :</label> <input type="number"
										maxlength="2" class="form-control" name="age"
										placeholder="in years" required>
								</div>
								<div class="col-md-6">
									<label class="form-label">Appointment Date :</label> <input
										type="date" class="form-control" name="apointDate" required>
								</div>
								<div class="col-md-6">
									<label class="form-label">Email Address :</label> <input
										type="email" class="form-control" name="email"
										placeholder="email id" required>
								</div>
								<div class="col-md-6">
									<label class="form-label">Phone Number :</label> <input
										type="number" maxlength="10" class="form-control"
										placeholder="0123456789" name="phno" required>
								</div>
								<div class="col-md-6">
									<label class="form-label">Diseases :</label> <input type="text"
										class="form-control" name="diseases"
										placeholder="diseases name" required>
								</div>
								<div class="col-md-6">
									<label class="form-label">Doctor :</label> <select
										class="form-control" name="doctname" required>
										<option class="text-center" value="">--Select
											Doctor--</option>

										<%
										DoctorDao dao = new DoctorDao(DBConnection.MakeCon());
										List<DoctorEntity> list = dao.getDoctorsDetails();
										for (DoctorEntity Dentity : list) {
										%>
										<option value="<%=Dentity.getId()%>"><%=Dentity.getFullName()%>(<%=Dentity.getSpecialist()%>)
										</option>
										<%
										}
										%>


									</select>
								</div>
								<div class="col-md-12">
									<label class="form-label">Address :</label>
									<textarea rows="3" col="" class="form-control" name="address"
										required></textarea>
								</div>
								<c:if test="${not empty userObj}">
									<div class="col-md-12 text-center mt-3">
										<button type="submit"
											class="btn  btn-block btn-sm col-md-12" style="background-color: #78C7C7;">Make Appointment</button>
									</div>
								</c:if>
								<c:if test="${empty userObj}">
									<div class="mb-3 text-center mt-3" style="color: white;">
										<a href="user_login.jsp"
											class="btn btn-success btn-block btn-sm col-md-12"
											role="button"> Make Appointment</a>
									</div>
								</c:if>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>