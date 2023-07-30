<%@page import="com.dbConnection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Mehta-Hospital</title>
<%@ include file="component/all_css_files.jsp"%>
</head>
<body>
	<%@ include file="component/navbar_file.jsp"%>
	<c:if test="${not empty successMsg }">
		<p class="text-center fw-blod fs-3 f-color">${successMsg}</p>
		<c:remove var="successMsg" scope="session" />
	</c:if>
	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/GP-Doctor-img-1.jpg" class="d-block w-100"
					alt="Image Not Found" height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/GP-Doctor-Oper-1.jpg" class="d-block w-100"
					alt="Image Not Found" height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/hopsital-img-6.jpg" class="d-block w-100"
					alt="Image Not Found" height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/patients-img-1.jpg" class="d-block w-100"
					alt="Image Not Found" height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/GP-Doctor-img-2.jpg" class="d-block w-100"
					alt="Image Not Found" height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleFade" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleFade" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<div class="container">
		<p class="text-center p-3 fs-2 fw-bold f-color">Key
			Features of our Hospital</p>
		<div class="row">
			<div class="col-md-8 p-5 ">
				<div class="row">
					<div class="col-md-6">
						<div
							class="card mb-3 pb-3 paint-card text-center bg-image text-light"
							style="background-image: url('img/managemnet-img-3.jpg'); background-repeat: no-repeat; background-size: cover;">
							<div class="card-body">
								<p class="fs-3 fw-bold img-text-color">100% Safety</p>
								<p class="fw-bold img-text-color">A hospital is 'safe' when it enjoys the highest level of
									protection possible, when access routes to the health facility
									are open and when the water supply and electric power.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div
							class="card mb-3 pb-3 paint-card text-center bg-image text-light"
							style="background-image: url('img/loby-hospital.jpg'); background-repeat: no-repeat; background-size: cover;">
							<div class="card-body ">
								<p class="fs-3 fw-bold img-text-color ">Clean Environment</p>
								<p class="fw-bold img-text-color">There is no visible dirt/grease/stains in any area of the
									hospital including roof top, floors and walls There are no
									cobwebs/bird nests and other incubations due to pests and
									animals.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card mb-2 paint-card text-center bg-image text-light"
							style="background-image: url('img/appoint-img-6.jpg'); background-repeat: no-repeat; background-size: cover;">
							<div class="card-body">
								<p class="fs-3 fw-bold img-text-color">Friendly Doctors</p>
								<p class="fw-bold img-text-color">A great hospital should also take pride in its doctors.
									It should showcase the doctors’ credentials and background on
									the website as well as the hospital campus.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 ">
						<div class="card mb-2 paint-card text-center bg-image text-light "
							style="background-image: url('img/hospital-building-img.jpg'); background-repeat: no-repeat; background-size: cover;">
							<div class="card-body">
								<p class="fs-3 fw-bold img-text-color">Medical Research</p>
								<p class="fw-bold img-text-color">hospital, an institution that is built, staffed, and
									equipped for the diagnosis of disease; for the treatment, both
									medical and surgical, of the sick and the injured.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col col-md-4 mb-5 pb-5 bd-image"
				style="background-image: url('img/Single-male-doctor.jpg'); background-size: cover; background-position: center;">
			</div>
		</div>
	</div>
	<hr>
	<div class="container p-2">
		<p class="text-center fs-2 fw-bold f-color">Our
			Team</p>
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card mb-3 bd-rounded">
					<div class="card-body text-center">
						<img alt="" src="img/Single-male-doctor.jpg" height="300px"
							width="200px" width="250px">
						<p class="fw-bold fs-5">Dr.Sumit Kumar Garg</p>
						<p class="fs-7 f-color">(CEO & Chairman)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card mb-3 bd-rounded">
					<div class="card-body text-center">
						<img alt="" src="img/Single-female-doctor.jpg" height="300px"
							width="200px" width="250px">
						<p class="fw-bold fs-5">Dr.Money Walliya Gupta</p>
						<p class="fs-7 f-color">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card mb-3 bd-rounded">
					<div class="card-body text-center">
						<img alt="" src="img/single-male-doctor-56.jpg" height="300px"
							width="200px" width="250px">
						<p class="fw-bold fs-5">Dr.Ramon Batty</p>
						<p class="fs-7 f-color">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card mb-3 bd-rounded">
					<div class="card-body text-center">
						<img alt="" src="img/single-male-doctor-1.jpg" height="300px"
							width="200px" width="250px">
						<p class="fw-bold fs-5">Dr. Niuise Palue</p>
						<p class="fs-7 f-color">(Chief Doctor)</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="component/footer.jsp"%>
</body>
</html>