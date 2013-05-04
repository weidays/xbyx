package com.web.back.model;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import com.touch4u.common.object.IObject;

public class Jypx implements IObject
{
    private int pxbh;//培训编号

    private String pxbt;//培训标题

    private String spjs;//视频介绍

    private Date scsj;//上传时间
    
    private int scrbh;//上传人编号
    private String scrxm;//上传人姓名
    private String spdz;//视频地址
    private String jtdz;//截图机制
    
    private String pxlx;//培训类型

    public int getPxbh()
    {
        return pxbh;
    }

    public void setPxbh(int pxbh)
    {
        this.pxbh = pxbh;
    }

    public String getPxbt()
    {
        return pxbt;
    }

    public void setPxbt(String pxbt)
    {
        this.pxbt = pxbt;
    }

    public String getSpjs()
    {
        return spjs;
    }

    public void setSpjs(String spjs)
    {
        this.spjs = spjs;
    }

    public Date getScsj()
    {
        return scsj;
    }

    public void setScsj(Date scsj)
    {
        this.scsj = scsj;
    }

    public int getScrbh()
    {
        return scrbh;
    }

    public void setScrbh(int scrbh)
    {
        this.scrbh = scrbh;
    }

    public String getScrxm()
    {
        return scrxm;
    }

    public void setScrxm(String scrxm)
    {
        this.scrxm = scrxm;
    }

    public String getSpdz()
    {
        return spdz;
    }

    public void setSpdz(String spdz)
    {
        this.spdz = spdz;
    }

    public String getJtdz()
    {
        return jtdz;
    }

    public void setJtdz(String jtdz)
    {
        this.jtdz = jtdz;
    }

    public String getPxlx()
    {
        return pxlx;
    }

    public void setPxlx(String pxlx)
    {
        this.pxlx = pxlx;
    }

    public JSONObject toJSONObject() throws JSONException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString()
    {
        return "Jypx [pxbh=" + pxbh + ", pxbt=" + pxbt + ", spjs=" + spjs + ", scsj=" + scsj + ", scrbh=" + scrbh
                + ", scrxm=" + scrxm + ", spdz=" + spdz + ", jtdz=" + jtdz + ", pxlx=" + pxlx + "]";
    }
    
    
    

   



}
