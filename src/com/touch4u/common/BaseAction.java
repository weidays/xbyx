package com.touch4u.common;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.touch4u.common.util.JsonData;
import com.touch4u.common.util.StringUtils;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware
{

    private static final long serialVersionUID = -768164344249793369L;
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;

    public boolean isInvalid(String value)
    {
        return (value == null || value.length() == 0);
    }

    public HttpServletRequest getRequest()
    {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getResponse()
    {
        return ServletActionContext.getResponse();
    }

    public Map getApplication()
    {
        return ServletActionContext.getContext().getApplication();
    }

   

    /**
     * @param date
     * @param format yyyy-MM-dd HH:mm:ss
     * @return
     */
    public String dateToString(Date date, String format)
    {
        if (date != null)
        {
            if ("".equals(format))
            {
                format = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }

    /**
     * @param s
     * @param format yyyy-MM-dd HH:mm:ss
     * @return
     */
    public Date stringToDate(String s, String format)
    {
        try
        {
            if ((s != null) && (!s.equalsIgnoreCase("")))
            {
                if ("".equals(format))
                {
                    format = "yyyy-MM-dd HH:mm:ss";
                }
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
                java.util.Date birthday = sdf.parse(s);
                return birthday;
            }
            else
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    // 判断开始时间和结束时间是否符合逻辑
    protected boolean dateTimeCompare(String beginDate, String endDate, String format) throws Exception
    {
        if ("".equals(format))
        {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(beginDate).before(df.parse(endDate));
    }

    // 获取查询条件语句
    public String getQuerys(HttpServletRequest request)
    {
        try
        {
            StringBuffer filter;
            String param = request.getParameter("fields");
            if (param == null || "".equals(param))
            {
                return "";
            }
            String fieldsStr = StringUtils.removalQuotes(param);
            JSONArray fields = JSONArray.fromObject(fieldsStr);
            String query = request.getParameter("query");
            String or = "";
            filter = new StringBuffer();
            int i = 0;
            for (int c = fields.size(); i < c; i++)
            {
                filter.append((new StringBuilder(String.valueOf(or))).append(fields.getString(i)).append(" like '%")
                        .append(query).append("%' ").toString());
                or = " or ";
            }
            return filter.toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * 将查询列表转换为json数据 resultList 查询结果 count 结果总记录数 limit 每页记录数 obj 转换的目标对象
     */
    public String getJSonData(List resultList, int count, int limit, String obj) throws Exception
    {
        String json = null;
        if (resultList.size() > 0)
        {
            json = (new StringBuilder("{\"counts\":\"")).append(String.valueOf(count)).append("\",\"datas\":[")
                    .toString();
            json = (new StringBuilder(String.valueOf(json))).append(
                (new JsonData()).getJsonData(resultList, 0, limit, obj).toString()).append("]}").toString();
        }
        else
        {
            json = (new StringBuilder("{\"counts\":\"")).append(String.valueOf(count)).append("\",\"datas\":[]}")
                    .toString();
        }
        return json;
    }

    /**
     * 返回单个查询结果
     * 
     * @param obj
     * @return
     */
    public static String getSingleJSonData(Object obj)
    {
        if (obj == null)
        {
            return "{success:false}";
        }
        else
        {
            StringBuffer buff = new StringBuffer();
            Class<?> clazz = null;
            try
            {
                buff.append("{success:true");
                clazz = obj.getClass();
                Method declaredMethods[] = clazz.getDeclaredMethods();
                for (int i = 0; i < declaredMethods.length; i++)
                {
                    Method method = declaredMethods[i];
                    if (method.getName().indexOf("get") == 0)
                    {
                        Method domethod = clazz.getMethod(method.getName(), new Class[0]);
                        String field = method.getName().toString().substring(3).toLowerCase();
                        String rVal = domethod.invoke(obj, new Object[0]) != null ? String.valueOf(domethod.invoke(obj,
                            new Object[0])) : "";
                        rVal = rVal.replaceAll("\\\\", "\\\\\\\\");
                        rVal = rVal.replaceAll("\"", "\\\\\"");
                        rVal = rVal.replaceAll("\n", "");
                        rVal = rVal.replaceAll("\r", "");
                        buff.append((new StringBuilder(",\"")).append(field).append("\":\"").append(rVal).append("\"")
                                .toString());
                    }
                }
                return buff.append("}").toString();
            }
            catch (Exception ex)
            {
                return "{success:false,msg:\"" + ex.getMessage() + "\"}";
            }
        }
    }

    /**
     * 将所有查询列表转换为json数据 resultList 查询结果 obj 转换的目标对象
     */
    public String getAllJSonData(List resultList, String obj) throws Exception
    {
        String json = null;
        int count = resultList.size();
        if (count > 0)
        {
            json = (new StringBuilder("{\"counts\":\"")).append(String.valueOf(count)).append("\",\"datas\":[")
                    .toString();
            json = (new StringBuilder(String.valueOf(json))).append(
                (new JsonData()).getJsonData(resultList, 0, count, obj).toString()).append("]}").toString();
        }
        else
        {
            json = (new StringBuilder("{\"counts\":\"")).append(String.valueOf(count)).append("\",\"datas\":[]}")
                    .toString();
        }
        return json;
    }

    // 格式化参数 &param=value&..
    protected HashMap parseParams(String params) throws Exception
    {
        HashMap map = null;
        if (params == null || "".equals(params))
        {
            return null;
        }
        String[] temp = params.split("&");
        if (temp.length > 0)
        {
            map = new HashMap();
            for (int i = 0; i < temp.length; i++)
            {
                String[] param = temp[i].split("=");
                String key = param[0];
                if (!"".equals(key))
                {
                    if (param.length == 2)
                    {
                        map.put(key, "null".equals(param[1]) ? null : param[1]);
                    }
                    else
                    {
                        map.put(key, null);
                    }
                }
            }
        }

        return map;
    }

    public String formatMsg(String msg)
    {
        if (msg != null && !"".equals(msg))
        {
            msg = msg.replaceAll("\\\\", "\\\\\\\\");
            msg = msg.replaceAll("\"", "\\\\\"");
            msg = msg.replaceAll("\n", "");
            msg = msg.replaceAll("\r", "");
            msg = msg.replaceAll(":", " ");
            return msg;
        }
        return "";
    }

    /**
     * 去掉查询条件中的 ' ; - 字符 防止sql注入
     * 
     * @param str
     * @return
     */
    public static String replaceSql(String str)
    {
        String[] sqls = { "'", "-", ";" };
        for (String s : sqls)
        {
            str = str.replace(s, "");
        }
        return str;
    }

    /* (non-Javadoc)
     * @see org.apache.struts2.util.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */
    public void setServletContext(ServletContext context)
    {
        this.context = context;
    }

    /* (non-Javadoc)
     * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
     */
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }

    /* (non-Javadoc)
     * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
     */
    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
        
    }
    
    

  
}
