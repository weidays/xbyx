package com.web.back.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touch4u.common.object.FormObject;
import com.touch4u.common.BaseAction;
import com.touch4u.common.util.ServletTool;
import com.web.back.service.LoginService;

public class LoginAction extends BaseAction
{

    private static final long serialVersionUID = -7253368493741872822L;

    private LoginService loginService;

    private String action = "";

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public LoginService getLoginService()
    {
        return loginService;
    }

    public void setLoginService(LoginService loginService)
    {
        this.loginService = loginService;
    }

    // 登录
    public String login() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try
        {
            String loginId = request.getParameter("username"), password = request.getParameter("password");
            String imgCode = request.getParameter("imgCode");
            String code = (String) request.getSession().getAttribute("code");
            if(code==null){
                FormObject o = new FormObject();
                o.setSuccess(false);
                o.addErrors("imgCode", "验证码超时!");
                ServletTool.print(o.toJSONObject(), response);

                return null;
            }
            if (!code.equals(imgCode))
            {
                FormObject o = new FormObject();
                o.setSuccess(false);
                o.addErrors("imgCode", "验证码错误!");
                ServletTool.print(o.toJSONObject(), response);

                return null;
            }

          loginService.loginJudge(request.getRemoteAddr(), loginId, password,request,response);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            pw.write("{success:false, msg:\'" + this.formatMsg(e.getMessage()) + "\'}");
        }
        return null;
    }

    // 退出登录
    public String logout() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try
        {
            request.getSession().removeAttribute("username");
            pw.write("{success:true}");
        }
        catch (Exception e)
        {
            pw.write("{success:false}");
        }
        finally
        {
            if (pw != null)
            {
                pw.flush();
                pw.close();
            }
        }
        return null;
    }
}
