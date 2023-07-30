<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forgot password</title>
<%@ include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-dark">
	<%@ include file="../component/navbar_file.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col col-md-8 offset-md-2">
				<div class="card paint-card">
					<div class="card-body">
						<form action="../forgotDoctorPassword" method="post">
							<div class="text-center mb-3 pb-1">
								<i class="fas fa-cubes fa-2x me-3" style="color: #0c9625;"></i>
								<span class="h1 fw-bold mb-0">Forgot Password</span>
							</div>
							 <c:if test="${not empty successMsg }">
										<p class="text-center text-success fs-5">${successMsg}</p>
										<c:remove var="successMsg" scope="session"/>
										</c:if>
										<c:if test="${not empty errorMsg }">
										<p class="text-center text-danger fs-5">${errorMsg}</p>
										<c:remove var="errorMsg" scope="session"/>
										</c:if>
							<div class="row">
								<div class="form-outline col-md-6 mb-4">
									<label class="form-label">Your Name :</label> <input
										type="text" id="form2Example17" placeholder="Your Full Name"
										class="form-control form-control-lg" name="name" required />
								</div>
								<div class="form-outline col-md-6 mb-4">
									<label class="form-label">User DOB :</label> <input type="date"
										placeholder="Enter Your DOB"
										class="form-control form-control-lg" name="dob" required />
								</div>
							</div>
							<div class="form-outline mb-4">
								<label class="form-label" for="form2Example17">Email
									address :</label> <input type="email" id="form2Example17"
									placeholder="Enter Your Email"
									class="form-control form-control-lg" name="email" required />
							</div>
							<div class="form-outline mb-4">
								<label class="form-label" for="form2Example27">Set New
									Password :</label> <input type="password" id="form2Example27"
									placeholder="Enter New Password"
									class="form-control form-control-lg" name="newPassword"
									required />
							</div>
							<div class="mb-3 text-center">
								<button type="submit"
									class="btn btn-success btn-block btn-sm col-md-12">Forgot
									Password</button>
							</div>
							<div class="mb-3 text-center" style="color: white;">
								<a href="../doctor_login.jsp"
									class="btn btn-success btn-block btn-sm col-md-12"
									role="button"> Cancel</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>