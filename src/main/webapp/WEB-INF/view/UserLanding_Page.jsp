<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel management (${User.username})</title>
<style>
</style>
${bootstrapjs} ${bootstrapcss}
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col">
				<h1>Hello ${User.username}.</h1>
			</div>
			<div class="col-7"></div>
			<div class="col align-self-end">
				<a class="btn btn-danger" href="../User/logout" role="button">log
					out</a>

			</div>
		</div>
		<div class="w-100"></div>
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
					data-bs-target="#home" type="button" role="tab"
					aria-controls="home" aria-selected="true">Home</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
					data-bs-target="#profile" type="button" role="tab"
					aria-controls="profile" aria-selected="false">Booking History</button>
			</li>
			
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="home" role="tabpanel"
				aria-labelledby="home-tab">
				<jsp:include page='RoomCards.jsp'>
					<jsp:param name="roomdetails" value="${roomDetails}" />
				</jsp:include>
			</div>
			<div class="tab-pane fade" id="profile" role="tabpanel"
				aria-labelledby="profile-tab">
				<jsp:include page='listofBookings.jsp'>
					<jsp:param name="rd" value="" />
				</jsp:include>
			</div>
			
		</div>
	</div>
</body>
</html>