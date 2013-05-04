<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<div class="yy_border">
			<div class="yy_title" style="padding-top:5px;padding-bottom:5px;padding-left:10px;">
				<b> 点击榜排行</b>
			</div>
			<div style="padding-left:5px;padding-right:5px;padding-bottom:10px;padding-top:10px;">
				<s:if test="#request.others!=null && #request.others.size()>0">
					<s:iterator var="others" value="#request.others" status="statu">
						<div style="padding-top:5px; padding-left:5px; ">
							<span style="color:#003399;font-size:11pt;">
								<a href="xk/xkbknr.aspx?limit=5&num=${bkbh}">
								<s:if test="%{bkbt.length()>10}">
									<s:property value="%{bkbt.substring(0,10)+'...'}" />
								</s:if> <s:else>
								${bkbt}
								</s:else> 
								</a>
								</span> <br> 


						</div>
					</s:iterator>
				</s:if>
				<s:else>
			暂无备课信息！
		</s:else>
			</div>
		</div>