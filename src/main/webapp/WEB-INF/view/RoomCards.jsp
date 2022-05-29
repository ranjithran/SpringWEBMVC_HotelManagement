<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<div class="input-group mb-3">
								<span class="input-group-text">Start Date</span> <input
									type="date" name="firstdate"
									onblur="setFrist(${rd.id},this.value);" />
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">End Date</span> <input
									type="date" name="lastdate"
									onblur="setlast(${rd.id},this.value);" />
							</div>
							<button type="button" class="btn btn-primary"
								onclick="sendBookingRequest(this.id)" id='${rd.id}'>Book</button>
							<input type="hidden" id="${rd.id}start" value="">
							<input type="hidden" id="${rd.id}end" value="">
						</c:if>
						<c:if test="${ usertype eq 'admin'}">
							<button class="btn btn-danger" id='${rd.id}'
								onClick="deletHotelRoom(this.id)">Delete</button>
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#popupUpdate${rd.id}">update</button>
						</c:if>
					</div>
				</div>
			</div>
			<div class="modal fade" id="popupUpdate${rd.id}" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Update Hotel
								Info id=${rd.id}</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="input-group mb-3">
								<span class="input-group-text">Heading</span> <input type="text"
									class="form-control" name="heading" id="${rd.id}heading"
									aria-describedby="inputGroup-sizing-default"
									value="${rd.heading}">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">Description</span>
								<textarea class="form-control" id="${rd.id}descrp"
									aria-describedby="inputGroup-sizing-default" rows="3"
									name="descrp">${rd.descrp}</textarea>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">imgUrl</span> <input type="text"
									class="form-control" id="${rd.id}imgurl"
									aria-describedby="inputGroup-sizing-default" name="imgurl"
									value="${rd.imgurl}">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">Cost</span> <input type="text"
									class="form-control" id="${rd.id}cost"
									aria-describedby="inputGroup-sizing-default" name="cost"
									value="${rd.cost}">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" id="${rd.id}"
								onclick="updateHotelRoom(this.id)">Save changes</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/roomCards.js">
</script>