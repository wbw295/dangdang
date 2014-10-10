function stopBubble(e){
	if(e&&e.stopPropagation){
		e.stopPropagation();
	}else{
		window.event.cancelBubble=true;
	}
}

$(function(){
	$(".change").mouseover(function(){
		$(this).css("background-color","plum");
	});
	$(".change").mouseout(function(){
		$(this).css("background-color","white");
	});
	$(".change").click(function(){
		var $order_id=$(this).find("input");
		var orderId=$order_id.val();
		location.href="/dang/order/orderLook?orderId="+orderId;
//		$.ajax({
//			url:"orderLook",
//			type:"get",
//			data:"orderId="+orderId,
//			dataType:"json",
//			success:function(){
//			
//			}
//		});
	});
	$(".deleteOrder").click(function(e){
		var id=$(this).attr("id");
		location.href="/dang/order/deleteOrder?id="+id;
		stopBubble(e);
	});
});