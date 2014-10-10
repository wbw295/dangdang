$(function(){
	$("#email_form").submit(function(){
		var code=$("#validatecode").val();
		$.ajax( {
				"url" : "checkEmail?code="+code,
				"type" : "GET",
				"dataType" : "json",
				"success" : function(data) {
//					alert("还是测试一下吧！");
//				alert(data.ok);
				if(data){
					location="registOK";
				}else{
					$("#errorMsg").text("验证码错误").css("color","red");
				}
				}
			});
		
		
		
	});
	
});