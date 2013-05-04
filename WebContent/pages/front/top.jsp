<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
	String ctx = pageContext.getServletContext().getContextPath();
String path=request.getContextPath();
String rootPath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/"; 
%>
<html>
<head>
<base href="<%=rootPath %>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="<%=ctx%>/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="<%=ctx%>/css/jypx.css" rel="stylesheet" media="screen">
<script src="<%=ctx%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=ctx%>/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=ctx%>/uploadify/uploadify.css" />
</head>
<body>

	<div id="container">
		<div class="masthead">
			<div class="yy_top"></div>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<li <s:if test="%{navi=='home'}">class="active"</s:if>><a
								href="index.aspx">首页</a></li>
							<li <s:if test="%{navi=='xkjs'}">class="active"</s:if>><a
								href="xkjs.aspx">学科建设</a></li>
							<li <s:if test="%{navi=='jypx'}">class="active"</s:if>><a
								href="jypx.aspx">教育培训</a></li>
							<li <s:if test="%{navi=='zysc'}">class="active"</s:if>><a
								href="zysc.aspx">资源素材</a></li>
							<li <s:if test="%{navi=='ktyj'}">class="active"</s:if>><a
								href="ktyj.aspx">课题研究</a></li>
							<li <s:if test="%{navi=='xbkc'}">class="active"</s:if>><a
								href="xbkc.aspx">校本课程</a></li>
							<li <s:if test="%{navi=='msgzs'}">class="active"</s:if>><a
								href="msgzs.aspx">名师工作室</a></li>
							<li <s:if test="%{navi=='jydt'}">class="active"</s:if>><a
								href="jydt.aspx">教研动态</a></li>
							<li <s:if test="%{navi=='zcwj'}">class="active"</s:if>><a
								href="zcwj.aspx">政策文件</a></li>
							<li <s:if test="%{navi=='ssxm'}">class="active"</s:if>><a
								href="ssxm.aspx"> 实施项目 </a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /.navbar -->
		</div>
	