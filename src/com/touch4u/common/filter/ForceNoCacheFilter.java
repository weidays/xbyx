
package com.touch4u.common.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

/**
 * ForceNoCacheFilter<br>
 * 禁止缓存过滤器
 * <p>
 * @version 1.0
 * <hr>
 * 修改记录
 * <hr>
 * 修改内容: 新建
 * <hr>
 */
public class ForceNoCacheFilter implements Filter {

	public ForceNoCacheFilter() {
	}

	/**
	 * 禁止使用缓存
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		//设置不使用缓存
		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
		((HttpServletResponse) response).setHeader("Pragma", "no-cache");
		((HttpServletResponse) response).setDateHeader("Expires", -1L);
		
		//
		filterChain.doFilter(request, response);
	}

	public void destroy() {
	}

	public void init(FilterConfig filterconfig) throws ServletException {
	}
}