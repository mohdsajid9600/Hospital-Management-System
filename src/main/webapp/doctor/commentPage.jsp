<%@page import="com.daoServlet.AppointmentDao"%>
<%@page import="com.entity.AppointEntity"%>
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
<title>Comment page</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body style="background-color: #00827F;">
		<%@ include file="navbarDoctor.jsp"%>
		<c:if test="${empty doctorObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<div class="container">
		<div class="row mt-3 pt-3">
			<c:if test="${not empty successMsg }">
				<p class="text-center text-light fw-blod fs-5">${successMsg}</p>
				<c:remove var="successMsg" scope="session" />
			</c:if>
			<c:if test="${not empty errorMsg }">
				<p class="text-center text-light fs-5">${errorMsg}</p>
				<c:remove var="errorMsg" scope="session" />
			</c:if>
			<div
				class="col col-md-6 p-3 bg-image mt-3 text-center paint-card rounded mb-3 text-white"
				style="background-image: url('../img/Female-Doctor-img-1.jpg'); background-repeat: no-repeat; background-size: cover;">
				<h1 class="mt-5 p-5 mb-4 h1"><strong>Give Your response</strong></h1>

				<p class="fs-8"><em>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
					Repellendus praesentium labore accusamus sequi, voluptate debitis
					tenetur in deleniti possimus modi voluptatum neque maiores dolorem
					unde? Aut dolorum quod excepturi fugit.</em></p>
			</div>

			<div class="col col-md-6 p-3">
				<div class="card paint-card text-light" style="background-color: #045D5D;">
					<div class="card-body">
						<p class="text-center fs-5 fw-bold">
							<i class="fa-solid fa-calendar-check"></i> Response on
							Appointment

						</p>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AppointmentDao dao = new AppointmentDao(DBConnection.MakeCon());

						AppointEntity ap = dao.getAppointDetailsById(id);
						%>
						<form action="../updateComment" method="post">
							<div class="row">
								<input type=hidden name="id" value=""> <input
									type=hidden name="did" value="">
								<div class="col-md-6">
									<label class="form-label">Full Name :</label> <input
										type="text" id="form2Example17" class="form-control"
										name="fullname" value="<%=ap.getFullName()%>" readonly />
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
									<label class="form-label">Diseases :</label> <input type="text"
										class="form-control" name="diseases"
										value="<%=ap.getDiseases()%>" placeholder="diseases name"
										readonly>
								</div>
								<input class="form-control" name="apointId" type="hidden"
									value="<%=ap.getId()%>"> <input class="form-control"
									name="doctorId" type="hidden" value="<%=ap.getDoctorId()%>">

								<div class="col-md-12 f-size-3 mt-3">
									<label class="form-label">Comment :</label>
									<textarea type="text" name="comment" required
										class="form-control" rows="3" col=""></textarea>
								</div>
								<div class="col-md-12 text-center mt-3">
									<button type="submit"
										class="btn btn-success btn-block btn-sm col-md-12">Accept</button>
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