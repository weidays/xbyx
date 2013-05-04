<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico">
<title>株洲市第一中学校本研修网</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<style type="text/css">
* {	margin: 0;	padding: 0;}
body{	background-color:#FFFFFF;	text-align:center;	margin:0 auto;	padding:0px;	}
</style>
<link type="text/css" rel="stylesheet" href="css/home.css">
<link type="text/css" rel="stylesheet" href="css/jquery.galleryview-3.0-dev.css">
<script type="text/javascript"src="js/jquery-1.7.2.js"></script>
<script type="text/javascript"src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.timers-1.2.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.galleryview-3.0-dev.js"></script>
<script type="text/javascript">
<%--子菜单
$(document).ready(function(){ 
 $('#menu li').hover(function(){$(this).find('.submenu').show();},function(){  $(this).find('.submenu').hide(); });});
--%>
$(function(){
	$('#myGallery').galleryView({	
		panel_width: 580,
        panel_height: 300,
        frame_width: 100,
        frame_height: 60,
        easing: 'swing',
        show_infobar:false,
        nav_theme: 'light',
        filmstrip_position:'right',
        overlay_opacity: 0.5,
        overlay_height: 10,

	    frame_opacity:0.6//透明度
		});
});

 function thelogin(){
	alert("1");
}
</script>


</head>
<body>
<div class="allBody">
<div class="all_content">
<jsp:include page="top.jsp"></jsp:include>

<div class="img_login">
<div class="index_img">
<ul id="myGallery">
		<li><img src="images/test/1.bmp" </li>
		<li><img src="images/test/2.bmp" </li>
		<li><img src="images/test/3.bmp" </li>
		<li><img src="images/test/4.bmp" </li>
	</ul>
</div>

<div calss="indexlogin" >
<span class="label"><p>登&nbsp;  录</p></span>
<div class="username">用户名：&nbsp;&nbsp;&nbsp;&nbsp;<input />
</div>
<div class="password">
<span> 密</span>
<span style="margin:0 3 0 5px;">码：</span><input /></div>
<div> 
<input type="button" value="登录" onclick="thelogin()"></input>
</div>

<span class="label"><a>新用户注册</a><a>忘记密码</a></span>
</div>

</div>
</body>

</html>
