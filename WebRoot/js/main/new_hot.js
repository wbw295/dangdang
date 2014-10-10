$(function() {
	$(".newHot").mouseover(function() {
		$(this).next("div").children("a").css("display","inline");
	});
	$(".newHot").mouseout(function() {
		$(this).next("div").children("a").css("display","none");
	});

});