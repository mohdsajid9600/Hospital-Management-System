<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark"
	style="background-color: #045D5D;">
	<div class="container-fluid">

		<a class="navbar-brand fw-bold active" href="mainPage.jsp"><i
			class="fa-solid fa-hospital fa-flip"></i> Mehta-Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<c:if test="${not empty doctorObj }">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link fw-bold active"
						aria-current="page" href="index.jsp"><i
							class="fa-sharp fa-solid fa-house-medical"></i> Home </a></li>
					<li class="nav-item"><a class="nav-link fw-bold active"
						aria-current="page" href="patient.jsp"><i
							class="fa-solid fa-person-half-dress"></i> Patient</a></li>
				</ul>
				<form class="d-flex">
					<div class="dropdown">
						<button class="btn btn-light dropdown-toggle fw-bold"
							style="color: #045D5D;" type="button" id="dropdownMenuButton1"
							data-bs-toggle="dropdown" aria-expanded="false">
							<i class="fa-solid fa-user-nurse fa-fade"></i>
							${doctorObj.fullName}
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="editProfile.jsp">Edit
									Profile</a></li>
							<li><a class="dropdown-item" href="changePassword.jsp">Change
									Password</a></li>
							<li><a class="dropdown-item fw-bold" style="color: #045D5D;"
								href="../doctorLogout">Logout</a></li>
						</ul>
					</div>
				</form>
			</c:if>
		</div>
	</div>
</nav>