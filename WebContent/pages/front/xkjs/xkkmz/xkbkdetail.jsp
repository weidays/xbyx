<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<jsp:include page="top.jsp"  ></jsp:include>
<s:property value="#session.xkmap.xkmc" />学科建设首页 >学科博客
<s:if test="#request.oneMap!=null ">
			><s:property value="#request.oneMap.bkbt" />
	
</s:if>
<hr style="border-top:2px solid  #868686;HEIGHT:0;" />
<input value="5" type="hidden" id="limit"/>
<div class="row-fluid">
	<div class="span9">
			<s:if test="#request.oneMap!=null ">
			<div class="new_title">
			<s:property value="#request.oneMap.bkbt" />
			<label ><s:property value="#request.oneMap.fbsj" /></label>
			<p><s:property value="#request.oneMap.bknr" escape="false"/> </p>
			</div>
						
						
			</s:if>
	
<!-- 发表回复 -->
	<div class="repaly">
		
	<ul class="breadcrumb">
 <li class="active"><b>评论</b></li>
</ul>
<form action="xk/replay.aspx">
	<textarea class="repalyarea" name="replayArea" id="replayArea"></textarea>
	
	<div class="replaybtn">
		<button type="button" class="btn btn-primary" data-toggle="button" onclick="submitfrom(0,<s:property value="#request.num" />,'#replayArea',0)">发表</button>	
	</div>
</form>
	<!-- 回复 -->
	<hr style="border-top:1px solid  #999999;HEIGHT:0;" />
	<div id="allreplay">
	
	</div>
	</div>
	</div>
	<div class="span3">
		<div class="bkname" >
				<b> <s:property value="#request.oneMap.jsxm" />的个人博客</b>
			</div>
		<br>
<jsp:include page="bkdetail_left.jsp"></jsp:include>
	</div>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>
<script type="text/javascript">

$(function(){
	loadreplay(0,1);
});
function reloadreplay(){
	$('#limit').val(10);
	//document.getElementById('lookallbtn').style.display = "none";
	loadreplay(0,1);
}
function changePage(currentpage){
	var start=$('#start').val();
	loadreplay(start,currentpage);
}
function loadreplay(start,currentpage){
	var limit=$('#limit').val();
	$.post("xk/getReplay.aspx",{"start":start,"limit":limit,"num":<s:property value="#request.num" />,"currentpage":currentpage},function(data){
		$('#allreplay').html(data);
		showpage(limit);
	});
}
function submitfrom(replayId,num,areaid,superReplayId){
	var limit=$('#limit').val();
	var replayvalue=$(areaid).val();
	$(areaid).val('');
	$.post("xk/replay.aspx",{"limit":limit,"replayId":replayId,"num":num,"replayArea":replayvalue,"superReplayId":superReplayId},function(data){
		$('#allreplay').html(data);
		showpage(limit);
	});
}
function showpage(limit){
	if(limit==10){
	$('#lookallbtn').css({display:"none"});
	$('#pagespitid').css({display:"block"});
	}
}
 function showRepalyDiv(hfbh,num,superReplayId){
	 if(superReplayId<=0){
		 superReplayId=hfbh;
	 }
	 
	 
	 var id="#replayadd"+hfbh;
	 var inner="<form action=\"#\" id=\"replayfrom\">"
		+"<textarea class=\"repalyarea\" id=\"replayAreason\"></textarea>"
		+"<div class=\"replaybtn\">"
		+"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"submitfrom("+hfbh+","+num+",'#replayAreason',"+superReplayId+" );\">评论</button>	"
		+"</div></form>";
		$("div[id^='replayadd']").each(function(i,val){ 
		      $(val).html("");
		  });   
		$(id).html(inner);
		var btnid='relpaybtn'+hfbh;
		
		$("div[id^='relpaybtn']").each(function(i,val){ 
			if(val.id==btnid){
				$('#'+btnid).css({display:"none"});
			}else{
				$('#'+val.id).css({display:"block"});
			}
		  });
		
 }
 


</script>
