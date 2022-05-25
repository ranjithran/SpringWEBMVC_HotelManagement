/**
 * 
 */
function sendBookingRequest(id) {

	let uid = getUserId();
	let url = "/hotelMangement/bookHotel";
	$.ajax({
		type: "post",
		url: url,
		data: { 'hid': id, 'uid': uid },
		success: function(result) {
			console.log(result);
			Swal.fire({
				icon: 'success',
				title: 'Success',
				text: 'Done!',
				confirmButtonText: 'Okay',
			}).then((result) => {
				console.log(result);
				window.location.reload();
			});
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
		done: function(data) {
			console.log("DONE" + data);
		}
	});
}
function deletHotelRoom(id){
	
	let url = "/hotelMangement/hotelRoom/delteRoom/";
	$.ajax({
		type: "post",
		url: url,
		data: { 'id': id },
		success: function(result) {
			console.log(result);
			Swal.fire({
				icon: 'success',
				title: 'Success',
				text: 'Done!',
				confirmButtonText: 'Okay',
			}).then((result) => {
				console.log(result);
				window.location.reload();
			});
		},
		error: function(e) {
			console.log("ERROR: ", e);
			Swal.fire({
				icon: 'rrror',
				title: 'Error',
				text: "Delet bookDetails for this room",
				confirmButtonText: 'Okay',
			}).then((result) => {
				console.log(result);
				window.location.reload();
			});
		},
		done: function(data) {
			console.log("DONE" + data);
		}
	});
}
function getUserId() {
	var val = document.getElementById('userId').value;
	return val
}