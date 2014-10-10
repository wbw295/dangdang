$(function() {
	//1.Email----id:txtEmail ~~~~ Emailinfo-----id:email.info
	//2.NickName---------id:txtNickName ~~~~ nameinfo--------id:name.info
	//3.Password-------id:txtPassword  ~~~~ passinfo-----------id:password.info
	//4.RepeatPass-----id:txtRepeatPass  ~~~~ pass1inf--------id:password1.info
	//5.CheckCode-------id:txtVerifyCode ~~~~ checkinfo-------id:number.info
	//6.<a href="#"></a> ~~~ 验证码的更新  ajax
	//1~5提示+决定是否提交  6为更新验证码
	var email_flag = false;
	var nickname_flag = false;
	var password_flag = false;
	var repeat_flag = false;
	var check_flag = false;
	//Email检查
	$("#txtEmail")
			.blur(function() {
				email_flag = false;
				$("#email\\.info").html("");
				var email = $("#txtEmail").val();
				//非空检查
					if (email == "") {
						$("#email\\.info").html("邮箱不能为空").css("color", "red");
						return;
					}
					//格式检查
					var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
					if (!pattern.test(email)) {
						$("#email\\.info").html("邮箱格式错误").css("color", "red");
						return;
					}
					//唯一性检查
					$
							.ajax( {
								url : "validateEmail",
								type : "post",
								data : {
									"email" : email
								},
								dataType : "json",
								async : false,
								success : function(data) {
									if (data) {
										//可用
										$("#email\\.info").html("");
										$("#email\\.info")
												.append(
														"<img src='/dang/images/label3.gif'/>");
										email_flag = true;
									} else {
										//不可用
										$("#email\\.info").html("邮箱被占用").css(
												"color", "red");

									}

								}
							});

				});
	//NickName检查
	$("#txtNickName").blur(function() {
		nickname_flag = false;
		$("#name\\.info").html("");
		var name = $("#txtNickName").val();
		//非空检查
			if (name == "") {
				$("#name\\.info").html("昵称不能为空").css("color", "red");
				return;
			}
			//格式检查
			var reg = /^[\da-z\u4e00-\u9fa5]{4,20}$/;
			//var reg=/[a-z0-9[^A-Za-z0-9_\n\t]]/;
			if (!reg.test(name)) {
				$("#name\\.info").html("昵称格式错误").css("color", "red");
				return;
			}
			$("#name\\.info").html("");
			$("#name\\.info").append("<img src='/dang/images/label3.gif'/>");
			nickname_flag = true;
		});

	//Password检查
	$("#txtPassword").blur(function() {
		password_flag = false;
		$("#password\\.info").html("");
		var password = $("#txtPassword").val();
		//非空检查
			if (password == "") {
				$("#password\\.info").html("密码不能为空").css("color", "red");
				return;
			}
			//格式检查
			var reg = /^[0-9a-zA-Z]{6,20}$/;
			//var reg=/[a-z0-9[^A-Za-z0-9_\n\t]]/;
			if (!reg.test(password)) {
				$("#password\\.info").html("密码格式错误").css("color", "red");
				return;
			}
			if ((password != $("#txtRepeatPass").val())
					&& ($("#txtRepeatPass").val() != "")) {
				$("#password1\\.info").html("密码不匹配").css("color", "red");
				return;
			}
			$("#password\\.info").html("");
			$("#password\\.info")
					.append("<img src='/dang/images/label3.gif'/>");
			password_flag = true;
		});
	//RepeatPass检查
	$("#txtRepeatPass").blur(function() {
		repeat_flag = false;
		$("#password1\\.info").html("");
		var repeat = $("#txtRepeatPass").val();
		//非空检查
			if (repeat == "") {
				$("#password1\\.info").html("确认密码不能为空").css("color", "red");
				return;
			}
			//匹配检查
			if (repeat != $("#txtPassword").val()) {
				$("#password1\\.info").html("密码不匹配").css("color", "red");
				return;
			}
			$("#password1\\.info").html("");
			$("#password1\\.info").append(
					"<img src='/dang/images/label3.gif'/>");
			repeat_flag = true;

		});
	//CheckCode检查
	$("#txtVerifyCode").blur(
			function() {
				check_flag = false;
				$("#number\\.info").html("");
				var number = $("#txtVerifyCode").val();
				if (number == "") {
					$("#number\\.info").html("验证码不能为空"), css("color", "red");
					return;
				}
				$.ajax( {
					"url" : "checkNumber?number=" + number,
					"type" : "GET",
					"dataType" : "json",
					"success" : function(data) {
						//					alert("还是测试一下吧！");
					//				alert(data.ok);
					if (data) {
						$("#number\\.info").html("");
						$("#number\\.info").append(
								"<img src='/dang/images/label3.gif'/>");
						check_flag = true;
					} else {
						$("#number\\.info").text("验证码错误").css("color", "red");
					}
				}
				});

			});
	//验证码更新
	$("#replace").click(
			function() {
				$("#imgVcode").attr("src",
						"checkCode?value=" + (new Date()).getTime());
			});
	//提交检查
	$("form").submit(function() {
		//判断各个表单项是否通过检查
			//	return email_flag&&nickname_flag&&;
			$("input").blur();
			//alert($("input").blur());
			setTimeOut(function() {
				if (!(email_flag && nickname_flag && password_flag
						&& repeat_flag && check_flag)) {
					return false;
				}
				return true;
			}, 500);

		});
});
