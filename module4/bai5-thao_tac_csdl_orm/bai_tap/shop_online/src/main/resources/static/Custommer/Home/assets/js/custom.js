jQuery( document ).ready(function( $ ) {


	"use strict";
        $(function() {
            $( "#tabs" ).tabs();
        });


        // Page loading animation

        $("#preloader").animate({
            'opacity': '0'
        }, 600, function(){
            setTimeout(function(){
                $("#preloader").css("visibility", "hidden").fadeOut();
            }, 300);
        });
        

        $(window).scroll(function() {
          var scroll = $(window).scrollTop();
          var box = $('.header-text').height();
          var header = $('header').height();

          if (scroll >= box - header) {
            $("header").addClass("background-header");
          } else {
            $("header").removeClass("background-header");
          }
        });
        if ($('.owl-clients').length) {
            $('.owl-clients').owlCarousel({
                loop: true,
                nav: false,
                dots: true,
                items: 1,
                margin: 30,
                autoplay: false,
                smartSpeed: 700,
                autoplayTimeout: 6000,
                responsive: {
                    0: {
                        items: 1,
                        margin: 0
                    },
                    460: {
                        items: 1,
                        margin: 0
                    },
                    576: {
                        items: 3,
                        margin: 20
                    },
                    992: {
                        items: 5,
                        margin: 30
                    }
                }
            });
        }
		if ($('.owl-testimonials').length) {
            $('.owl-testimonials').owlCarousel({
                loop: true,
                nav: false,
                dots: true,
                items: 1,
                margin: 30,
                autoplay: false,
                smartSpeed: 700,
                autoplayTimeout: 6000,
                responsive: {
                    0: {
                        items: 1,
                        margin: 0
                    },
                    460: {
                        items: 1,
                        margin: 0
                    },
                    576: {
                        items: 2,
                        margin: 20
                    },
                    992: {
                        items: 2,
                        margin: 30
                    }
                }
            });
        }
        if ($('.owl-banner').length) {
            $('.owl-banner').owlCarousel({
                loop: true,
                nav: false,
                dots: true,
                items: 1,
                margin: 0,
                autoplay: false,
                smartSpeed: 700,
                autoplayTimeout: 6000,
                responsive: {
                    0: {
                        items: 1,
                        margin: 0
                    },
                    460: {
                        items: 1,
                        margin: 0
                    },
                    576: {
                        items: 1,
                        margin: 20
                    },
                    992: {
                        items: 1,
                        margin: 30
                    }
                }
            });
        }

        $(".Modern-Slider").slick({
            autoplay:true,
            autoplaySpeed:10000,
            speed:600,
            slidesToShow:1,
            slidesToScroll:1,
            pauseOnHover:false,
            dots:true,
            pauseOnDotsHover:true,
            cssEase:'linear',
           // fade:true,
            draggable:false,
            prevArrow:'<button class="PrevArrow"></button>',
            nextArrow:'<button class="NextArrow"></button>', 
        });

        $('.filters ul li').click(function(){
        $('.filters ul li').removeClass('active');
        $(this).addClass('active');
          
          var data = $(this).attr('data-filter');
          $grid.isotope({
            filter: data
          })
        });

        var $grid = $(".grid").isotope({
          itemSelector: ".all",
          percentPosition: true,
          masonry: {
            columnWidth: ".all"
          }
        })
        $('.accordion > li:eq(0) a').addClass('active').next().slideDown();

        $('.accordion a').click(function(j) {
            var dropDown = $(this).closest('li').find('.content');

            $(this).closest('.accordion').find('.content').not(dropDown).slideUp();

            if ($(this).hasClass('active')) {
                $(this).removeClass('active');
            } else {
                $(this).closest('.accordion').find('a.active').removeClass('active');
                $(this).addClass('active');
            }

            dropDown.stop(false, true).slideToggle();

            j.preventDefault();
        });
 
});

function ls(productId, quanlity) {
	let data = {
		productId: productId, // lay theo id
		quanlity: quanlity, // lay theo id
	};


	jQuery.ajax({
		url:  "http://localhost:8080/Home/add/ajax/ls", 
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			$("#cart").html(jsonResult.totalItems);
		},

	});
};

function toltal(productId) {
	var quanlity = document.getElementById("quality"+productId).value;
	let data = {
		productId: productId, // lay theo id
		quanlity: quanlity, // lay theo id
	};
	jQuery.ajax({
		url:  "http://localhost:8080/Home/add/ajax/total", 
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			$("#TotalPrice").html(jsonResult.TotalPrice);
		},

	});
};



function deleteItemCart(productId) {
	let data = {
		productId: productId, 
	};
	jQuery.ajax({
		url:  "http://localhost:8080/Home/add/ajax/deleteItemCart", 
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			$("#"+jsonResult.id).remove();
			$("#TotalPrice").html(jsonResult.TotalPrice);
		},

	});
};
function review(productId) {
	var rating = $('input[name="rating"]:checked').val();
	var comment = $("textarea[name=comment]").val();
	
	let data = {
		productId: productId, 
		content:comment,
		rate:rating
	};
	jQuery.ajax({
		url:  "http://localhost:8080/Home/add/ReviewAjax", 
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json", // kieu du lieu tra ve tu controller la json
		success: function(jsonResult) {
			var test = '<span class="glyphicon glyphicon-star"></span>';
			for(let i = 0 ; i<jsonResult.data.rate-1; i++){
				 test = test +'<span class="glyphicon glyphicon-star"></span>';
			}
			window.scrollTo(0, 200);
			$("h1").append(' <div class="list-group">'+
			'<a href="#" class="list-group-item active">'+
			'<div class="media col-md-3">'+
			'<figure class="pull-left">'+
			'<img class="media-object img-rounded img-responsive"  src="http://placehold.it/350x250" alt="placehold.it/350x250" >'+
			'</figure>'+
			' </div>'+
			'<div class="col-md-6">'+
			'<h4 class="list-group-item-heading">'+jsonResult.email+' </h4>'+
			'<p class="list-group-item-text">'+jsonResult.data.content+'</p>'+
			'</div>'+
			'<div class="col-md-3 text-center">'+
			' <h2> 14240 <small> votes </small></h2>'+

			'<button type="button" class="btn btn-default btn-lg btn-block"> Vote Now! </button>'+
			'<div class="stars">'+test+' </div>'+
			'<p> Average 4.5 <small> / </small> 5 </p>'+
			'</div>'+
			'</a>'
			);
			$("#review").remove();
			
		},
		error: function (jsonResult) {

            }
	
	});
};
























