<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="book_r_border2" id="__XinShuReMai">
	<div class="book_r_b2_1x" id="new_bang">
		<h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<s:iterator value="hotProducts">
			<a href="javascript:;" class="newHot" target="_self">${productName}</a>
			<div class="img">
				<a href="#" class="newImage" style="display: none;"><img
						src="/dang/productImages/${productPic}" border=0 width="90px" />
				</a>
			</div>

		</s:iterator>
		<div id="NewProduct_1_o_t" onmouseover="">
			<h3 class="second">
				<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
			</h3>
		</div>
	</div>
</div>