<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
<%@include file="../component/all_css_files.jsp"%>
</head>
<body class="bg-secondary">
	<%@ include file="management-navbar.jsp"%>
	<c:if test="${empty managementObj }">
		<c:redirect url="../management_login.jsp"></c:redirect>
	</c:if>
	<div class="container p-5">
		<c:if test="${not empty successMsg }">
			<p class="text-center text-success fs-5">${successMsg}</p>
			<c:remove var="successMsg" scope="session" />
		</c:if>
		<c:if test="${not empty errorMsg }">
			<p class="text-center text-light fw-bold fs-5">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<div class="row mt-5">
			<div class="col col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<form action="../mngeChangePassword" method="post">
							<div class="form-group">
								<label>Enter Current Password :</label><input
									class="form-control" name="currentPassword" required
									type="password"> <label>Enter New Password :</label><input
									class="form-control" name="newPassword" required type="password">
								<input class="form-control" name="uid" required type="hidden"
									value="${managementObj.id}">
								<div class="text-center mt-3">
									<a href="index.jsp"><button type="button"
											class="btn btn-secondary active btn-block">Close</button></a>
									<button class="btn btn-success active btn-block" type="submit">Change
										Password</button>
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