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
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider">/</span></li>
			<li><a href="#">资源素材</a> <span class="divider">/</span></li>
		</ul>
		<hr />
		分类： <a href="#" class="">全部</a> <a href="#" class="">教学设计</a> <a
			href="#" class="">优秀课件</a> <a href="#" class="">优秀案例</a> <a href="#"
			class="">课件实录</a> <a href="#" class="">教育文摘</a> <br /> 年级： <a
			href="#" class="">全部</a> <a href="#" class="">高一</a> <a href="#"
			class="">高二</a> <a href="#" class="">高三</a> <br /> 科目： <a href="#"
			class="">全部</a> <a href="#" class="">语文</a> <a href="#" class="">
			数学</a> <a href="#" class=""> 英语</a> <a href="#" class=""> 物理 </a> <a
			href="#" class=""> 化学</a> <a href="#" class="">生物</a> <a href="#"
			class=""> 政治 </a> <a href="#" class=""> 历史</a> <a href="#" class="">
			地理</a> <a href="#" class="">音乐</a> <a href="#" class="">体育</a> <a
			href="#" class=""> 美术</a> <a href="#" class="">信息</a> <a href="#"
			class="">心理</a> <a href="#" class="">通用技术</a>

		<hr />


		<jsp:include page="/pages/front/foot.jsp"></jsp:include>

	</div>