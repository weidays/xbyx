package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseNaviAction;
import com.web.front.service.JydtService;

public class ZcwjAction extends BaseNaviAction
{
    @Autowired
    private JydtService jydtService;
    
    private int wjcurrentpage=1;
    private int wjtotalpage;
    private  int wjstart;
    private  int wjlimit=20;
    private List jyqtList;
    public String index()
    {
        wjstart=(wjcurrentpage-1)*wjlimit;
        this.setNavi("zcwj");
        jyqtList=jydtService.querynews(wjstart, wjlimit,3);//政策文件
        int thecount =jydtService.countPage(3);
        if(thecount%wjlimit>0){
            wjtotalpage=thecount/wjlimit+1;
        }else{
            wjtotalpage=thecount/wjlimit;
        }
        return SUCCESS;
    }

    public int getWjcurrentpage()
    {
        return wjcurrentpage;
    }

    public void setWjcurrentpage(int wjcurrentpage)
    {
        this.wjcurrentpage = wjcurrentpage;
    }

    public int getWjtotalpage()
    {
        return wjtotalpage;
    }

    public void setWjtotalpage(int wjtotalpage)
    {
        this.wjtotalpage = wjtotalpage;
    }

    public int getWjstart()
    {
        return wjstart;
    }

    public void setWjstart(int wjstart)
    {
        this.wjstart = wjstart;
    }

    public int getWjlimit()
    {
        return wjlimit;
    }

    public void setWjlimit(int wjlimit)
    {
        this.wjlimit = wjlimit;
    }

    public List getJyqtList()
    {
        return jyqtList;
    }

    public void setJyqtList(List jyqtList)
    {
        this.jyqtList = jyqtList;
    }
    
    
    
}
