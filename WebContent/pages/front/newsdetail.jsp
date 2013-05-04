<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="top.jsp"></jsp:include>
首页>
<s:if test="%{navi=='jydt'}">
教研动态
</s:if>
<s:if test="%{navi=='zcwj'}">
政策文件
</s:if>
>${news.name}
<hr />

<div class="row-fluid">
	<div class="span8">
		<div class=" yy_border">
		<table width="100%">
			<tr><td align="center">${news.name}</td></tr>
			<tr><td align="right">${news.time}</td></tr>
			<tr><td>${news.content}</td></tr>
		</table>
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
				<td><a href="${id}">${name}</a></td>
				<td align="right">${time}</td>
				</tr>
			</s:iterator>
		</s:if>
		</table>
		</div>
		<br />
	</div>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
