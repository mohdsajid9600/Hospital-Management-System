<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management login</title>
<%@ include file="component/all_css_files.jsp"%>
</head>
<body>
	<%@ include file="component/navbar_file.jsp"%>
	<section class="vh-100" style="background-color: #00827F;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card paint-card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img src="img/single-female-doctor-1.jpg" alt="login form"
									class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">
									<c:if test="${not empty SuccessMsg }">
										<p class="text-center text-success fs-5">${SuccessMsg}</p>
										<c:remove var="SuccessMsg" scope="session" />
									</c:if>
									<c:if test="${not empty errorMsg }">
										<p class="text-center text-danger fs-5">${errorMsg}</p>
										<c:remove var="errorMsg" scope="session" />
									</c:if>
									<form action="ManagementLogin" method="post">

										<div class="d-flex align-items-center mb-3 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #0c9625;"></i>
											<span class="h1 fw-bold mb-0">Hospital Management
												login</span>
										</div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
											into your account</h5>

										<div class="form-outline mb-4">
											<input type="email" id="form2Example17"
												class="form-control form-control-lg" name="management_email"
												required /> <label class="form-label" for="form2Example17">Email
												address</label>
										</div>

										<div class="form-outline mb-4">
											<input type="password" id="form2Example27"
												class="form-control form-control-lg"
												name="management_password" required /> <label
												class="form-label" for="form2Example27">Password</label>
										</div>

										<div class="pt-1 mb-4">
											<button class="btn btn-dark btn-lg btn-block text-hover"
												style="background-color: #00827F;" type="submit">Login</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@include file="component/footer.jsp"%>
</body>
</html>