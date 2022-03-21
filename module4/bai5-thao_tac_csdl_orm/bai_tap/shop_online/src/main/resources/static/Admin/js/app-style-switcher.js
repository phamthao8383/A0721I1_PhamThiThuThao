$(function() {
	"use strict";

	//****************************
	/* Top navbar Theme Change function Start */
	//****************************
	function handlenavbarbg() {
		if ($('#main-wrapper').attr('data-navbarbg') == 'skin6') {
			// do this
			$(".topbar .navbar").addClass('navbar-light');
			$(".topbar .navbar").removeClass('navbar-dark');
		} else {
			// do that    
		}
	};

	handlenavbarbg();
});

$(".deleteProduct").on('click', function() {
	var id = this.id;
/*	var name  = $('td[demo="textValue"]').val();*/
	jQuery.ajax({
		url: "/Admin/products/ajax?id=" + id,
		type: "GET",
		contentType: "application/json",
		data: JSON.stringify(id),
		dataType: "json",
		success: function(jsonResult) {
			$('.'+jsonResult.id).remove();
			Swal
				.fire(
					'Delete!',
					jsonResult.status.name,
					'success');
		},

	});
});

