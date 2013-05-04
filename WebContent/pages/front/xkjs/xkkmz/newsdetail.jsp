<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="top.jsp"></jsp:include>
<s:property value="#session.xkmap.xkmc" />
学科建设首页 >
<s:if test="#request.type==1">
教研动态
</s:if>
<s:elseif test="#request.type==2">
教研成果
</s:elseif>
>
<s:if test="#request.onenew!=null ">
			<s:property value="#request.onenew.name" />
	
</s:if>
<s:else>
详细内容
</s:else>
<hr style="border-top:2px solid  #868686;HEIGHT:0;" />

<div class="row-fluid">
	<div class="span9">
			<s:if test="#request.onenew!=null ">
			<div class="new_title">
			<s:property value="#request.onenew.name" />
			<label ><s:property value="#request.onenew.time" /></label>
			<p><s:property value="#request.onenew.content" /> </p>
			</div>
						
						
			</s:if>
			
	</div>
	<div class="span3">
<jsp:include page="new_left.jsp"></jsp:include>
	</div>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>

