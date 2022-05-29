<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 
</head>
<body>
	<c:forEach var="bd" items="${UserDetails}">
		
		<li
			class="list-group-item d-flex justify-content-between align-items-center">
			<div class="ms-2 me-auto">
				<div class="fw-bold">${bd.username}</div>
				${bd.createdTime}
			</div> <span class="badge "><button type="button" id="${bd.email}"
					class="btn btn-danger" onClick="deleteUserBy(this.id)">Delete</button></span>
		</li>
	</c:forEach>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/UserDelete.js">
		
	</script>
</body>
</html>