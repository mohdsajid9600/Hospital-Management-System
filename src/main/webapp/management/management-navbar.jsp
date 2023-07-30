<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark "  style="background-color: #045D5D;">
	<div class="container-fluid">
		<a class="navbar-brand fw-bold active" href="mainPage.jsp"><i
			class="fa-solid fa-hospital fa-flip"></i> Mehta-Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link fw-bold active" href="index.jsp"><i class="fa-sharp fa-solid fa-house-medical"></i> Home</a>
				</li>
				<li class="nav-item"><a class="nav-link fw-bold active" href="addDoctor.jsp"> <i class="fa-solid fa-user-nurse"></i> Doctor</a>
				</li>
				<li class="nav-item"><a class="nav-link fw-bold active" href="patientAppointment.jsp"><i class="fa-solid fa-person-half-dress"></i> Patient</a>
				</li>
			</ul>
			
			<form class="d-flex">
				<div class="dropdown ">
						<button class="btn btn-light dropdown-toggle" style="color: #045D5D;" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false"><i class="fa-solid fa-user-tie fa-fade"></i> Management Login</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="changePassword.jsp">Change Password</a></li>
							<li><a class="dropdown-item fw-bold" style="color: #045D5D;" href="../ManagementLogout">Logout</a></li>
						</ul>
					</div>
			</form>	
		</div>
	</div>
</nav>