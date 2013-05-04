<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%@ include file="/pages/global.jsp"%>
</head>
<body>
	<div id="wrapper" class="container">
		<jsp:include page="/pages/front/head.jsp" />
		<br/>
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider">/</span></li>
			<li><a href="#">教育培训</a> <span class="divider">/</span></li>
			<li><a href="#">上传培训</a> <span class="divider">/</span></li>
		</ul>
		<hr />
		<form class="form-horizontal row">
		<div class="control-group">
			<label class="control-label" for="inputPassword">视频上传</label>
			<div class="controls">
				<input type="file" name="uploadify" id="file_upload" />
				<!-- <div class="progress input-xxlarge">
						<div class="bar" class="" style="width: 60%;"></div>
					</div> -->
			</div>
		</div>
		</form>
		<form class="form-horizontal row" action="${ctx}/jypx/save.aspx" method="post">
			<input type="hidden" name="jypx.spdz" id="inputSpdz" />
			<div class="control-group">
				<label class="control-label" for="inputEmail">培训标题</label>
				<div class="controls">
					<input name="jypx.pxbt" class="input-xxlarge" type="text"
						id="inputPxbt">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">培训类型</label>
				<div class="controls">
					<select class="input-xxlarge" name="jypx.pxlx">
						<option value ="校本培训">校本培训</option>
						<option value ="继续教育培训">继续教育培训</option>
						<option value ="专家培训">专家培训</option>
						<option value ="外出培训">外出培训</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">视频介绍</label>
				<div class="controls">
					<textarea name="jypx.spjs" class="input-xxlarge" rows="5"></textarea>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<center>
						<button type="submit" class="pull-right btn btn-large btn-primary">提交</button>
					</center>
				</div>
			</div>
		</form>
		<jsp:include page="/pages/front/foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#file_upload').uploadify({
				'swf' : '${ctx}/uploadify/uploadify.swf',
				'uploader' : '${ctx}/uploadAction.aspx',
				'fileObjName' : 'uploadify',
				'cancelImage' : '${ctx}/uploadify/uploadify-cancel.png',
				'auto' : true,
				'multi' : false,
				'buttonClass' : 'btn btn-mini',
				'buttonText' : '上传视频',
				'progressData' : 'speed',
				'height' : 20,
				'fileSizeLimit' : '500MB',
				'onUploadSuccess' : function(file, data, response) {
					var fileName = file.name;
					$('#inputPxbt').val(fileName);
					var respData = $.parseJSON(data);
					var fileName = respData.fileName;
					$('#inputSpdz').val(fileName);
				}
			// Put your options here
			});
		});
	</script>
</body>