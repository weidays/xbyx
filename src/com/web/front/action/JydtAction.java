package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseNaviAction;
import com.touch4u.common.util.Utils;
import com.web.back.model.News;
import com.web.front.service.JydtService;

public class JydtAction extends BaseNaviAction
{
    @Autowired
    private JydtService jydtService;
    
    private int dtcurrentpage=1;
    private int dttotalpage;
    private  int dtstart;
    private  int dtlimit=20;
    private int cgcurrentpage=1;
    private int cgtotalpage;
    private  int cgstart;
    private  int cglimit=20;
    private String dtbh;
    private News news;
    private String navi;
    private List jydtList;
    private List jycgList;
    public String index()
    {
        dtstart=(dtcurrentpage-1)*dtlimit;
        cgstart=(cgcurrentpage-1)*cglimit;
        this.setNavi("jydt");
        jydtList=jydtService.querynews(dtstart, dtlimit,1);//动态
        jycgList=jydtService.querynews(cgstart, cglimit,2);//成果
        int thecount =jydtService.countPage(1);
        if(thecount%dtlimit>0){
            dttotalpage=thecount/dtlimit+1;
        }else{
            dttotalpage=thecount/dtlimit;
        }
        
        int thecount2 =jydtService.countPage(2);
        if(thecount2%cglimit>0){
            cgtotalpage=thecount2/cglimit+1;
        }else{
            cgtotalpage=thecount2/cglimit;
        }
       
        return SUCCESS;
    }
    public String dtDetail(){
        
        this.setNavi(navi);
        
        news =jydtService.querynewsbyId(dtbh);
        
        return SUCCESS;
    }
  
    
    public String getDtbh()
    {
        return dtbh;
    }
    public void setDtbh(String dtbh)
    {
        this.dtbh = dtbh;
    }
    public News getNews()
    {
        return news;
    }
    public void setNews(News news)
    {
        this.news = news;
    }
    public String getNavi()
    {
        return navi;
    }
    public void setNavi(String navi)
    {
        this.navi = navi;
    }
    public List getJydtList()
    {
        return jydtList;
    }
    public void setJydtList(List jydtList)
    {
        this.jydtList = jydtList;
    }
    public List getJycgList()
    {
        return jycgList;
    }
    public void setJycgList(List jycgList)
    {
        this.jycgList = jycgList;
    }
    public int getDtcurrentpage()
    {
        return dtcurrentpage;
    }
    public void setDtcurrentpage(int dtcurrentpage)
    {
        this.dtcurrentpage = dtcurrentpage;
    }
    public int getDttotalpage()
    {
        return dttotalpage;
    }
    public void setDttotalpage(int dttotalpage)
    {
        this.dttotalpage = dttotalpage;
    }
    public int getDtstart()
    {
        return dtstart;
    }
    public void setDtstart(int dtstart)
    {
        this.dtstart = dtstart;
    }
    public int getDtlimit()
    {
        return dtlimit;
    }
    public void setDtlimit(int dtlimit)
    {
        this.dtlimit = dtlimit;
    }
    public int getCgcurrentpage()
    {
        return cgcurrentpage;
    }
    public void setCgcurrentpage(int cgcurrentpage)
    {
        this.cgcurrentpage = cgcurrentpage;
    }
    public int getCgtotalpage()
    {
        return cgtotalpage;
    }
    public void setCgtotalpage(int cgtotalpage)
    {
        this.cgtotalpage = cgtotalpage;
    }
    public int getCgstart()
    {
        return cgstart;
    }
    public void setCgstart(int cgstart)
    {
        this.cgstart = cgstart;
    }
    public int getCglimit()
    {
        return cglimit;
    }
    public void setCglimit(int cglimit)
    {
        this.cglimit = cglimit;
    }
    
    
    
}
