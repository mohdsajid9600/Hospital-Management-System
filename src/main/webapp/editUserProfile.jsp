<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User-edit profile</title>
<%@ include file="component/all_css_files.jsp"%>
</head>
<body class="bg-image"
	style="background-image: url('img/Hospital-img-2.jpg'); background-size: cover; height: 100vh">
	<%@include file="component/navbar_file.jsp"%>
	<c:if test="${empty userObj}">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<div class="container p-2">
		
		<c:if test="${not empty errorMsg }">
			<p class="text-center text-light fs-5">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<div class="row">
			<div class="col-md-8 offset-md-2 pt-5">
				<div class="card paint-card text-light"
					style="background-color: #008B8B;">
					<div class="card-body">
						<p class="text-center fs-5 fw-bold">
							<i class="fa-solid fa-user-plus"></i> Edit User-Profile</p>
						<form action="editUserProfile" method="post">
							<div class="mb-3">
								<input type="hidden" class="form-control" name="uid"
									value="${userObj.id }" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Full Name :</label> <input type="text"
									id="form2Example17" class="form-control" name="uname"
									value="${userObj.fullname }" required />
							</div>
							<div class="mb-3">
								<label class="form-label">Date of Birth :</label> <input
									type="date" class="form-control" name="udob"
									value="${userObj.dob }" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Address :</label> <input
									type="text" class="form-control" name="uaddress"
									value="${userObj.address }" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address :</label> <input
									type="email" class="form-control" name="uemail"
									value="${userObj.email }" readonly>
							</div>
							
							<div class="col-md-8 offset-md-2 text-center mt-3">
								<button type="submit" class="btn active text-dark btn-sm col-md-12" style="background-color: #78C7C7;">Update</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>