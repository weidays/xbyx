<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../../login_div.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="top.jsp"></jsp:include>
 <s:iterator  var="beike" value="#request.beikeList" status="statu" ><!-- 此时list size 只有1 -->
语文学科建设首页  >  集体备课  >  <s:property value="%{bkmc}" escape="false"/>
<hr style="border-top:2px solid  #868686;HEIGHT:0;" />
<div class="container-fluid">
	<div class="row-fluid">
	
		<div class="span12">
			<h3 class="text-center">
				<s:property value="%{bkmc}" escape="false"/>
			</h3>
			<div align="right">
				<s:if test="#session.jiaoshi==null">
						<a class="btn" href="#mylogin" data-toggle="modal">参与备课</a>
					</s:if>
					<s:else>
						<button class="btn" onClick="cyrBeike(<s:property value="%{bkbh}" />)">参与备课</button>
					</s:else>
			</div>
			
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
								<a href="upload/<s:property value="%{fjdz}" />"><s:property value="%{fjmc}" /></a>
							</s:iterator>
						</td>
					</tr>
					
				</tbody>
			</table>
		<hr style="border-top:2px solid  #868686;HEIGHT:0;" />
			
			 <s:iterator  var="beike" value="cyrList" status="statu" >
			 <h4>
				备课参与人：<s:property value="%{jsxm}" escape="false"/>
			</h4>
			<table	class="table table-bordered">
				<tbody>
					<tr>
						<td width="100">
							参与人：
						</td>
						<td>
							<s:property value="%{jsxm}" escape="false"/>
						</td>
					</tr>
					<tr>
						<td width="100">
							参与时间：
						</td>
						<td>
							<s:property value="%{cysj}" escape="false"/>至<s:property value="%{jssj}" escape="false"/>
						</td>
					</tr>
					
					<tr>
						<td width="100">
							参与备课内容：
						</td>
						<td>
							<s:property value="%{bknr}" escape="false"/>
						</td>
					</tr>
					<tr>
						<td width="100">
							附件下载：
						</td>
						<td>
							<s:iterator  var="fj" value="fjList" status="statu" >	
								<a href="upload/<s:property value="%{fjdz}" />"><s:property value="%{fjmc}" /></a>
							</s:iterator>
						</td>
					</tr>
					
				</tbody>
			</table>
			</s:iterator>
			
			</s:iterator>
		</div>
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
