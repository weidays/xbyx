<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../top.jsp"></jsp:include>
<a href="index.aspx">首页</a>>名师工作室
<hr />
株洲市第一中学名师工作室：
<br />
<br />
<s:if test="#request.xks!=null && #request.xks.size()>0">
	<s:iterator var="xk" value="#request.xks" status="statu">
		<s:if test="#statu.index==8">
			<br>
		</s:if>
		<a href="${ms_url}" class="btn btn-large btn-info" style="margin-left:10px;">${XKMC}</a>
	</s:iterator>
</s:if>
<br />
<hr />


<div class="row-fluid">
	<div class="span8">
		<div class=" yy_border">
			<div class="yy_title">
				<b>资源素材</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class=" yy_border">
			<div class="yy_title">
				<b>最新交流</b>
			</div>
			暂无教研动态信息！
		</div>
	</div>
	<div class="span4">
		<div class=" yy_border1">
			<div class="yy_title">
				<b>教研动态</b>
			</div>
				<div class="yy_content">
				<s:if test="#request.ytdt!=null && #request.ytdt.size()>0">
					<s:iterator var="ytdt" value="#request.ytdt" status="statu">
						<a href="${id}">[${xkmc}]&nbsp;&nbsp; <s:if
								test="%{name.length()>12}">
								<s:property value="%{name.substring(0,12)+'...'}" />
							</s:if> <s:else>
						${name}
						</s:else> </a>
						<br>
					</s:iterator>
				</s:if>
				<s:else>
				暂无教研动态信息！
				</s:else>
			</div>
		</div>
		<br />
	</div>
</div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
