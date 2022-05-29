<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="container">
	<div class="card text-center">
		<div class="card-header">
			<h1>Update Profile Details</h1>
		</div>
		<div class="card-body">
			<form action="<%=request.getContextPath()%>/User/update"
				method="post">
				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">User
						ID</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="username"
							placeholder="Enter user name" value='${User.id}' disabled="disabled">
					</div>
				</div>
				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">User
						Name</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="username"
							placeholder="Enter user name" value='${User.username}'>
					</div>
				</div>
				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">E-Mail</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="email"
							placeholder="Enter E-mail" value='${User.email}'>
					</div>
				</div>
				<div class=" form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">Phone
						Number</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="phonenumber"
							placeholder="Enter Phone Number" value='${User.phonenumber}'>
					</div>
				</div>
				<!-- 
					<div class="form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Passwrod</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password"
								placeholder="Enter Password" value='${User.password}'>
						</div>
					</div>
		 -->
				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</div>
</div>
