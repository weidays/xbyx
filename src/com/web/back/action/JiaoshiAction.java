package com.web.back.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseAction;
import com.web.back.model.Jiaoshi;
import com.web.back.service.JiaoshiService;

public class JiaoshiAction extends BaseAction
{

    private static final long serialVersionUID = -7253368493741872822L;
    @Autowired
    private JiaoshiService jiaoshiService;
    // 登录
    public String login() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try
        {
            String loginId = request.getParameter("dlzh"), password = request.getParameter("dlmm");
            String before = request.getParameter("before");
            Jiaoshi jiaoshi=jiaoshiService.loginJudge(loginId, password);
          
            if(null==jiaoshi){
                getRequest().setAttribute("input", "用户名或密码错误");
                if("1".equals(before)){
                    pw.write("用户名或密码错误");
                    return null;
                }else{
                    return INPUT;
                }
                
            }else{
                request.getSession().setAttribute("jiaoshi", jiaoshi);
                if("1".equals(before)){
                    pw.write("OK");
                    return null;
                }else{
                    return SUCCESS;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ERROR;
        }
       // return SUCCESS;
    }
    // 退出登录
    public String logout() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        try
        {
            request.getSession().removeAttribute("jiaoshi");
            return SUCCESS;
        }
        catch (Exception e)
        {
           return ERROR;
        }
        finally
        {
            
        }
    }
    
    /**
     * 教师注册
     * @return
     * @throws Exception
     */
    public String registJiaoshi() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        try
        {
            Jiaoshi js= new Jiaoshi();
                
            String dlzh = request.getParameter("dlzh");
            String dlmm = request.getParameter("dlmm");
            String jsxm=request.getParameter("jsxm");
            String rjkm=request.getParameter("rjkm");
            Integer rjkmI=Integer.parseInt(rjkm);
            
            js.setDlmm(dlmm);
            js.setDlzh(dlzh);
            js.setJsxm(jsxm);
            js.setRjkm(rjkmI);
            int x=jiaoshiService.registJiaoshi(js);
            if(x<=0){
                getRequest().setAttribute("input", "注册失败");
                return INPUT;
            }else{
                return SUCCESS;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ERROR;
        }
    }

}
