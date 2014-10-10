<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="/dang/css/book.css" rel="stylesheet" type="text/css" />
		<link href="/dang/css/second.css" rel="stylesheet" type="text/css" />
		<link href="/dang/css/secBook_Show.css" rel="stylesheet"
			type="text/css" />
		<style type="text/css">
.newImage {
	display: inline;
}
</style>
		<script type="text/javascript" src="/dang/js/jquery-1.4.3.js">
</script>
		<script type="text/javascript" src="/dang/js/main/head_main.js">
</script>
		<script type="text/javascript" src="/dang/js/main/login_out.js">
</script>
		<script type="text/javascript" src="/dang/js/main/new_hot.js">
</script>

	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="/dang/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<s:action name="category" namespace="/main" executeResult="true">
				</s:action>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<s:action name="recommend" namespace="/main" executeResult="true"></s:action>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<s:action name="hot" namespace="/main" executeResult="true"></s:action>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<s:action name="new" namespace="/main" executeResult="true"></s:action>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<s:action name="newHot" namespace="/main" executeResult="true"></s:action>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
