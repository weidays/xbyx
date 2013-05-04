<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="ie-dropdown-fix">
	<div class="row" id="header">
		<br/>
		<h2>株洲市第一中学校本研修网</h2>
	</div>
</div>
<div class="masthead" id="navigation" >
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
</div>