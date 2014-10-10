$(function() {
	$(".modify").click(function() {
		var $num = $(this).prev(".del_num");
		var $msg = $(this).parent().prev(".buy_td_1");
		var pid = $num.attr("id");
		var qty = $num.val();
		var reg=/^[1-9][0-9]*$/;
		if(!reg.test(qty)){
			alert("输入数量不合法！请输入大于0的正整数！");
			return false;
		}
		$.ajax( {
			"url" : "modify",
			"type" : "POST",
			"data" : "pid=" + pid + "&qty=" + qty,
			"dataType" : "json",
			"success" : function(data) {
				$msg.html(data.qty);
				$("#total_economy").html(data.totalSale);
				$("#total_account").html(data.totalCost);
			}
		});
		return false;

	});
	$("#account").click(function(){
		$.ajax({
			url:"../cart/cartCheck",
			type:"get",
			dataType:"json",
			success:function(data){
			if(data.cartStatus){
				alert("你尚未购买任何商品！点击回到主界面选购商品！");
				location.href="/dang/main/main";
				
			}else{
				if(!(data.loginStatus)){
					alert("检测到你尚未登录！点击回到登录界面！");
					location.href="/dang/user/login";
					
				}else{
					location.href="/dang/order/orderInfo";
				}
				
			}
			
			}
			
		});
		
	});
	
});