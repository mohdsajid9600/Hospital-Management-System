<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark"
	style="background-color: #045D5D;">
	<div class="container-fluid">

		<a class="navbar-brand fw-bold active" href="index.jsp"><i
			class="fa-solid fa-hospital fa-flip"></i> Mehta-Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<c:choose>
				<c:when test="${not empty userObj }">

					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link fw-bold active"
							aria-current="page" href="bookAppointment.jsp"><i
								class="fa-solid fa-calendar-check"></i> Book Appointment </a></li>
						<li class="nav-item"><a class="nav-link fw-bold active"
							aria-current="page" href="appointment_details.jsp"><i
								class="fa-solid fa-receipt"></i> View Appointment Details</a></li>
						<li class="nav-item dropdown" style="background-color: #045D5D;"><a
							class="nav-link dropdown-toggle active fw-bold fs-6" href="#"
							id="navbarDropdown" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"><i
								class="fa-solid fa-user-tie fa-beat-fade"></i> Welcome to
								${userObj.fullname }</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="editUserProfile.jsp">Edit
										Profile</a></li>
								<li><a class="dropdown-item" href="changePassword.jsp">Change
										Password</a></li>
								<li><a class="dropdown-item" href="UserLogout">Logout</a></li>
							</ul></li>
					</ul>

				</c:when>
				<c:otherwise>
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link fw-bold active"
							aria-current="page" href="appointCenter.jsp">Appointment-Center
								<i class="fa-solid fa-calendar-check"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link fw-bold active"
							aria-current="page" href="management_login.jsp">Management <i
								class="fa-solid fa-square-h"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link fw-bold active"
							aria-current="page" href="doctor_login.jsp">Doctor <i
								class="fa-solid fa-stethoscope"></i></a></li>
						<li class="nav-item"><a class="nav-link fw-bold active"
							aria-current="page" href="user_login.jsp">User <i
								class="fa-solid fa-hospital-user"></i></a></li>
					</ul>

				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>