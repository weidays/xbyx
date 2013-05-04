<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<SCRIPT type=text/javascript src="ueditor/editor_config.js"></SCRIPT>  
<SCRIPT type=text/javascript src="ueditor/editor_all.js"></SCRIPT>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="writeblog" id="writeblog">
<div class="writeblogcontent">
 <form action="#" class="form-horizontal" id="writeblogfrom">
 <div class="control-group">
    <label class="control-label" for="inputEmail" style="width:130px;">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题</label>
    <div class="controls" style="text-align:left;">
      <input type="text" id="inputTitle" >
    </div>
      </div>
   <div class="control-group">
    <label class="control-label" for="inputEmail"  style="width:130px;">博客内容</label>
    <div class="controls">
       <div id="nreditor" >
       
       </div>
    </div>
      </div>
 </form>
<div class="row-fluid">
 <div class="span7" style="padding-left:180px;text-align:left;">
 <select style="width:140px;" >
 <option>允许所有人评论</option>
 </select>
 <select id="flselect" style="width:120px;">
 
 </select>
 <a href="javascript:void(0)" onclick="addflshow()"> 创建分类</a>
 </div>
 <div class="span5" style="padding-right:118px;text-align:right;">
 <select style="width:120px;" id="stateselect">
 <option value="1">立即发布</option>
 <option value="0">草稿</option>
 </select>
 </div>
</div>
 
 <div><button class="btn" onclick="submitBlog()">发表</button><button class="btn" onclick="hidewirtebkdiv()">取消</button></div>
 
</div>
<div id="addfldiv" class="addfldiv">
<div class="addfldiv_son">
 分类名称：<input type="text"  id="fltext">
 <div>
 <button class="btn" onclick="addfl()">保存</button><button class="btn" onclick="addflhide()">取消</button>
 </div>
</div>
</div>
</div>
<script type="text/javascript"  >
  var editor = new UE.ui.Editor({initialFrameWidth:850});
editor.render("nreditor");
editor.ready(function(){editor.setContent("");})
function submitBlog(){
	var params={"title":$('#inputTitle').val(),"replayArea":editor.getContent(),"type":$('#flselect').val(),"state":$('#stateselect').val()};
	$.post("xk/writeBlog.aspx",params,function(data){
		alert(2);
		window.location.href="xkbk.aspx?limit=20";
	});
}
//-- 查询博客分类--%>
function getblogfl(){
	$.post("xk/queryFl.aspx",{},function(data){
		$("#flselect ").empty();
		$.each(data.root,function(i,val){
			
			if(val.type==0){
				$('#flselect').append("<option selected value='"+val.flbh+"'>"+val.flmc+"</option>"); 
			}else{
			$('#flselect').append("<option value='"+val.flbh+"'>"+val.flmc+"</option>"); 
			}
		});
	});
}

function addflshow(){
	$('#addfldiv').css({display:"block"})
}
function addflhide(){
	$('#addfldiv').css({display:"none"})
}
function addfl(){
	$.post("xk/saveFl.aspx",{"title":$('#fltext').val()},function(data){
		addflhide();
		getblogfl();
	});
}
    </script>