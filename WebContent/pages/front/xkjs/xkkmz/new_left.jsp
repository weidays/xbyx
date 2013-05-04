<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<div class="yy_border">
			<div class="yy_title">
				<b> 最新集体备课</b>
			</div>
			<div style="padding-left:5px;padding-right:5px;line-height:25px;">
				<s:if test="#request.xkjtbks!=null && #request.xkjtbks.size()>0">
					<s:iterator var="xkjtbk" value="#request.xkjtbks" status="statu">
						<div style="padding-top:10px;padding-bottom:10px; padding-left:5px;   border-top:1px solid  #D7D7D7;">
							<span style="color:#003399;font-size:12pt;font-weight:bold;">
								<s:if test="%{bkmc.length()>10}">
									<s:property value="%{bkmc.substring(0,10)+'...'}" />
								</s:if> <s:else>
						${bkmc}
						</s:else> </span> <br> <span
								style="color:#FF6600; padding-top:10px;display:block">
								科目：${xkmc } <font style="color:#008000;">${bkzt}</font> </span> <span>
								发起人：${jsxm}</span><br>
							<a type="button" class="btn " href="xk/beikeDetail.aspx?bkbh=${bkbh}">查看</a>


						</div>
					</s:iterator>
				</s:if>
				<s:else>
			暂无备课信息！
		</s:else>
			</div>
		</div>