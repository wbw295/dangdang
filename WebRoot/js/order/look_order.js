function stopBubble(e) {
	if (e && e.stopPropagation) {
		e.stopPropagation();
	} else {
		window.event.cancelBubble = true;
	}

}
$(function() {
	$(".payOrder").click(function(e) {
		var orderId = $(this).attr("id");
		$.ajax( {
			url : "payOrder",
			type : "get",
			data : "orderId=" + orderId,
			success : function(data) {
				alert("恭喜你！支付完成！");
				location.href="/dang/order/orderLook?orderId="+orderId;
			}
		});
		stopBublle(e);
	})

});