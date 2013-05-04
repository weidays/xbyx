<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="top.jsp"></jsp:include>
<p style="font-size:22pt;"><b><s:property value="#session.xkmap.xkmc"/>学科组</b></p>
<hr style="border-top:2px solid  #868686;HEIGHT:0;"/>

<div id="xkjsall" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
<div style="padding:10px;">
	<p><b>学科介绍：</b></p>
	<p style="text-indent:30px;">
	<s:property value="#session.xkmap.xkjs"/>
	</p>
</div>
</div>
<div class="row-fluid">
<div class="span8">
<p style="text-indent:30px; line-height:25px; height:130px;">
<s:if test="%{#session.xkmap.xkjs.length()>195}">
<s:property value="%{#session.xkmap.xkjs.substring(0,195)+'...'}"/>
</s:if>
<s:else>
<s:property value="#session.xkmap.xkjs"/>
</s:else>
&nbsp;&nbsp;<a style="color:#003399;" href="#xkjsall" data-toggle="modal">[查看全部]</a>
</p>

<div class="yy_border1" style="height:292px;">
	<div class="yy_title">
		<b> 最新集体备课</b>
	</div>
	<div style="padding-left:10px;line-height:25px; ">
		<s:if test="#request.xkjtbks!=null && #request.xkjtbks.size()>0">
			<s:iterator var="xkjtbk" value="#request.xkjtbks" status="statu">
			<s:if test="#statu.index==1">
			<div style="padding-top:10px; padding-left:20px;padding-bottom:10px; width:46%; float:left; border-left:1px solid  #D7D7D7;border-top:1px solid  #D7D7D7;">
					<span style="color:#003399;font-size:12pt;font-weight:bold;">
						<s:if test="%{bkmc.length()>10}">
							<s:property value="%{bkmc.substring(0,10)+'...'}" />
						</s:if> <s:else>
						${bkmc}
						</s:else> </span> <br> <span
						style="color:#FF6600; padding-top:10px;display:block">
						科目：${xkmc } <font style="color:#008000;">${bkzt}</font> </span> <span>
						发起人：${jsxm}</span><br>
					<a type="button" class="btn " href="xk/beikeDetail.aspx?bkbh=${bkbh}">查看</a>
					
					
				</div>
			</s:if>
			<s:elseif test="#statu.index==2">
			<div style="padding-top:10px; padding-left:20px;padding-bottom:10px; width:46%; float:left; border-top:1px solid  #D7D7D7; border-right:1px solid  #D7D7D7;">
					<span style="color:#003399;font-size:12pt;font-weight:bold;">
						<s:if test="%{bkmc.length()>10}">
							<s:property value="%{bkmc.substring(0,10)+'...'}" />
						</s:if> <s:else>
						${bkmc}
						</s:else> </span> <br> <span
						style="color:#FF6600; padding-top:10px;display:block">
						科目：${xkmc } <font style="color:#008000;">${bkzt}</font> </span> <span>
						发起人：${jsxm}</span><br>
					<a type="button" class="btn" href="xk/beikeDetail.aspx?bkbh=${bkbh}">查看</a>
					
					
				</div>
			</s:elseif>	
			<s:else>
			<div style="padding-top:10px; padding-left:20px; width:46%; float:left;padding-bottom:10px; border-top:1px solid  #D7D7D7;">
					<span style="color:#003399;font-size:12pt;font-weight:bold;">
						<s:if test="%{bkmc.length()>10}">
							<s:property value="%{bkmc.substring(0,10)+'...'}" />
						</s:if> <s:else>
						${bkmc}
						</s:else> </span> <br> <span
						style="color:#FF6600; padding-top:10px;display:block">
						科目：${xkmc } <font style="color:#008000;">${bkzt}</font> </span> <span>
						发起人：${jsxm}</span><br>
						
					<a type="button" class="btn" href="xk/beikeDetail.aspx?bkbh=${bkbh}">查看</a>
					
					
				</div>
			</s:else>
			</s:iterator>
		</s:if>
		<s:else>
			暂无备课信息！
		</s:else>
	</div>
</div>
<br>
<jsp:include page="../center_comm.jsp"></jsp:include>
</div>
<div class="span4">
<div class=" yy_border1">
			<div class="yy_title">
				<b>学科组老师</b>
			</div>
				<div class="yy_content">
				<s:if test="#request.theJs!=null && #request.theJs.size()>0">
					<s:iterator var="theJs" value="#request.theJs" status="statu">
						<div class="js_header">
						<img src="${jstx}" class="js_header_img"/>
						<p style="margin-top:3px;">
						${jsxm }
						</p>
						</div>
					</s:iterator>
				</s:if>
				<s:else>
				暂无学科组老师信息！
				</s:else>
			</div>
		</div>
<br>
<jsp:include page="../left_comm.jsp"></jsp:include>
</div>
</div>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>
