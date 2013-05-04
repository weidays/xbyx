<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<span class="badge badge-success">教育培训</span>
		</div>
		<br/>
		<form action="${ctx}/jypx.aspx" method="post" class="form-search">
			教育培训搜索： <select name="pxlx" style="width: 100px;">
				<option value="">全部</option>
				<option value="校本培训">校本培训</option>
				<option value="继续教育">继续教育</option>
				<option value="专家培训">专家培训</option>
				<option value="外出培训">外出培训</option>
			</select> <input class="input-xlarge" id="keyword" name="keyword" type="text" />
			<div class="btn-group">
				<button type="submit" class="btn">搜索</button>
				<a href="${ctx}/jypx/uploadPage.aspx" class="btn ">上传</a>
			</div>

		</form>
		<ul class="nav nav-tabs">
			<li <s:if test="%{pxlx==null||pxpl==''}">class="active"</s:if>><a
				href="${ctx}/jypx.aspx">全部培训</a></li>
			<li <s:if test="%{pxlx=='校本培训'}">class="active"</s:if>><a
				href="${ctx}/jypx.aspx?pxlx=校本培训">校本培训</a></li>
			<li <s:if test="%{pxlx=='继续教育培训'}">class="active"</s:if>><a
				href="${ctx}/jypx.aspx?pxlx=继续教育培训">继续教育培训</a></li>
			<li <s:if test="%{pxlx=='专家培训'}">class="active"</s:if>><a
				href="${ctx}/jypx.aspx?pxlx=专家培训">专家培训</a></li>
			<li <s:if test="%{pxlx=='外出培训'}">class="active"</s:if>><a
				href="${ctx}/jypx.aspx?pxlx=外出培训">外出培训</a></li>
		</ul>
		<s:iterator value="list" id="item" status="record">
			<div class="row-fluid">
				<div class="span3 yy_grey">
					<div id="sp<s:property value='#item.pxbh'/>" style="height: 150px;">
					</div>
				</div>
				<div id="sp<s:property value='#item.pxbh'/>"></div>
				<div class="span7">
					<b><s:property value="#item.pxbt" /></b>
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:property value="#item.spjs" />
					</p>
					上传时间：
					<s:property value="#item.scsj" />
				</div>
				<div class="span1">
					<button class="btn"
						onclick="playVideo('sp<s:property value="#item.pxbh"/>','<s:property value="#item.spdz"/>');">播放</button>
				</div>
			</div>
			<hr />
		</s:iterator>
		<ul class="pager">
			<li><a href="${ctx}/jypx.aspx?pxlx=校本培训&page=${page-1}">&larr;
					上一页</a></li>
			<li><a href="${ctx}/jypx.aspx?pxlx=校本培训&page=${page+1}">下一页
					&rarr;</a></li>
		</ul>

		<jsp:include page="/pages/front/foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		var playVideo = function(id, spdz) {
			jwplayer(id).setup({
				startparam : "starttime",
				width : 225,
				height : 150,
				file : "${ctx}/upload/" + spdz
			//file: "http://localhost:8080/1367566406750.mp4?starttime=30.4"
			});
		};

		<s:iterator value="list" id="item" status="record">
		playVideo('sp<s:property value="#item.pxbh"/>',
				'<s:property value="#item.spdz"/>');
		</s:iterator>
	</script>
</body>