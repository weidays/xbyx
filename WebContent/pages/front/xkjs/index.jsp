<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%@ include file="/pages/global.jsp"%>
<script src="${ctx}/jwplayer/jwplayer.js"></script>
</head>
<body>
	<div id="wrapper" class="container">
		<jsp:include page="/pages/front/head.jsp" />
		<br />
		<div>
			<span class="badge badge-success">首页</span>
			<span class="badge badge-success">学科建设</span>
		</div>
		<hr/>
		<p>株洲市第一中学学科列表（点击学科名进入学科主页）</p>
		<s:if test="#request.xks!=null && #request.xks.size()>0">
			<s:iterator var="xk" value="#request.xks" status="statu">

				<s:if test="#statu.index==8">
					<br>
				</s:if>
						<a href="javascript:void(0)" class="btn btn-large btn-success" style="margin-left:10px; margin-top:8px;" onclick="openNewPage('${url}')">${xkmc}</a>

			</s:iterator>
		</s:if>

		<hr />
		<div class="thumbnail">
			<div style="height: 180px;">
				<div class="yy_title">
					<b> 最新集体备课</b>
				</div>
				<div class="row-fluid">
					<s:if test="#request.xkjtbks!=null && #request.xkjtbks.size()>0">
						<s:iterator var="xkjtbk" value="#request.xkjtbks" status="statu">
							<div class="thumbnail span3">
								<span
									style="color: #003399; font-size: 12pt; font-weight: bold;">
									<s:if test="%{bkmc.length()>10}">
										<s:property value="%{bkmc.substring(0,10)+'...'}" />
									</s:if> <s:else>
						${bkmc}
						</s:else>
								</span> <br> <span
									style="color: #FF6600; padding-top: 10px; display: block">
									科目：${xkmc } <font style="color: #008000;">(${bkzt})</font>
								</span> <span> 发起人：${jsxm}</span><br>
								<br>
								<button type="button" class="btn btn-small pull-right"
									data-toggle="button">查看</button>
							</div>
						</s:iterator>
					</s:if>
					<s:else>
			暂无备课信息！
		</s:else>
				</div>
			</div>
		</div>
		<br />

		<div class="row-fluid">
			<div class="span8">
				<jsp:include page="center_comm.jsp"></jsp:include>
			</div>
			<div class="span4">
				<jsp:include page="left_comm.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="/pages/front/foot.jsp"></jsp:include>
</div>




	<script type="text/javascript">
		 function  openNewPage(url){
			 window.open(url);
		 }
		
		</script>
</body>
