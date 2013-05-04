<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<script type="text/javascript">
	var ctx = '<%=request.getContextPath() %>';
</script>

<script src="${ctx}/js/jquery-1.7.2.min.js"></script>
<script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/uploadify/jquery.uploadify.min.js"></script>


<link rel="stylesheet" type="text/css" href="${ctx}/uploadify/uploadify.css" />
<link rel="stylesheet" type="text/css"href="${ctx}/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="${ctx}/css/override.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/global.css" />
<link href="${ctx}/css/jypx.css" rel="stylesheet" media="screen">