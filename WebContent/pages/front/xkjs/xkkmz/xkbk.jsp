<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="top.jsp"></jsp:include>
<s:property value="#session.xkmap.xkmc" />
学科建设首页 >学科博客
<hr style="border-top:2px solid  #868686;HEIGHT:0;" />

<div class="row-fluid">
	<div class="span9">
				<div class=" yy_border"  >
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
								<s:property value="%{bkbt.substring(0,25)+'...'}"  escape="false"/>
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
						<p>
						<a href="xk/xkbknr.aspx?limit=5&num=${bkbh}" style="color:#003399;">[查看全部]</a>
						</p>
						</div>

						<div class="yy_title" >
							<b>${fbsj}</b>
						</div>
					</div>
					</s:iterator>
				</s:if>
					<s:else>
			暂无学科博客信息！
			</s:else>
			</div>

		<!-- 分页 -->
					<div style="width:100%;text-align:center; ">
				<div class="pagination">
					<ul>
						<s:if test="1>=#request.currentpage">
							<li><a>上一页</a></li>
						</s:if>
						<s:else>
							<li><a
								href="xk/xkbk.aspx?limit=20&currentpage=<s:property value="#request.currentpage-1"/>">上一页</a>
							</li>
						</s:else>
						<s:if test="#request.allPage>1">
							<s:bean name="org.apache.struts2.util.Counter" id="counter">
								<s:param name="first" value="1" />
								<s:param name="last" value="#request.allPage" />
								<s:iterator status="count">
								<s:if test="#count.index+1== #request.currentpage">
								<li><a><s:property	value="#count.index+1" /> </a></li></s:if>
								<s:else>
									<li><a
										href="xk/xkbk.aspx?limit=20&currentpage=<s:property value="#count.index+1"/>"><s:property
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
								href="xk/xkbk.aspx?limit=20&currentpage=<s:property value="#request.currentpage+1"/>">下一页</a>
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
		<div class="writebkbtn" >
		
				<button type="button" class="btn btn-primary" data-toggle="button" onclick="showwirtebkdiv();">发表博客</button>
			</div>
		<br>
<jsp:include page="bkdetail_left.jsp"></jsp:include>	
	</div>
</div>
<jsp:include page="fbbk.jsp"></jsp:include>
<jsp:include page="../../footer.jsp"></jsp:include>

<script>
function showwirtebkdiv(){
	 var sWidth, sHeight; 
	 if (window.screen.availHeight > document.body.scrollHeight) 
	 { 
	 sHeight = window.screen.availHeight; 
	 } else 
	 { 
	 sHeight = document.body.scrollHeight + 20; 
	 } 

	 $('#writeblog').css({display:"block",height:sHeight});
	 getblogfl();
}
function hidewirtebkdiv(){
	 $('#writeblog').css({display:"none"});
	
}

</script>