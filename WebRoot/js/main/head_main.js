//登录状态需要hide和show  的元素：
//show:id----->nickName  s_login
//hide:id------>s_youke
//非登录状态需要hide和show 的元素
//show:id----->s_youke
//hide:id------>nickName  s_login
$(function(){
	$.ajax({
		"type":"GET",
		"url":"check",
		"dataType":"json",
		"success":function(data){
		//登录状态
		if(data.ok){
			$("#nickName").show();
			$("#nickName").html(data.nickName);
			$("#s_login").show();
			$("#s_youke").hide();
		}else{
			//非登录状态
			$("#nickName").hide();
			$("#s_login").hide();
			$("#s_youke").show();
		}
		}
	});
	
});