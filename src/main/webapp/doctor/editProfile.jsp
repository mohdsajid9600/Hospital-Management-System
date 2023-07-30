<%@page import="com.entity.SpecialistEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.daoServlet.SpecialistDao"%>
<%@page import="com.dbConnection.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor-edit profile</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('../img/Hospital-img-2.jpg'); background-size: cover; height: 100vh">
	<%@ include file="navbarDoctor.jsp"%>
	<c:if test="${empty doctorObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<div class="container p-2">
		<c:if test="${not empty successMsg }">
			<p class="text-center text-success fw-blod fs-5">${successMsg}</p>
			<c:remove var="successMsg" scope="session" />
		</c:if>
		<c:if test="${not empty errorMsg }">
			<p class="text-center text-danger fs-5">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<div class="row">
			<div class="col-md-8 offset-md-2 mt-5 pt-5">
				<div class="card paint-card text-light"
					style="background-color: #008B8B;">
					<div class="card-body">
						<p class="text-center fs-5 fw-bold">
							<i class="fa-solid fa-user-plus"></i> Edit Profile
						</p>
						<form action="../editProfile" method="post">
							<div class="col-md-6">
								<input type="hidden" class="form-control" name="id"
									value="${doctorObj.id }" required>
							</div>
							<div class="row">

								<div class="col-md-6">
									<label class="form-label">Full Name :</label> <input
										type="text" id="form2Example17" class="form-control"
										name="doctorname" value="${doctorObj.fullName }" readonly />
								</div>
								<div class="col-md-6">
									<label class="form-label">Date of Birth :</label> <input
										type="date" class="form-control" name="doctordob"
										value="${doctorObj.dob }" required>
								</div>
								<div class="col-md-6">
									<label class="form-label">Qualification details :</label> <input
										type="text" class="form-control" name="doctorquali"
										value="${doctorObj.qualification }" readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Specialist :</label> <select
										name="spec" required class="form-select">
										<option selected>${doctorObj.specialist }</option>
										<%
										SpecialistDao dao = new SpecialistDao(DBConnection.MakeCon());

										List<SpecialistEntity> list = dao.getSpecialist();
										for (SpecialistEntity spec : list) {
										%>

										<option><%=spec.getSpecialist()%></option>
										<%
										}
										%>
									</select>

								</div>
								<div class="col-md-6">
									<label class="form-label">Email Address :</label> <input
										type="email" class="form-control" name="doctoremail"
										value="${doctorObj.email }" readonly>
								</div>
								<div class="col-md-6">
									<label class="form-label">Mobile No :</label> <input
										type="text" class="form-control" name="doctormbno"
										value="${doctorObj.mobileNo }" required>
								</div>
								<div class="col-md-8 offset-md-2 text-center mt-3">
									<button type="submit"
										class="btn active text-dark btn-sm col-md-12"
										style="background-color: #78C7C7;">Update</button>
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