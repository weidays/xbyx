package com.touch4u.common.filter;
import java.io.IOException;  
import javax.servlet.FilterChain;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;  
public class Filter4UE extends StrutsPrepareAndExecuteFilter {  
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest request = (HttpServletRequest) req;  
        //不过滤的url  
        String url = request.getRequestURI();  
        if ("/xbyx/ueditor/jsp/imageUp.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/fileUp.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/getContent.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/getContent.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/getMovie.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/getRemoteImage.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/scrawlUp.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else if ("/xbyx/ueditor/jsp/imageManager.jsp".equals(url)) {  
            chain.doFilter(req, res);  
        }else{  
            super.doFilter(req, res, chain);  
        }  
    }  
}