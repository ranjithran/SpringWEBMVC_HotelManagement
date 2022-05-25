<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>${bootstrapjs}${bootstrapcss}
</head>
<body>
	<c:forEach var="bd" items="${BookingDetails}">

		<li
			class="list-group-item d-flex justify-content-between align-items-center">
			<div class="ms-2 me-auto">
				<div class="fw-bold badge bg-primary text-wrap">${bd.hotelRoomDetails.heading}</div>
				<c:if test="${usertype eq 'admin'}">
					<div class="">${bd.descrp}</div>
				</c:if>

			</div> ${bd.bookeedtime} <span class="badge "><button type="button"
					id="${bd.id}" class="btn btn-danger"
					onclick="deleteBookingBy(this.id)">Delete</button></span>
		</li>
	</c:forEach>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/BookingDelete.js">
		
	</script>
</body>
</html>