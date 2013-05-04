<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Modal -->
<div id="mylogin" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel"></h3>
	</div>
	<form class="form-horizontal" >
	<div class="modal-body">
			<input type="hidden" id="before" name="before" value="1"/>
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
			<div id="results"></div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<button type="button" value="提交"	class="btn  btn-primary"  onClick="tologin()">提交</button>
	</div>
	</form>
	
</div>
<script type="text/javascript">
function tologin(){
	var dlzh=$('#dlzh').val();
	var dlmm=$('#dlmm').val();
	$.ajax({
		  url: "back/login.aspx",
		  data:"dlzh="+dlzh+"&dlmm="+dlmm+"&before=1",
		  cache: false,
		  success: function(html){
			 
			  if(html=="OK"){
				  location.reload();
			  }else{
		   		 $("#results").append(html);
			  }
		  }
		});
}
</script>