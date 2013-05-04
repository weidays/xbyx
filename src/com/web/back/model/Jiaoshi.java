package com.web.back.model;

import org.json.JSONException;
import org.json.JSONObject;
import com.touch4u.common.object.IObject;

public class Jiaoshi implements IObject
{
    private int jsbh;//教师编号

    private String jsxm;//教师姓名

    private String jstx;//教师头像

    private int rjkm;//任教科目
    private int rjkmmc;//任教科目名称
    
    private String dlzh;//登陆账号
    private String dlmm;//登陆密码
  
    
    public int getJsbh()
    {
        return jsbh;
    }


    public void setJsbh(int jsbh)
    {
        this.jsbh = jsbh;
    }


    public String getJsxm()
    {
        return jsxm;
    }


    public void setJsxm(String jsxm)
    {
        this.jsxm = jsxm;
    }


    public String getJstx()
    {
        return jstx;
    }


    public void setJstx(String jstx)
    {
        this.jstx = jstx;
    }


    public int getRjkm()
    {
        return rjkm;
    }


    public void setRjkm(int rjkm)
    {
        this.rjkm = rjkm;
    }


    public int getRjkmmc()
    {
        return rjkmmc;
    }


    public void setRjkmmc(int rjkmmc)
    {
        this.rjkmmc = rjkmmc;
    }


    public String getDlzh()
    {
        return dlzh;
    }


    public void setDlzh(String dlzh)
    {
        this.dlzh = dlzh;
    }


    public String getDlmm()
    {
        return dlmm;
    }


    public void setDlmm(String dlmm)
    {
        this.dlmm = dlmm;
    }


    public JSONObject toJSONObject() throws JSONException
    {
        // TODO Auto-generated method stub
        return null;
    }

   



}
