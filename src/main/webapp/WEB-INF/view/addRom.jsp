<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 
${bootstrapjs} 
${bootstrapcss}
</head>
<body>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#exampleModal">add room</button>

	<div class="modal-dialog modal-dialog-centered">
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<form action="<%=request.getContextPath()%>/hotelRoom/addRoom" method="post">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add new Rooms</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="input-group mb-3">
								<span class="input-group-text" id="inputGroup-sizing-default">Heading</span>
								<input type="text" class="form-control" name="heading"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="inputGroup-sizing-default">Description</span>
								<textarea class="form-control"
									aria-describedby="inputGroup-sizing-default" rows="3" name="descrp"></textarea>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="inputGroup-sizing-default" >imgUrl</span>
								<input type="text" class="form-control"
									aria-describedby="inputGroup-sizing-default" name="imgurl">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="inputGroup-sizing-default">Cost</span>
								<input type="text" class="form-control"
									aria-describedby="inputGroup-sizing-default" name="cost">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<input type="submit" class="btn btn-primary">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>