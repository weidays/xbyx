<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";  
%>
<jsp:useBean id="exception" class="java.lang.Exception" scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>系统异常</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="js/ext31/resources/css/ext-all.css" />
		<link rel="stylesheet" href="js/ext31/resources/css/ext-patch.css" />
		<link rel="stylesheet" href="css/iconCls.css" />
		
		<script type="text/javascript" src="js/ext31/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="js/ext31/ext-all.js"></script>
		<script type="text/javascript" src="js/ext31/source/locale/ext-lang-zh_CN.js"></script>
	  <script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript">
		Ext.QuickTips.init();  
		var inerval;
		var timeout;
		Ext.onReady(function(){
			var p = new Ext.Panel({
	        	title: '系统错误',
	        	iconCls:'icon-grid',
	        	renderTo: 'container',
	        	//width:document.body.clientWidth,
	        	//height:document.body.clientHeight,
	        	contentEl:messages
	    	});
	    	/*timeout=window.setTimeout(retry,5000);
	    	var i=4;
	    	interval=window.setInterval(setTime,1000);
	    	function setTime(){
	    		Ext.get(time).dom.innerText=i--;
	    	}*/
			var viewport = new Ext.Viewport({
				layout:'fit',
				items:[p]
			});
	    });
    	function retry(){
    		window.history.go(-1);
    	}
    	function stop(){
    		window.clearInterval(interval);
    		window.clearTimeout(timeout);
    	}
	</script>
		<style>
		body{
			font-size: 10pt;
		}
		A{text-decoration:none}
	 	A:link {
			COLOR: blue
		}
		A:visited {
			COLOR: blue
		}
		A:hover {
			BORDER-LEFT-COLOR: #003366; BACKGROUND: #ccccff; BORDER-BOTTOM-COLOR: #003366; BORDER-TOP-COLOR: #003366; BORDER-RIGHT-COLOR: #003366
		}
	</style>
	</head>

	<body>
		<script type="text/javascript" src="js/extCommon.js"></script>
		<div id="container"></div>
		<%
			exception.printStackTrace();
		//	 session.removeAttribute("exception");  
		%>
		<center id="messages">
			<div style='background-color:#E8F5FE;position:relative;height:100%;width:100%;'>
			<div style='position:relative;top:150;'>
			
			<br>
			出错了！
			<br>
			<br>
			<div>
				<%//=exception.getMessage() == null ? "无消息" : exception
					//.getMessage()%>
				<br>
				<br>
				<%//=exception.getCause() == null ? "" : exception
					//.getCause().toString()%>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<!-- 系统将在&nbsp;
			<span id='time'>5</span>&nbsp;秒后
			<a href='javascript:retry();'>重试</a> ，点击
			<a href='javascript:stop();'>这里</a> 停止重试。 -->
			点击
			<a href='javascript:retry();'>这里</a> 重试。
			<br>
			</div>
			</div>
		</center>
	</body>
</html>
