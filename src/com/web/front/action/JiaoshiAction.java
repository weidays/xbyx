package com.web.front.action;
/**
 * 教师相关
 */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.touch4u.common.BaseAction;
import com.touch4u.common.util.JSONFormat;
import com.touch4u.common.util.ServletTool;

public class JiaoshiAction extends BaseAction
{
    private static final long serialVersionUID = -7253368493741872822L;
    /**
     *  前往录入界面
     * @return
     * @throws Exception
     */
    public String toRegistPage() throws Exception
    {
        return SUCCESS;
    } 

    
    /**
     *  根据学科获取教师
     * @return
     * @throws Exception
     */
    public String getJiaoshibyXueke() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try
        {
          //List list = jypxService.getMenus(Integer.parseInt("100"));
           List list=new ArrayList();
           ServletTool.print(JSONFormat.toJSONArray(list), response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            pw.write("{success:false, msg:\'" + this.formatMsg(e.getMessage()) + "\'}");
        }
        return null;
    }
    /**
     * 获取所有教师
     * @return
     * @throws Exception
     */
    public String getJiaoshi() throws Exception
    {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        getResponse().setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        try
        {
          //List list = jypxService.getMenus(Integer.parseInt("100"));
           List list=new ArrayList();
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

