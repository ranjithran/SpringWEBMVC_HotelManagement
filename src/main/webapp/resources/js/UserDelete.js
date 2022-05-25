/**
 * 
 */
function deleteUserBy(id) {


	let url = "/hotelMangement/User/deleteUser";
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
				window.location.reload();
			});
		},
		error: function(e) {
			console.log("ERROR: ", e);
				Swal.fire({
				icon: 'rrror',
				title: 'Error',
				text: "Delet bookDetails for this user",
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