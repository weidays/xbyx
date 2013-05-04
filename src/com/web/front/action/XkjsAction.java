package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseAction;
import com.web.front.service.XkjsService;

public class XkjsAction extends BaseAction
{
    /**
     * 
     */
    private static final long serialVersionUID = 3693990373103850903L;
    @Autowired
    private XkjsService xkjsService;
    private  int xkNum;
    private  int start;
    private  int limit=10;
    private String navi;
    private List xks;
    private List xkjtbks;
    private List ythd;
    private List ytdt;
    private List kycg;
    private List xkbk;
 /**
  * 到学科建设
  * @return
  */
 public String index(){
     
      xks= xkjsService.queryXk(null,0);
      xkjtbks= xkjsService.queryXkjtbk(xkNum,start,4,null);
      ythd=xkjsService.queryythd(xkNum, start, limit,null);
      ytdt=xkjsService.querynews(xkNum, 1, start, limit,null);
      kycg=xkjsService.querynews(xkNum, 2, start, limit,null);
      xkbk=xkjsService.queryxkbk( start, 2,null);
     navi="xkjs";
     return "success";
 }
 
 
public void setXkjsService(XkjsService xkjsService)
{
    this.xkjsService = xkjsService;
}
public void setXkNum(int xkNum)
{
    this.xkNum = xkNum;
}
public void setStart(int start)
{
    this.start = start;
}
public void setLimit(int limit)
{
    this.limit = limit;
}


public void setNavi(String navi)
{
    this.navi = navi;
}


public List getXkjtbks()
{
    return xkjtbks;
}


public void setXkjtbks(List xkjtbks)
{
    this.xkjtbks = xkjtbks;
}


public List getXkbk()
{
    return xkbk;
}


public void setXkbk(List xkbk)
{
    this.xkbk = xkbk;
}


public int getXkNum()
{
    return xkNum;
}


public int getStart()
{
    return start;
}


public String getNavi()
{
    return navi;
}


public List getXks()
{
    return xks;
}


public List getYthd()
{
    return ythd;
}


public List getYtdt()
{
    return ytdt;
}


public List getKycg()
{
    return kycg;
}



}
