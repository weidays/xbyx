<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class=" thumbnail">
			<div class="yy_title">
				<b>教研动态</b>
			</div>
				<div class="yy_content">
				<s:if test="#request.ytdt != null && #request.ytdt.size()>0">
					<s:iterator var="ytdt" value="#request.ytdt" status="statu">
						<a href="xk/newDetail.aspx?type=1&num=${id}">[${xkmc}]&nbsp;&nbsp; <s:if
								test="%{name.length()>12}">
								<s:property value="%{name.substring(0,12)+'...'}" />
							</s:if> <s:else>
						${name}
						</s:else>
				</a>
				<br>
			</s:iterator>
		</s:if>
		<s:else>
				暂无教研动态信息！
				</s:else>
	</div>
</div>
<br />
<div class="thumbnail">
	<div class="yy_title">
		<b>教研成果</b>
	</div>
	<div class="yy_content">
		<s:if test="#request.kycg!=null && #request.kycg.size()>0">
			<s:iterator var="kycg" value="#request.kycg" status="st">

						<a href="xk/newDetail.aspx?type=2&num=${id}">[${xkmc}]&nbsp;&nbsp; <s:if
								test="%{name.length()>12}">
								<s:property value="%{name.substring(0,12)+'...'}" />
							</s:if> <s:else>
						${name}
						</s:else>
				</a>
				<br>
			</s:iterator>
		</s:if>
		<s:else>
			暂无教研成果信息！
			</s:else>
	</div>
</div>