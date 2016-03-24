$(document).ready(function() {
	  $('#list').click(function(event) {
	    event.preventDefault();
	    $('#data .item').addClass('list-group-item');
	  });
	  $('#grid').click(function(event) {
	    event.preventDefault();
	    $('#data .item').removeClass('list-group-item');
	    $('#data.item').addClass('grid-group-item');
	  });
	});




