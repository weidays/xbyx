package com.web.back.model;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import com.touch4u.common.object.IObject;

public class News implements IObject
{
    private int id;//

    private int xkbh;//学科编号

    private String name;//标题

    private String content;//内容
    
    private int type;//动态类型
    private Date time;//发表时间
   
    
    public int getId()
    {
        return id;
    }


    public void setId(int id)
    {
        this.id = id;
    }


    public int getXkbh()
    {
        return xkbh;
    }


    public void setXkbh(int xkbh)
    {
        this.xkbh = xkbh;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


 


    public String getContent()
    {
        return content;
    }


    public void setContent(String content)
    {
        this.content = content;
    }


    public int getType()
    {
        return type;
    }


    public void setType(int type)
    {
        this.type = type;
    }


    public Date getTime()
    {
        return time;
    }


    public void setTime(Date time)
    {
        this.time = time;
    }


    public JSONObject toJSONObject() throws JSONException
    {
        // TODO Auto-generated method stub
        return null;
    }

   



}
