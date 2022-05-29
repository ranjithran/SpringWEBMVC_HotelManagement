<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> ${bootstrapjs} ${bootstrapcss}
</head>
<body>
	<div class="container">
		<div class="card text-center">
			<div class="card-header">
				<h1>User Register Form:</h1>
			</div>
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/User/create"
					method="post">

					<div class=" form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">User
							Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="username"
								placeholder="Enter user name">
						</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">E-Mail</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="email"
								placeholder="Enter E-mail">
						</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Phone Number</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="phonenumber"
								placeholder="Enter Phone Number">
						</div>
					</div>
					<div class="form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Passwrod</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password"
								placeholder="Enter Password">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>