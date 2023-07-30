<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User registration</title>
<%@ include file="component/all_css_files.jsp"%>
</head>
<body>
	<%@ include file="component/navbar_file.jsp"%>

	<section class="vh-100" style="background-color: #00827F;">
		<div class="container py-5  h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card mt-0" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img src="img/single-female-doctor-1.jpg" alt="login form"
									class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">
									<c:if test="${not empty errorMsg }">
										<p class="text-center text-danger">${errorMsg}</p>
										<c:remove var="errorMsg" />
									</c:if>
									<form action="userRegister" method="post">

										<div class="d-flex align-items-center mb-3 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #0c9625;"></i>
											<span class="h1 fw-bold mb-0">User Registration</span>
										</div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">
											<a href="user_login.jsp" role="button"
												style="text-decoration: none;color: #045D5D;" class="fw-bold">[Sign in] </a>Create
											your user account</h5>
										<div class="row">
										<div class="form-outline col-md-6 mb-4">
											<input type="text" id="form2Example17"
												placeholder="Your Full Name"
												class="form-control form-control-lg" name="username" required />
										</div>
										<div class="form-outline col-md-6 mb-4">
											<input type="date" placeholder="Enter Your DOB"
												class="form-control form-control-lg" name="udob" required />
										</div>
										 </div>
										<div class="form-outline mb-4">
											<input type="text" placeholder="Enter Your address"
												class="form-control form-control-lg" name="uaddress" required />
										</div>
										<div class="form-outline mb-4">
											<input type="email" id="form2Example17" placeholder="Enter Your Email Address"
												class="form-control form-control-lg" name="useremail" required /> <label
												id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</label>
												
										</div>

										<div class="form-outline mb-4">
											<input type="password" id="form2Example27"
												placeholder="Set Your New Password"
												class="form-control form-control-lg" name="userpassword" required />
										</div>
										<div class="row">
											<div class=" col pt-1 mb-4">
												<button class="btn btn-secondary btn-sm btn-block" type="submit">Submit
													Details</button>
											</div>
											<div class="col pt-1 mb-4 btn float-right">
												<button class="btn btn-secondary btn-sm btn-block" type="reset">Reset
													Details</button>
											</div>
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