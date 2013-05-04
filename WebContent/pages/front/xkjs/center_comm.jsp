<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="thumbnail">
	<div class="yy_title">
		<b>研讨活动</b>
	</div>
	<div class="yy_content">
		<s:if test="#request.ythd!=null && #request.ythd.size()>0">
			<s:iterator var="ythd" value="#request.ythd" status="st">

				<a href="${hdbh}">[晒课]&nbsp;&nbsp; <s:if
						test="%{hdbt.length()>23}">
						<s:property value="%{hdbt.substring(0,23)+'...'}" />
					</s:if> <s:else>
						${hdbt}
						</s:else>
				</a>
						&nbsp;&nbsp; [发起人：${jsxm}]
						<br>
			</s:iterator>
		</s:if>
		<s:else>
			暂无研讨活动信息！
			</s:else>

			</div>
		</div>
		<br />
		<div class="yy_border"  >
			<div class="yy_title">
				<b>学科博客</b>
			</div>
			<div class="yy_content" >
				<s:if test="#request.xkbk!=null && #request.xkbk.size()>0">
					<s:iterator var="xkbk" value="#request.xkbk" status="statu">
					<div style="border-bottom: 2px solid #6B6B6B; padding-bottom:1px; margin-bottom:10px;">
						<div style="margin-left:10px;">
							<b style="color:#FF6600; width:20px;">${jsxm}</b> <b>发表了</b> <b><font
								style="color:#003399;">
								 <s:if	test="%{bkbt.length()>25}">
								<s:property value="%{bkbt.substring(0,25)+'...'}" />
							</s:if> <s:else>

						${bkbt}
						</s:else> 
								</font>
							</b>
						</div>
						<div style="margin-top:8px; margin-left:10px;margin-right:10px;text-indent:30px;font-size:11pt;padding-bottom:7px;">
							 <s:if	test="%{bknr.length()>170}">
								<s:property value="%{bknr.substring(0,170)+bknr.substring(170,bknr.substring(170,bknr.length()).indexOf('>')+171)+'...'}" escape="false"/>
							</s:if> <s:else>

						${bknr}
						</s:else> 
						<p><a href="xk/xkbknr.aspx?limit=5&num=${bkbh}" style="color:#003399;">[查看全部]</a></p>
						</div>


					<div class="yy_title">
						<b>${fbsj}</b>
					</div>
				</div>
			</s:iterator>
		</s:if>
		<s:else>
			暂无学科博客信息！
			</s:else>
	</div>

</div>