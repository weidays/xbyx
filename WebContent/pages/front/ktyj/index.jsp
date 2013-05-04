<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../top.jsp"></jsp:include>
首页>课题研究
<hr />


课题研究搜索：
<div class="input-prepend">

	<div class="btn-group">
		<button class="btn dropdown-toggle" data-toggle="dropdown">
			全部 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">校级课题</a></li>
			<li><a href="#">市级课题</a></li>
			<li><a href="#">省级课题</a></li>
			<li><a href="#">国家级课题</a></li>
		</ul>
		<input class="span2" id="prependedDropdownButton" type="text">
		<button type="submit" class="btn">Search</button>
	</div>
	<a href="#myModal" role="button" class="btn" data-toggle="modal">申请课题</a>
</div>

<ul class="nav nav-tabs">
	<li class="active"><a href="#">全部课题</a></li>
	<li><a href="#">校级课题</a></li>
	<li><a href="#">市级课题</a></li>
	<li><a href="#">省级课题</a></li>
	<li><a href="#">国家级课题</a></li>
</ul>
<p>培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息培训视频描述信息...
	[查看全部]</p>
<div class="pagination pagination-right">
	<ul>
		<li><a href="#">«</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">»</a></li>
	</ul>
</div>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">上传培训视频</h3>
	</div>
	<div class="modal-body">
		<form class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="inputEmail">培训标题</label>
				<div class="controls">
					<input type="text" id="inputEmail">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">视频介绍</label>
				<div class="controls">
					<input type="password" id="inputPassword">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">培训类型</label>
				<div class="controls">
					<textarea rows="5"></textarea>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<button class="btn btn-primary">提交</button>
	</div>
</div>


<jsp:include page="../footer.jsp"></jsp:include>