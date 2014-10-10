//$(function() {
//	var pid = $("#pid").val();
//	var cid = $("#cid").val();
//	var up = $("#up").val();
//	var down = $("#down").val();
//	$("#a_up").click(
//			function() {
//				$("#load_books").load(
//						"/dang/main/loadbooks?pid=" + pid + "&cid=" + cid
//								+ "&page=" + up);
//			});
//	$("#a_down").click(
//			function() {
//				$("#load_books").load(
//						"/dang/main/loadbooks?pid=" + pid + "&cid=" + cid
//								+ "&page=" + down);
//			});
//});

$(function() {
	$(".goumai").click(function() {
		var pid = $(this).attr("id");
		var $msg_span = $(this).next();
		var $button = $(this);
		$button.hide();
		$.ajax( {
			"type" : "POST",
			"url" : "/dang/cart/buy",
			"dataType" : "json",
			"data" : "pid=" + pid,
			"success" : function(data) {

				if (data.buy) {
					$msg_span.html("购买成功").css("color", "green");
					$button.hide();
				} else {
					$msg_span.html("已购买过该商品,去购物车修改数量！").css("color", "red");
					$button.hide();
				}

			}
		});
		return false;//取消href功能
		});
	$("#goPage").change(
			function() {
				var pid = $("#pid").val();
				var cid = $("#cid").val();
				var page = $(this).val();
				location.href = "/dang/main/booklist?pid=" + pid + "&cid="
						+ cid + "&page=" + page;

			});
});