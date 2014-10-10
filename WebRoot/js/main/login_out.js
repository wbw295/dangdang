$(function(){
	$("#login_out").click(function(){
		$.ajax({
		"type":"GET",
		"url":"loginOut",
		"dataType":"json",
		"success":function(data){
		//非登录状态
			$("#nickName").hide();
			$("#s_login").hide();
			$("#s_youke").show();
		}
	});
		
	});
	
});