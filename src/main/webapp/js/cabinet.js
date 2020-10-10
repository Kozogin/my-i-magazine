var magazines = null;

$.get("magazines", function(data) {	
		
	if(data !== ''){
		magazines = data;
	}
}).done(function(){
	
	var cardsContext = '';
	jQuery.each(magazines, function(i, value){
		
		cardsContext +=
			'<div class="col">' +
			'<div class="card">' +
			'<div class="card-body">' + 		
			'<h5 class="card-title">' + value.name + '</h5>' +		
			'<h6 class="card-subtitle mb-2 text-muted">' + value.price +'</h6>'+
			'<p class="card-text">' + value.description + '</p> ' + 
			'<p class="card-text">' + value.isbn + '</p> ' +
			'<p class="card-text">' + value.id + '</p> ' +
			
			
			'<a href="magazineContr?id=' + value.id + '" class="card-link">link  '+ value.id +'</a>' +
			'</div>' +
			'</div>' + 
		    '</div>'
		
		
	});
	
	
	
	for(i = 1;i < 27; i++){
		cardsContext += "<br>"
	}
	
	$('#magazineCards').html(cardsContext);
});