$(function() {
	var name_flag = false;
	var address_flag = false;
	var code_flag = false;
	var phone_flag = false;
	var mobile_flag = false;

	$("#receiveName").blur(function() {
		name_flag = false;
		var $name_valid_msg = $("#nameValidMsg");
		$("#nameValidMsg").hide();
		var name = $("#receiveName").val();
		//非空检查
			if (name == "") {
				$name_valid_msg.children("p").html("姓名不能为空")
						.css("color", "red");
				$name_valid_msg.show();
				return;
			}
			//格式检查
			var reg = /^[\u4e00-\u9fa5]{2,4}$/;
			if (!reg.test(name)) {
				$name_valid_msg.children("p").html("格式不对").css("color", "red");
				$name_valid_msg.show();
				return;
			} else {
				name_flag = true;
				$name_valid_msg.children("p").html("").append(
						"<img src='/dang/images/label3.gif'/>");
				//$("#number\\.info").append("<img src='/dang/images/label3.gif'/>");
				$name_valid_msg.show();
			}
		});

	$("#fullAddress").blur(function() {
		address_flag = false;
		var $address_valid_msg = $("#addressValidMsg");
		$("#addressValidMsg").hide();
		var address = $("#fullAddress").val();
		//非空检查
			if (address == "") {
				$address_valid_msg.children("p").html("地址不能为空").css("color",
						"red");
				$address_valid_msg.show();
				return;
			}
			//格式检查
			var reg = /^[\u4e00-\u9fa5]{6,}$/;
			if (!reg.test(address)) {
				$address_valid_msg.children("p").html("地址长度不能低于6位").css(
						"color", "red");
				$address_valid_msg.show();
				return;
			} else {
				address_flag = true;
				$address_valid_msg.children("p").html("").append(
						"<img src='/dang/images/label3.gif'/>");
				$address_valid_msg.show();
			}
		});

	$("#postalCode").blur(
			function() {
				code_flag = false;
				var $code_valid_msg = $("#codeValidMsg");
				$code_valid_msg.hide();
				var code = $("#postalCode").val();
				if (code == "") {
					$code_valid_msg.children("p").html("邮编不能为空").css("color",
							"red");
					$code_valid_msg.show();
					return;
				}
				var reg = /^[1-9]\d{5}(?!\d)$/;
				if (!reg.test(code)) {
					$code_valid_msg.children("p").html("邮编格式不对").css("color",
							"red");
					$code_valid_msg.show();
					return;
				} else {
					code_flag = true;
					$code_valid_msg.children("p").html("").append(
							"<img src='/dang/images/label3.gif'/>");
					$code_valid_msg.show();
				}

			});
	$("#phone").blur(
			function() {
				phone_flag = false;
				var $phone_valid_msg = $("#phoneValidMsg");
				$phone_valid_msg.hide();
				var phone = $("#phone").val();
				if (phone == "") {
					$phone_valid_msg.children("p").html("电话不能为空").css("color",
							"red");
					$phone_valid_msg.show();
					return;
				}
				var reg = /^\d{4}-\d{7}|\d{3}-\d{8}$/;
				if (!reg.test(phone)) {
					$phone_valid_msg.children("p").html("格式不对").css("color",
							"red");
					$phone_valid_msg.show();
					return;
				} else {
					phone_flag = true;
					$phone_valid_msg.children("p").html("").append(
							"<img src='/dang/images/label3.gif'/>");
					$phone_valid_msg.show();
				}

			});
	$("#mobile").blur(
			function() {
				mobile_flag = false;
				var $mobile_valid_msg = $("#mobileValidMsg");
				$mobile_valid_msg.hide();
				var mobile = $("#mobile").val();
				if (mobile == "") {
					$mobile_valid_msg.children("p").html("手机不能为空").css("color",
							"red");
					$mobile_valid_msg.show();
					return;
				}
				var reg = /^\d{11}$/;
				if (!reg.test(mobile)) {
					$mobile_valid_msg.children("p").html("格式不对").css("color",
							"red");
					$mobile_valid_msg.show();
					return;
				} else {
					mobile_flag = true;
					$mobile_valid_msg.children("p").html("").append(
							"<img src='/dang/images/label3.gif'/>");
					$mobile_valid_msg.show();
				}

			});
	$("#f")
			.submit(
					function() {
						$("#receiveName").blur();
						$("#fullAddress").blur();
						$("#postalCode").blur();
						$("#mobile").blur();
						$("#phone").blur();
						if (!(name_flag && address_flag && code_flag
								&& phone_flag && mobile_flag)) {
							return false;
						}
						return true;
					});

});