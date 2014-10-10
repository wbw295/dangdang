<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>订单列表 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js">
</script>
		<script type="text/javascript" src="../js/order/list_order.js">
</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			<h3 style="color:green;">订单列表</h3>
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>订单编号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>订单日期</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>接收人</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收获地址</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>总额</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>状态</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>操作</b>
					</td>
				</tr>

				<!-- 订单开始 -->
				<s:iterator value="orders" var="status">
					<tr class="change">
						<td valign="top">
							<input type="hidden" class="orderId" value="${id }" />
							${orderTime }
						</td>
						<td valign="top">
							<s:date name="new java.util.Date(orderTime)"
								format="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td valign="top">
							${receiveName }
						</td>
						<td valign="top">
							${fullAddress }
						</td>
						<td valign="top">
							${totalPrice}
						</td>
						<td valign="top">
							<s:if test="status==0">
								<span style="color: blue;">&lt;&lt;待支付&gt;&gt;</span>
							</s:if>
							<s:else>
								<span style="color: green;">支付已完成!</span>
							</s:else>

						</td>
						<td valign="top">
							<a href="javascript:;" class="deleteOrder" style="color: red" id="${id}">移除该定单</a>
						</td>
					</tr>

				</s:iterator>

				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="7">
						<b style="color: green;">总价￥${totalCost }</b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="../main/main" style="display: none"><input
						id="btnClientRegister" class="button_1" name="submit"
						type="submit" value="继续选购商品>>" /> </a>
				<a href="../main/main" style="color: blue;">&lt;&lt;继续选购商品</a>
			</div>

		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

