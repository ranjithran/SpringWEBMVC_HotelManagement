<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="bd" items="${BookingDetails}">
	<c:set var="cancled" value="bg-primary" />
	<c:if test="${bd.cancled eq true}">
		<c:set var="cancled" value="bg-danger" />
	</c:if>
	<li
		class="list-group-item d-flex justify-content-between align-items-center ${cancled}">
		<div class="ms-2 me-auto">
		<div class="fw-bold badge bg-primary text-wrap fs-4 p-2">Booked by ${bd.userdetails.username}</div>
		<br/>
			<div class="fw-bold badge bg-primary text-wrap fs-4 p-2">Booking
				No:${bd.id} ${bd.hotelRoomDetails.heading}</div>
			<div class="fw-bold badge bg-success text-wrap">${bd.fromDate}</div>

			<div class="fw-bold badge bg-success text-wrap">${bd.toDate}</div>
			<c:if test="${usertype eq 'admin'}">
				<div class="">${bd.descrp}</div>
			</c:if>
		</div> <span class="badge "><button type="button"
				class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#popupUpdate${bd.id}">Update</button> </span> <c:if
			test="${bd.cancled eq false}">
			<span class="badge "><button type="button" id="${bd.id}"
					class="btn btn-danger" onclick="deleteBookingBy(this.id)">Cancel</button></span>
		</c:if>
	</li>
	<div class="modal fade" id="popupUpdate${bd.id}" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update booking
						id=${bd.id}</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="input-group mb-3">
						<span class="input-group-text">Start Date</span> <input
							type="date" name="firstdate" id='${bd.id}start'
							value="${bd.fromDate}" />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text">End Date</span> <input type="date"
							name="lastdate" id='${bd.id}end' value="${bd.toDate}" />
					</div>

					<c:if test="${cancled eq 'bg-danger'}">
						<div class="input-group mb-3">
							<input class="form-check-input" type="checkbox" value=""
								id="${bd.id}check" checked> <label
								class="form-check-label"> Canceled </label>
						</div>
					</c:if>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="${bd.id}"
						onclick="updateBookingDetails(this.id ,${bd.cancled})">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/BookingDelete.js">
	
</script>
