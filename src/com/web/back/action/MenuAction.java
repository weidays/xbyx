package com.web.back.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touch4u.common.BaseAction;
import com.touch4u.common.util.JSONFormat;
import com.touch4u.common.util.ServletTool;
import com.web.back.service.MenuService;

public class MenuAction extends BaseAction
{
    private static final long serialVersionUID = -7253368493741872822L;

    private MenuService menuService;

    public MenuService getMenuService()
    {
        return menuService;
    }

    public void setMenuService(MenuService menuService)
    {
        this.menuService = menuService;
    }

    // 登录
    public String menu() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try
        {
           List list = menuService.getMenus(Integer.parseInt("100"));
           ServletTool.print(JSONFormat.toJSONArray(list), response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            pw.write("{success:false, msg:\'" + this.formatMsg(e.getMessage()) + "\'}");
        }
        return null;
    }
}

