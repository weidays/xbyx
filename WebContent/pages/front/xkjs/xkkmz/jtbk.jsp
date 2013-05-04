<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="../../login_div.jsp"></jsp:include>
学科建设首页 >集体备课
<hr style="border-top:1px solid  #868686;HEIGHT:0;" />
<s:if test="#session.jiaoshi==null">
	<a class="btn" href="#mylogin" data-toggle="modal">我要备课</a>
</s:if>
<s:else>
	<a class="btn" href="xk/toBeike.aspx">我要备课</a>
</s:else>
<hr style="border-top:2px solid  #868686;HEIGHT:0;" />
<div class="yy_content" >
 <s:iterator  var="beike" value="#request.beikeList" status="statu" >
		<div class="row-fluid  yy_border">
				<div class="span9" >
					<table height="100%" class="table">
						<tr><td><s:property value="%{bkmc}" /></td></tr>
						<tr><td>
						<div>
						<s:if test="%{bkms.length()>500}">
							<s:property value="%{bkms.substring(0,500)+'...'}" escape="false"/>
							</s:if>
							<s:else>
							<s:property value="%{bkms}" escape="false"/>
							</s:else>
						</div>
						</td>
						</tr>
						<tr><td>
					 	<s:iterator  var="fj" value="fjList" status="statu" >	
							<a href="upload/<s:property value="%{fjdz}" />"><s:property value="%{fjmc}" /></a>
						</s:iterator>
						</td></tr>
					</table>
					<hr>
					<table height="100%" class="table table-bordered">
						<tr><td>创建人：<s:property value="%{jsxm}" />  创建时间：<s:property value="%{fqsj}" /></td></tr>
						<tr><td>参与人：
						<s:iterator  var="cyr" value="cyrList" status="statu" >	
							<a href="<s:property value="%{fjdz}" />"><s:property value="%{jsxm}" /></a>
						</s:iterator>
						</td></tr>
					</table>
				</div>
				<div class="span3" >
					<a href="xk/beikeDetail.aspx?bkbh=<s:property value="%{bkbh}" escape="false"/>" class="btn">查看</a>
					
					<s:if test="#session.jiaoshi==null">
						<a class="btn" href="#mylogin" data-toggle="modal">参与备课</a>
					</s:if>
					<s:else>
						<button class="btn" onClick="cyrBeike(<s:property value="%{bkbh}" />)">参与备课</button>
					</s:else>
										
				</div>
			</div>
 </s:iterator>
	<!-- 分页 -->
		<div class="pagination pagination-center">
		  <ul>
		    <s:if test="#request.dtcurrentpage != 1">
				<li><a href=xk/jtbk.aspx?dtcurrentpage=<s:property value="#request.dtcurrentpage-1"/>>上一页</a></li>
			</s:if>
			<s:bean name="org.apache.struts2.util.Counter" id="counter"> 
				<s:param name="first" value="1" /> 
				<s:param name="last" value="#request.dttotalpage"/> 
				<s:iterator> 
					<li><a href=xk/jtbk.aspx?dtcurrentpage=<s:property/>><s:property/></a></li>
				</s:iterator>
			</s:bean>
			<s:if test="#request.dtcurrentpage != #request.dttotalpage">
				<li><a href=xk/jtbk.aspx?dtcurrentpage=<s:property value="#request.dtcurrentpage+1"/>>下一页</a></li>
			</s:if>
		  </ul>
		</div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>

<script type="text/javascript">
function cyrBeike(bkbh){
	$.ajax({
		  url: "xk/cyrbeike.aspx",
		  data:"bkbh="+bkbh+"&before=1",
		  cache: false,
		  success: function(html){
			 
			  if(html.indexOf("youshouldjoinfirst")!=-1){
				  alert("对不起你不在此备课制定参与人中");
			  }else{
				  window.location.href="xk/cyrbeike.aspx?bkbh="+bkbh+"";
			  }
		  }
		});
}
</script>