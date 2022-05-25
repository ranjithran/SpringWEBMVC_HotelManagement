<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.gradient-custom {
	/* fallback for old browsers */
	background: #6a11cb;
}
</style>
${bootstrapjs} 
${bootstrapcss}
</head>
<body>
	<c:if test="${not empty error}">
		<script>
			var message = "${error}";
			alert(message);
		</script>
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


							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>