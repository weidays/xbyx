package com.web.back.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touch4u.common.object.FormObject;
import com.touch4u.common.util.ServletTool;
import com.web.back.dao.UserDaO;

public class LoginService 
{
    private UserDaO userDaO;

    public void setUserDaO(UserDaO userDaO)
    {
        this.userDaO = userDaO;
    }




    /**
     *function:登录验证
     * 
     *@param session
     *@param search
     *@author
     */
    public void loginJudge(String ipAddr, String userId, String password, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        List list = userDaO.getUserbyUserId(userId);
        // 用户不存在
        if (null == list || list.size() < 1)
        {
            FormObject o = new FormObject();
            o.setSuccess(false);
            o.addErrors("username", "用户名不存在！");
            ServletTool.print(o.toJSONObject(), response);
        }
        else
        {
            String pwd = "" , userName = "";
            for (int i = 0; i < list.size(); i++)
            {
                Map user = (Map) list.get(i);
                pwd = user.get("password").toString();
                userName = user.get("user_name").toString();
            }
            if (!password.equals(pwd))
            {
                FormObject o = new FormObject();
                o.setSuccess(false);
                o.addErrors("password", "密码错误！");
                ServletTool.print(o.toJSONObject(), response);
            }
            else
            {
                request.getSession().removeAttribute(userId);
                request.getSession().setAttribute("username", userName);
                FormObject o = new FormObject();
                o.setSuccess(true);
                ServletTool.print(o.toJSONObject(), response);
            }
        }

    }

}
