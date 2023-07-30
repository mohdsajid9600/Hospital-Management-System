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
<title>Add doctors</title>
<%@include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-dark">
	<%@include file="management-navbar.jsp"%>
	<c:if test="${empty managementObj}">
		<c:redirect url="../management_login.jsp"></c:redirect>
	</c:if>
	<div class="container p-2">
	<div class="col-md-12 mt-5 m-auto">
			<div class="card paint-card" style="color: #045D5D;">
				<div class="card-body">
					<p class="text-center fs-5 fw-bold">
						<i class="fa-solid fa-user-plus"></i> Add Doctors :-
					</p>

					<c:if test="${not empty successMsg }">
						<p class="text-center text-success fw-blod fs-5">${successMsg}</p>
						<c:remove var="successMsg" scope="session" />
					</c:if>
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<form action="../addDoctor" method="post">
						<div class="row">
							<div class="col-md-6">
								<label class="form-label">Full Name :</label> <input type="text"
									class="form-control" name="doctorname" required />
							</div>
							<div class="col-md-6">
								<label class="form-label">Date of Birth :</label> <input
									type="date" class="form-control" name="doctordob" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Qualification details :</label> <input
									type="text" class="form-control" name="doctorquali" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Specialist :</label> <select
									name="spec" required class="form-select">
									<option selected>--Open this select menu--</option>
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
									type="email" class="form-control" name="doctoremail" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Mobile No :</label> <input type="text"
									class="form-control" name="doctormbno" required>
							</div>
							<div class="col-md-12">
								<label for="exampleInputPassword1" class="form-label">Password
									:</label> <input type="password" class="form-control"
									name="doctorpassword" id="exampleInputPassword1" required>
							</div>

							<button type="submit" class="btn btn-success active btn-sm mt-3">Add
								Doctor</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>