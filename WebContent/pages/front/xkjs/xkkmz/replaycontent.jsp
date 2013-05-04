 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<s:if test="#request.news!=null && #request.news.size()>0">
	<s:iterator var="news" value="#request.news" status="statu">
		<table width="100%">
		<tr class="replayline">
		<td width="60px" valign="top" class="repalytd">
				<img src="${jstx }" style="width:40px; height:40px" > 
		</td>
		<td width="90%"  class="repalytd">
				<div >
				<div class="span8">
						<a href="javascript:void(0);"> ${jsxm }</a>
					</div>
					<div class="span4" style="text-align:right;">时间：${hfsj}</div>
				</div>
				<div class="replaycontent">${hfnr }</div>
				<div style="padding-top:20px;" id="relpaybtn${hfbh }">
					<span class="replaybtn"> <a  href="javascript:void();"
						onclick="showRepalyDiv('${hfbh }','<s:property value="#request.num" />',${superhfbh })">回复</a>
					</span>
				</div>
				<div id="replayadd${hfbh }"></div>
				<div class="replaycontent">
					<s:if test="sonnews!=null && sonnews.size()>0">
						<s:iterator var="news" value="sonnews" status="sta">
						<table>
						<tr style="border-top:1px dotted   #868686;">
						<td width="60px" valign="top" align="left"  class="repalytd">
								<img src="${jstx }" style="width:40px; height:40px" > 
						</td>
						<td width="92%"  class="repalytd">
						<div>
									<div class="span8"><a href=""> ${sonjsxm } </a> 回复: <a href="">${jsxm } </a></div>
									<div class="span4" style="text-align:right;">时间:${sonHFSJ }</div>
						</div>
										<div class="replaycontent">${hfnr }</div>
				<div style="padding-top:20px;display:bolck;" id="relpaybtn${hfbh }">
					<span class="replaybtn"> <a href="javascript:void();"
						onclick="showRepalyDiv('${hfbh }','<s:property value="#request.num" />',${superhfbh })">回复</a>
					</span>
					
				</div>
				
							</td>
							</tr>
							<tr>
							<td colspan="2">
							
							<div id="replayadd${hfbh }"></div>
							</td>
							</tr>
							</table>
						</s:iterator>
					</s:if>
				</div>
		</td>
		</tr>
	</table>
	</s:iterator>


<!-- 显示全部 和分页 -->
	<div class="lookallbtn" id="lookallbtn"><a href="javascript:void();" onclick="reloadreplay()">查看全部</a> </div>
	<input type="hidden" id="start" value="${#request.start }"/>
	<div style="width:100%;text-align:center; display:none" id="pagespitid">
				<div class="pagination">
					<ul>
						<s:if test="1>=#request.currentpage">
							<li><a>上一页</a></li>
						</s:if>
						<s:else>
							<li><a	href="javascript:viod(0);" onclick="changePage(<s:property value="#request.currentpage -1"/>)">上一页</a>
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
								<li>
								<a	href="javascript:viod(0);" onclick="changePage(<s:property value="#count.index+1" />)"><s:property
												value="#count.index+1" /> </a></li>
								</s:else>
									
								</s:iterator>
							</s:bean>

						</s:if>
						<s:else>
						<li><a>1</a></li>
						</s:else>
						<s:if test="#request.allPage>#request.currentpage">
							<li>
							<a	href="javascript:viod(0);" onclick="changePage(<s:property value="#request.currentpage+1"/>)">
							下一页</a>
							</li>
						</s:if>
						<s:else>
							<li><a>下一页</a></li>
						</s:else>
					</ul>
				</div>
</div>
</s:if>
<s:else>
	暂无回复信息！
	</s:else>
</div>
</div>