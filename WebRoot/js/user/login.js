//$(function(){
//	$("#ctl00").submit(function(){
//		alert("123");
//		var email=$("#txtUsername").val();
//		var password=$("#txtPassword").val();
//		
//		return false;
//		$.ajax( {
//				"url" : "verifyLogin",
//				"type" : "POST",
//				"data" : "email="+email+"&password="+password,
//				"success" : function(data) {
////					alert("还是测试一下吧！");
////				alert(data.ok);
//				if(data){
//					//location("verify");
//					return true;
//				}else{
//					$("#loginMsg").text("用户名或密码错误").css("color","red");
//					return false;
//				}
//				}
//			});
//		
//		
//		
//	});
//	
//});
$(function() {
	//验证码更新
	$("#btnSignCheck").click(function() {
		document.getElementById("ctl00").submit();
	});
});
