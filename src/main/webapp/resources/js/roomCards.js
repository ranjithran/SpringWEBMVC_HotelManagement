/**
 * 
 */
function sendBookingRequest(id) {

	let uid = getUserId();
	let url = "/hotelMangement/bookHotel";
	let fristdate = getbyIDandValue(id, "start");
	let lastdate = getbyIDandValue(id, "end");
	$.ajax({
		type: "post",
		url: url,
		data: { 'hid': id, 'uid': uid, 'fromDate': fristdate, 'toDate': lastdate },
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
function deletHotelRoom(id) {

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
function updateHotelRoom(id) {

	let url = "/hotelMangement/hotelRoom/updateRoomdetails/";
	let data = {};
	let heading = getbyIDandValue(id, "heading");
	let descrp = getbyIDandValue(id, "descrp");
	let imgurl = getbyIDandValue(id, "imgurl");
	let cost = getbyIDandValue(id, "cost");
	if (heading != null && heading != undefined) {
		data["heading"] = heading;
	}
	if (descrp != null && descrp != undefined) {
		data["descrp"] = descrp
	}
	if (imgurl != null && imgurl != undefined) {
		data["imgurl"] = imgurl;
	}
	if (cost != null && cost != undefined) {
		data["cost"] = cost;
	}
	data["id"]=id;
	if (data!=null) {
		$.ajax({
			type: "post",
			url: url,
			data: data,
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
					icon: 'Error',
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
	}else{
		Swal.fire({
					icon: 'success',
					title: 'Success',
					text: 'No data to update try editing fields',
					confirmButtonText: 'Okay',
				}).then((result) => {
					console.log(result);
					window.location.reload();
				});
	}

}
function getUserId() {
	var val = document.getElementById('userId').value;
	return val
}
function setFrist(id, val) {
	document.getElementById(id + "start").value = val;
}
function setlast(id, val) {
	document.getElementById(id + "end").value = val;
}
function getbyIDandValue(id, val) {
	let result = document.getElementById(id + val).value;
	return result;
}