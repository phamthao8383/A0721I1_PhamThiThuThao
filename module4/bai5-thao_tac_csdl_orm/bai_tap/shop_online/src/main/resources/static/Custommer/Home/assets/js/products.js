var page = 1;
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() >= $(document).height()) {
     	page++;
	var search  =  document.getElementById("search").value;
	jQuery.ajax({
		url:  "http://localhost:8080/Home/Products/Ajax?pageId="+page+"&search="+search, 
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(page),
		dataType: "json", 
		success: function(jsonResult) {
			console.log(jsonResult);
			var test = '';
			if(jsonResult.data.rate == null){
				var test = '<p>Chua co danh gia</p>';
			}
			else{
				for(let i = 0 ; i<jsonResult.data.rate; i++){
				 test = test +'<li><i class="fa fa-star"></i></li>';
			}
			}
			
			var html = '';
			for(i = 0;i<jsonResult.sizeOfPage;i++){
				html += 
				'<div class="col-lg-4 col-md-4 all des">'+
				'<div class="product-item">'+
				'<a href="#"><img src="/Custommer/Home/assets/upLoadImage'+jsonResult.data[i].avatar+'"</a>'+
				'<div class="down-content">'+
				'<a href="/Home/ProductDetail?id='+jsonResult.data[i].id+'"><h4>'+jsonResult.data[i].name+'</h4></a>'+
				'<h6 >'+jsonResult.data[i].price+'</h6>'+
				'<p>'+jsonResult.data[i].description+'</p>'+
				'<ul class="stars">'+
				(test)+
				'</ul><span>Reviews</span>'+
		'<div><button id="scroll" type="button" class="btn" onclick="ls('+jsonResult.data[i].id+',1)">add tocart</button></div>'+
				'</div></div></div>'
				;
			}
			$("#test").before(html);


		},

	});
    
    }
});
