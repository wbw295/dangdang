$(function() {
	$(document).ready(
			function() {
				$.ajax( {
					url : "initAddress",
					dataType : "json",
					success : function(data) {
						if (data.cartStatus) {
							alert("你还没有购买任何商品！点击返回主界面选购商品！");
							location.href="/dang/main/main";

						} else {

							for (i = 0; i < data.ids.length; i++) {
								$("#address").append(
										"<option value='" + data.ids[i] + "'>"
												+ data.fullAddresses[i]
												+ "</option>")
							}
						}

					}
				});

			});
	$("#address").change(
			function() {
				var id = $(this).val();
				$("#addressId").val(id);
				if (id == "0") {
					$("#receiveName").removeAttr("readonly");
					$("#fullAddress").removeAttr("readonly");
					$("#postalCode").removeAttr("readonly");
					$("#mobile").removeAttr("readonly");
					$("#phone").removeAttr("readonly");

					$("#nameValidMsg").children("p").html("请填写有效的收件人姓名").css(
							"color", "black");
					$("#addressValidMsg").children("p").html("请填写有效的收件人姓名")
							.css("color", "black");
					$("#codeValidMsg").children("p").html("请填写有效的收件人姓名").css(
							"color", "black");
					$("#phoneValidMsg").children("p").html("请填写有效的收件人姓名").css(
							"color", "black");
					$("#mobileValidMsg").children("p").html("请填写有效的收件人姓名").css(
							"color", "black");

					$("#reset").click();
					return;
				}
				$.ajax( {
					url : "loadAddress",
					type : "get",
					data : "id=" + id,
					dataType : "json",
					success : function(data) {
						$("#receiveName").val(data.receiveName);
						$("#fullAddress").val(data.fullAddress);
						$("#postalCode").val(data.postalCode);
						$("#phone").val(data.phone);
						$("#mobile").val(data.mobile);

						$("#receiveName").attr("readonly", "readonly");
						$("#fullAddress").attr("readonly", "readonly");
						$("#postalCode").attr("readonly", "readonly");
						$("#mobile").attr("readonly", "readonly");
						$("#phone").attr("readonly", "readonly");

						$("#receiveName").blur();
						$("#fullAddress").blur();
						$("#postalCode").blur();
						$("#mobile").blur();
						$("#phone").blur();
					}
				});

			});

});