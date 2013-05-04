<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="top.jsp"></jsp:include>

<div class="row-fluid">
	<div class="span9 yy_border">
		fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
	</div>
	<div class="span3" >
		<div id="loginPanel" name="loginPanel">
				<form class="form-signin yy_border" id="loginForm" action="back/login.aspx">
				<div class="yy_title">
					<b>登录</b>
				</div>
				<br />
				<s:if test="#session.jiaoshi==null">
					<div class="input-prepend">
						<span class="add-on">用户名</span>
						<input type="text" placeholder="Type something…" id="dlzh" name="dlzh">
					</div>
					<div class="input-prepend">
						<span class="add-on">密&nbsp;&nbsp;&nbsp;码</span> 
						<input type="password" placeholder="Type something…" id="dlmm" name="dlmm">
					</div>
					<br /> 
					<input type="submit" value="登录"	class="btn btn-mini btn-primary" > <br /> 
					<s:if test="#request.input!=null">
						用户名或密码错误${input}
					</s:if>
					<a href="#myregist" data-toggle="modal">新用户注册</a>
					<a href="#">忘记密码？</a>
				</s:if>
				
				<s:if test="#session.jiaoshi!=null">
						<img src="<s:property value="#session.jiaoshi.jstx"/>" class="js_header_img"/>
						欢迎登陆：<s:property value="#session.jiaoshi.jsxm"/><br>
					<a href="back/logout.aspx">安全退出</a> 
				</s:if>
			</form>
		</div>
		<div class="yy_border">
			<a href="#">网站公告信息网站公告信息网站公告</a> <a href="#">网站公告信息网站公告信息网站公告</a> <a
				href="#">网站公告信息网站公告信息网站公告</a>
		</div>

	</div>
</div>
<hr />
<div class="row-fluid">
	<div class="span9">
		<div class="yy_border">
			<div class="yy_title">
				<b>学科建设</b>
			</div>
			<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="row-fluid">
			<div class="span6 yy_border">
				<div class="yy_title">
					<b>项目实施</b>
				</div>
				fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
				fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			</div>
			<div class="span6 yy_border">
				<div class="yy_title">
					<b>课题研究</b>
				</div>
				fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
				fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			</div>
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>教育研究</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>优质资源</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>校本课堂</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
	</div>

	<div class="span3">
		<div class="yy_border">
			<div class="yy_title">
				<b>政策文件</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>研修动态</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>名师工作室</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>最新活动</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
		<div class="yy_border">
			<div class="yy_title">
				<b>校本课堂</b>
			</div>
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
			fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br /> fdsafdsa<br />
		</div>
		<br />
	</div>
</div>

<!-- Modal -->
<div id="myregist" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel"></h3>
	</div>
	<form class="form-horizontal" action="back/regist.aspx">
	<div class="modal-body">
		
			<div class="control-group">
				<label class="control-label" for="inputEmail">登陆账号</label>
				<div class="controls">
					<input type="text" id="dlzh" name="dlzh">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">登陆密码</label>
				<div class="controls">
					<input type="password" id="dlmm" name="dlmm">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">真实姓名</label>
				<div class="controls">
					<input type="text" id="jsxm" name="jsxm">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">任教科目</label>
				<div class="controls">
					<s:select name="rjkm" list="kmlist" listKey="xkbh"  listValue="xkmc" headerKey="0" headerValue="--请选择任教科目--"/>  
				</div>
			</div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<input type="submit" value="提交"	class="btn  btn-primary" >
	</div>
	</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>