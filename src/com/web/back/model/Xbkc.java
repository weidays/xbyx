package com.web.back.model;

import java.io.Serializable;
import java.util.Date;

public class Xbkc implements Serializable
{
    private int kcbh;// 培训编号

    private String kcbt;// 培训标题

    private String spjs;// 视频介绍

    private Date scsj;// 上传时间

    private int scrbh;// 上传人编号
    private String scrxm;// 上传人姓名
    private String spdz;// 视频地址
    private String jtdz;// 截图机制

    /**
     * @return the kcbh
     */
    public int getKcbh()
    {
        return kcbh;
    }

    /**
     * @param kcbh the kcbh to set
     */
    public void setKcbh(int kcbh)
    {
        this.kcbh = kcbh;
    }

    /**
     * @return the kcbt
     */
    public String getKcbt()
    {
        return kcbt;
    }

    /**
     * @param kcbt the kcbt to set
     */
    public void setKcbt(String kcbt)
    {
        this.kcbt = kcbt;
    }

    /**
     * @return the spjs
     */
    public String getSpjs()
    {
        return spjs;
    }

    /**
     * @param spjs the spjs to set
     */
    public void setSpjs(String spjs)
    {
        this.spjs = spjs;
    }

    /**
     * @return the scsj
     */
    public Date getScsj()
    {
        return scsj;
    }

    /**
     * @param scsj the scsj to set
     */
    public void setScsj(Date scsj)
    {
        this.scsj = scsj;
    }

    /**
     * @return the scrbh
     */
    public int getScrbh()
    {
        return scrbh;
    }

    /**
     * @param scrbh the scrbh to set
     */
    public void setScrbh(int scrbh)
    {
        this.scrbh = scrbh;
    }

    /**
     * @return the scrxm
     */
    public String getScrxm()
    {
        return scrxm;
    }

    /**
     * @param scrxm the scrxm to set
     */
    public void setScrxm(String scrxm)
    {
        this.scrxm = scrxm;
    }

    /**
     * @return the spdz
     */
    public String getSpdz()
    {
        return spdz;
    }

    /**
     * @param spdz the spdz to set
     */
    public void setSpdz(String spdz)
    {
        this.spdz = spdz;
    }

    /**
     * @return the jtdz
     */
    public String getJtdz()
    {
        return jtdz;
    }

    /**
     * @param jtdz the jtdz to set
     */
    public void setJtdz(String jtdz)
    {
        this.jtdz = jtdz;
    }

}
