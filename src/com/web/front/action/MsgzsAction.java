package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseNaviAction;
import com.web.front.service.XkjsService;

public class MsgzsAction extends BaseNaviAction
{
    @Autowired
    private XkjsService xkjsService;
    private List xks;
    private List ytdt;
    private int num;
    private int start;
    private int limit=10;
    public String index()
    {
        xks= xkjsService.queryXk(null,1);
        ytdt=xkjsService.querynews(num, 1, start, limit,null);
        this.setNavi("msgzs");
        return SUCCESS;
    }
    public void setXkjsService(XkjsService xkjsService)
    {
        this.xkjsService = xkjsService;
    }
    public void setXks(List xks)
    {
        this.xks = xks;
    }
    public void setYtdt(List ytdt)
    {
        this.ytdt = ytdt;
    }
    public void setNum(int num)
    {
        this.num = num;
    }
    public void setStart(int start)
    {
        this.start = start;
    }
    public void setLimit(int limit)
    {
        this.limit = limit;
    }
    public List getXks()
    {
        return xks;
    }
    public List getYtdt()
    {
        return ytdt;
    }
    public int getStart()
    {
        return start;
    }
    public int getNum()
    {
        return num;
    }
    public int getLimit()
    {
        return limit;
    }
}
