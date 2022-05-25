/**
 * 
 */
 function deleteBookingBy(id) {

	
	let url = "/hotelMangement/deleteBooking";
	$.ajax({
		type: "post",
		url: url,
		data: {'id': id },
		success: function(result) {
			console.log(result);
			Swal.fire({
				icon: 'success',
				title: 'Success',
				text: 'Done!',
				confirmButtonText: 'Okay',
			}).then((result) => {
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