package com.touch4u.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter
{

    public void destroy()
    {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String username = (String) session.getAttribute("username");
        String servletPath = httpRequest.getServletPath();
       
            if (servletPath.startsWith("/pages/back")||servletPath.startsWith("/back")||servletPath.endsWith("main.jsp"))//判断是否是后台程序
            { 
                if (username == null){//为后台但是没有登录的时候
               
                        httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
                        return;
            }
           
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig chain) throws ServletException
    {

    }

}