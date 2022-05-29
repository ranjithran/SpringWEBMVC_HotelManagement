/**
 * 
 */
function deleteBookingBy(id) {


	let url = "/hotelMangement/deleteBooking";
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
		},
		done: function(data) {
			console.log("DONE" + data);
		}
	});
}
function updateBookingDetails(id, value) {


	let url = "/hotelMangement/updateBooking";
	let fristdate = getfristData(id);
	let lastdate = getlastData(id);
	let data = { 'id': id, 'fromDate': fristdate, 'toDate': lastdate };
	if (value == 'false') {

		let checkbox = getcheckBox(id);
		if (checkbox == 'on') {
			data["cancled"] = 'false';
		}
	}

	console.log(data);
	$.ajax({
		type: "post",
		url: url,
		data: { 'id': id, 'fromDate': fristdate, 'toDate': lastdate },
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
function getfristData(id) {
	var val = document.getElementById(id + "start").value;
	return val;
}
function getlastData(id) {
	var val = document.getElementById(id + "end").value;
	return val;
}
function getcheckBox(id) {
	var val = document.getElementById(id + "check").value;
	return val;
}