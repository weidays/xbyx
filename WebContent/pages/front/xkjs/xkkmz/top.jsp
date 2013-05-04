<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<% String path=request.getContextPath();
String rootPath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";  

%>
<base href="<%=rootPath %>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="css/jypx.css" rel="stylesheet" media="screen">
<link href="css/xkbk.css" rel="stylesheet" media="screen">
<script src="js/jquery-1.7.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
</style>
</head>
<body>
<jsp:include page="../../login_div.jsp"></jsp:include>
	<div id="container">
		<div class="masthead">
			<div class="yy_top" style="background: url(' <s:property value="#session.xkmap.logo_url"/>') no-repeat;"></div>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<li <s:if test="%{navi=='home'}">class="active"</s:if>><a
								href="xk/index.aspx">学科组首页</a></li>
							<li <s:if test="%{navi=='jydt'}">class="active"</s:if>><a
								href="xk/news.aspx?type=1&limit=20">
								教研动态</a></li>
							<li <s:if test="%{navi=='xkbk'}">class="active"</s:if>><a
								href="xk/xkbk.aspx?limit=20">学科博客</a></li>
							<li <s:if test="%{navi=='ythd'}">class="active"</s:if>><a
								href="zysc.aspx">研讨活动</a></li>
							<li <s:if test="%{navi=='jycg'}">class="active"</s:if>><a
								href="xk/news.aspx?type=2&limit=20">教研成果</a></li>
							<li <s:if test="%{navi=='xmsb'}">class="active"</s:if>><a
								href="xbkc.aspx">申报项目</a></li>
							<li <s:if test="%{navi=='sbfa'}">class="active"</s:if>><a
								href="msgzs.aspx">申报方案</a></li>
							<li <s:if test="%{navi=='jtbk'}">class="active"</s:if>><a
								href="xk/jtbk.aspx">集体备课</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /.navbar -->
		</div>