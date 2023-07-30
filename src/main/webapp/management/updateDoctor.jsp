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
<title>Edit doctor details</title>
<%@include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-dark">
	<%@include file="management-navbar.jsp"%>
	<c:if test="${empty managementObj}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<div class="container pt-3 mt-5">
		<div class="col-md-12">
			<div class="card paint-card" style="color: #045D5D;">
				<div class="card-body">
					<p class="text-center fs-5 fw-bold">
						<i class="fa-solid fa-user-nurse"></i> Update Doctors Details :-
					</p>
					<c:if test="${not empty successMsg }">
						<p class="text-center fw-blod fs-5" style="color: #045D5D;">${successMsg}</p>
						<c:remove var="successMsg" scope="session" />
					</c:if>
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<%
					int Id = Integer.parseInt(request.getParameter("id"));
					DoctorDao Doctordao = new DoctorDao(DBConnection.MakeCon());
					DoctorEntity Dentity = Doctordao.getDoctorDetailsById(Id);
					%>
					<form action="../updateDoctor" method="post">

						<div class="col-md-6">
							<input type="hidden" class="form-control" name="id"
								value="<%=Dentity.getId()%>" required />
						</div>
						<div class="row">
							<div class="col-md-6">
								<label class="form-label">Full Name :</label> <input type="text"
									id="form2Example17" class="form-control" name="doctorname"
									value="<%=Dentity.getFullName()%>" required />
							</div>
							<div class="col-md-6">
								<label class="form-label">Date of Birth :</label> <input
									type="date" class="form-control" name="doctordob"
									value="<%=Dentity.getDob()%>" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Qualification details :</label> <input
									type="text" class="form-control" name="doctorquali"
									value="<%=Dentity.getQualification()%>" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Specialist :</label> <select
									name="spec" required class="form-select">
									<option selected><%=Dentity.getSpecialist()%></option>
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
									value="<%=Dentity.getEmail()%>" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Mobile No :</label> <input type="text"
									class="form-control" name="doctormbno"
									value="<%=Dentity.getMobileNo()%>" required>
							</div>
							<div class="col-md-12">
								<label for="exampleInputPassword1" class="form-label">Password
									:</label> <input type="password" class="form-control"
									name="doctorpassword" value="<%=Dentity.getPassword()%>"
									id="exampleInputPassword1" required>
							</div>
							<button type="submit" class="btn btn-success btn-sm active mt-5">Update
								Details</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>