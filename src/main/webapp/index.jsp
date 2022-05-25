<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<c:if test="${not empty error}">
   Error: ${error}
</c:if>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<div class="mb-md-5 mt-md-4 pb-5">

								<h2 class="fw-bold mb-2 text-uppercase">Login</h2>
								<p class="text-white-50 mb-5">Please enter your UserName and
									password!</p>
								<form action="<%=request.getContextPath()%>/User/login"
									method="post">
									<div class="form-outline form-white mb-4">
										<input type="text" class="form-control form-control-lg"
											name="username" /> <label class="form-label"
											for="typeEmailX">UserName</label>
									</div>

									<div class="form-outline form-white mb-4">
										<input type="password" class="form-control form-control-lg"
											name="password" /> <label class="form-label"
											for="typePasswordX">Password</label>
									</div>

									<button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
								</form>
								<br>
								<div class="btn btn-outline-light btn-lg px-5">
									<button class="form-control form-control-lg"
										onclick="window.location='/hotelMangement/User/CreatePage'">Create
										User</button>
								</div>

							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>