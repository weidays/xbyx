<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../top.jsp"></jsp:include>
首页>教研动态
<hr />
<<s:debug></s:debug>

<div class="row-fluid">
	<div class="span8">
		<div class=" yy_border">
		<table width="100%">
		<s:if test="#request.jycgList!=null && #request.jycgList.size()>0">
			<s:iterator var="jycg" value="#request.jycgList" status="statu">
				<tr>
				<td><a href="dtDetail.aspx?dtbh=${id}&navi=jydt">${name}</a></td>
				<td align="right">${time}</td>
				</tr>
			</s:iterator>
		</s:if>
		</table>
		</div>
		<div class="pagination pagination-right">
		  <ul>
		 
		    <s:if test="#request.cgcurrentpage != 1">
				<li><a href=jydt.aspx?cgcurrentpage=<s:property value="#request.cgcurrentpage-1"/>>上一页</a></li>
			</s:if>
			<s:bean name="org.apache.struts2.util.Counter" id="counter"> 
				<s:param name="first" value="1" /> 
				<s:param name="last" value="#request.cgtotalpage"/> 
				<s:iterator> 
					<li><a href=jydt.aspx?cgcurrentpage=<s:property/>><s:property/></a></li>
				</s:iterator>
			</s:bean>
			
			<s:if test="#request.cgcurrentpage != #request.cgtotalpage">
				<li><a href=jydt.aspx?cgcurrentpage=<s:property value="#request.cgcurrentpage+1"/>>下一页</a></li>
			</s:if>
		    
		  </ul>
		</div>
	</div>
	<div class="span4">
		<div class=" yy_border">
			<div class="yy_title">
				<b>教研动态</b>
			</div>
			<table width="100%">
		<s:if test="#request.jydtList!=null && #request.jydtList.size()>0">
			<s:iterator var="jydt" value="#request.jydtList" status="statu">
				<tr>
				<td><a href="dtDetail.aspx?dtbh=${id}&navi=jydt">${name}</a></td>
				<td align="right">${time}</td>
				</tr>
			</s:iterator>
		</s:if>
		</table>
		</div>
		<!-- 分页实现 -->
		<div class="pagination pagination-right">
		  <ul>
		 
		    <s:if test="#request.dtcurrentpage != 1">
				<li><a href=jydt.aspx?dtcurrentpage=<s:property value="#request.dtcurrentpage-1"/>>上一页</a></li>
			</s:if>
			<s:bean name="org.apache.struts2.util.Counter" id="counter"> 
				<s:param name="first" value="1" /> 
				<s:param name="last" value="#request.dttotalpage"/> 
				<s:iterator> 
					<li><a href=jydt.aspx?dtcurrentpage=<s:property/>><s:property/></a></li>
				</s:iterator>
			</s:bean>
			
			<s:if test="#request.dtcurrentpage != #request.dttotalpage">
				<li><a href=jydt.aspx?dtcurrentpage=<s:property value="#request.dtcurrentpage+1"/>>下一页</a></li>
			</s:if>
		    
		  </ul>
		</div>
		<br />
	</div>
</div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
