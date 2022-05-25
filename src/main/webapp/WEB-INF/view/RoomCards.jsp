<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> ${bootstrapjs} ${bootstrapcss}
<style type="text/css">
</style>
<body>
	<input type="hidden" id="userId" value="${userId}">
	<div class="w-200"></div>
	<div class="container">
		<div class="row" data-masonry='{"percentPosition": true }'>
			<c:forEach var="rd" items="${HotelRoomDetails}">
				<div class="col-sm-4 col-md-3 py-3">
					<div class="card" style="width: 18rem;">
						<img src="${rd.imgurl}" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">${rd.heading}</h5>
							<p class="card-text">${rd.descrp}</p>
							<p class="card-text text-danger">${rd.cost}</p>
							<c:if test="${ usertype eq 'user'}">
								<button class="btn btn-primary" id='${rd.id}'
									onClick="sendBookingRequest(this.id)">Book</button>
							</c:if>
							<c:if test="${ usertype eq 'admin'}">
								<button class="btn btn-danger" id='${rd.id}'
									onClick="deletHotelRoom(this.id)">Delete</button>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Success</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Booking Susscesfully</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/roomCards.js">
		
	</script>
</body>
</html>