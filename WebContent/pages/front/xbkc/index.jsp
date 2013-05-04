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
	<div  id="wrapper" class="container">
		<jsp:include page="/pages/front/head.jsp" />
		<br />
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider">/</span></li>
			<li><a href="#">校本课程</a> <span class="divider">/</span></li>
		</ul>


		<form action="${ctx}/xbkc.aspx" method="post"  class="form-search">
			校本课程搜索：<input  class="input-xlarge" id="keyword" name="keyword" type="text" />
			<div class="btn-group">
				<button type="submit" class="btn">搜索</button>
				<a href="${ctx}/xbkc/uploadPage.aspx" class="btn ">上传</a>
			</div>
		</form>
		<hr/>
		<s:iterator value="list" id="item" status="record">
			<div class="row-fluid">
				<div class="span3 yy_grey">
					<div id="sp<s:property value='#item.kcbh'/>" style="height: 150px;">
					</div>
				</div>
				<div id="sp<s:property value='#item.kcbh'/>"></div>
				<div class="span7">
					<b><s:property value="#item.kcbt" /></b>
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:property value="#item.spjs" />
					</p>
					上传时间：
					<s:property value="#item.scsj" />
				</div>
				<div class="span1">
					<button class="btn"
						onclick="playVideo('sp<s:property value="#item.kcbh"/>','<s:property value="#item.spdz"/>');">播放</button>
				</div>
			</div>
			<hr />
		</s:iterator>
		<ul class="pager">
			<li class="previous"><a
				href="${ctx}/xbkc.aspx?page=${page-1}">&larr; 上一页</a></li>
			<li class="next"><a
				href="${ctx}/xbkc.aspx?page=${page+1}">下一页 &rarr;</a></li>
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
		playVideo('sp<s:property value="#item.kcbh"/>',
				'<s:property value="#item.spdz"/>');
		</s:iterator>
	</script>
</body>