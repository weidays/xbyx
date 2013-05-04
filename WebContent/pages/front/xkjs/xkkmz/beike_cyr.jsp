<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="top.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<SCRIPT type=text/javascript src="ueditor/editor_config.js"></SCRIPT>  
<SCRIPT type=text/javascript src="ueditor/editor_all_min.js"></SCRIPT>
<script src="uploadify/jquery.uploadify.min.js"></script>
<link rel="stylesheet" type="text/css" href="uploadify/uploadify.css" />
学科建设首页 >集体备课>参与人备课
<hr style="border-top:1px solid  #868686;HEIGHT:0;" />
<div class="yy_content" >
 <s:iterator  var="beike" value="#request.beikeList" status="statu" ><!-- 此时list size 只有1 -->
		<h3 class="text-center">
			<s:property value="%{bkmc}" escape="false"/>
			</h3>
	<table	class="table table-bordered">
				<tbody>
					<tr>
						<td width="100">
							创建人：
						</td>
						<td>
							<s:property value="%{jsxm}" escape="false"/>
						</td>
					</tr>
					<tr>
						<td width="100">
							备课时间：
						</td>
						<td>
							<s:property value="%{fqsj}" escape="false"/>至<s:property value="%{jssj}" escape="false"/>
						</td>
					</tr>
					<tr>
						<td width="100">
							指定参与人：
						</td>
						<td>
							<s:iterator  var="cyr" value="cyrList" status="statu" >	
								<a href="<s:property value="%{jsbh}" />"><s:property value="%{jsxm}" /></a>
							</s:iterator>
						</td>
					</tr>
					<tr>
						<td width="100">
							所属科目：
						</td>
						<td>
							<s:property value="%{xkbh}" escape="false"/>
						</td>
					</tr>
					<tr>
						<td width="100">
							备课内容：
						</td>
						<td>
							<s:property value="%{bkms}" escape="false"/>
						</td>
					</tr>
					<tr>
						<td width="100">
							附件下载：
						</td>
						<td>
							<s:iterator  var="fj" value="fjList" status="statu" >	
								<a href="<s:property value="%{fjdz}" />"><s:property value="%{fjmc}" /></a>
							</s:iterator>
						</td>
					</tr>
					
				</tbody>
			</table>
<form class="form-horizontal" method ="post" action="xk/cyrFqbeike.aspx">
	<input type="hidden" name="bkbh" id="bkbh" value="<s:property value="%{bkbh}" />"/>
	<input type="hidden" name="fjdz" id="fjdz" />
	<input type="hidden" name="fjmc" id="fjmc" />
   <div class="control-group">
    <label class="control-label" for="inputPassword">编写备课内容：</label>
  	<div class="controls">
   	<script type="text/plain" id="bknr" name="bknr" >
            <p>备课内容</p>
    </script>
  	</div>
  	<div class="control-group">
		<label class="control-label" for="inputPassword">上传附件</label>
		<div class="controls">
			<input type="file" name="uploadify" id="file_upload" />
		</div>
	</div>
  </div>
  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-primary" data-loading-text="提交中.." ">保存</button>
    </div>
  </div>
</form>
</s:iterator>	
</div>


<jsp:include page="../../footer.jsp"></jsp:include>
   <script type="text/javascript">
        var editor_a = UE.getEditor('bknr',{
            minFrameHeight:400
        });
         $(function() {
			$('#file_upload').uploadify({
				'swf' : 'uploadify/uploadify.swf',
				'uploader' : '../uploadAction.aspx',
				'fileObjName' : 'uploadify',
				'cancelImage' : 'uploadify/uploadify-cancel.png',
				'auto' : true,
				'multi' : false,
				'buttonClass' : 'btn btn-mini',
				'buttonText' : '附件上传',
				'progressData' : 'speed',
				'height' : 20,
				'fileSizeLimit' : '500MB',
				'onUploadSuccess' : function(file, data, response) {
					var fileName = file.name;
					fileName=$('#fjmc').val()+'#'+fileName;
					$('#fjmc').val(fileName);
					var respData = $.parseJSON(data);
					var fileName = respData.fileName;
					fileName=$('#fjdz').val()+'#'+fileName;
					$('#fjdz').val(fileName);
				}
			});
		}); 
    </script>