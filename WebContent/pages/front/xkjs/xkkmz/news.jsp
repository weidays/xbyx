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
<hr style="border-top:2px solid  #868686;HEIGHT:0;" />

<div class="row-fluid">
	<div class="span9">
		<div style="">
			<s:if test="#request.news!=null && #request.news.size()>0">
				<table width="100%">
					<s:iterator var="news" value="#request.news" status="statu">
						<tr>
							<td style="padding-left:5px;padding-bottom:10px;">
							<a href="xk/newDetail.aspx?type=<s:property value="#request.type"/>&num=${id}">

									<s:if test="%{name.length()>38}">
										<s:property value="%{name.substring(0,38)+'...'}" />
									</s:if> <s:else>
						${name}
						</s:else> </a></td>
							<td align="right" width="120px;">${time}</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			
			<!-- 分页 -->
			<div style="width:100%;text-align:center; ">
				<div class="pagination">
					<ul>
						<s:if test="1>=#request.currentpage">
							<li><a>上一页</a></li>
						</s:if>
						<s:else>
							<li><a
								href="xk/news.aspx?type=<s:property value="#request.type"/>&limit=20&currentpage=<s:property value="#request.currentpage-1"/>">上一页</a>
							</li>
						</s:else>
						<s:if test="#request.allPage>1">
							<s:bean name="org.apache.struts2.util.Counter" id="counter">
								<s:param name="first" value="1" />
								<s:param name="last" value="#request.allPage" />
								<s:iterator status="count">
								<s:if test="#count.index+1== #request.currentpage">
								<li><a><s:property value="#count.index+1" /> </a></li>
								</s:if>
								<s:else>
								<li><a
										href="xk/news.aspx?type=<s:property value="#request.type"/>&limit=20&currentpage=<s:property value="#count.index+1"/>"><s:property
												value="#count.index+1" /> </a></li>
								</s:else>
									
								</s:iterator>
							</s:bean>

						</s:if>
						<s:else>
						<li><a>1</a></li>
						</s:else>
						<s:if test="#request.allPage>#request.currentpage">
							<li><a
								href="xk/news.aspx?type=<s:property value="#request.type"/>&limit=20&currentpage=<s:property value="#request.currentpage+1"/>">下一页</a>
							</li>
						</s:if>
						<s:else>
							<li><a>下一页</a></li>
						</s:else>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="span3">
	
<jsp:include page="new_left.jsp"></jsp:include>	
	</div>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>

