<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>订单详细 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="../js/order/look_order.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			<h3 style="color:green;">订单商品详细</h3>
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>
				<!-- 订单开始 -->
				<s:iterator value="items" var="status">
					<tr>
						<td valign="top">
							${id }
						</td>
						<td valign="top">
							${productName }
						</td>
						<td valign="top">
							${dangPrice }
						</td>
						<td valign="top">
							${productNum }
						</td>
						<td valign="top">
							${dangPrice*productNum}
						</td>
					</tr>

				</s:iterator>

				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b style="color: green;">总价￥${totalPrice }</b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="../order/orderList" style="color: blue;">&lt;&lt;返回订单列表</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:if test="orderStatus==1">
					<span style="color: green;">支付已完成！</span>
				</s:if>
				<s:else>
					<a href="javascript:;" style="color: blue;" class="payOrder" id="${orderId}">点击将完成支付--&gt;&gt;</a>
				</s:else>
			</div>

		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

