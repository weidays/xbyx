package com.web.front.action.xk;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.touch4u.common.BaseNaviAction;
import com.web.front.service.BeikeService;
import com.touch4u.common.util.Utils;
import com.web.back.model.Jiaoshi;
import com.web.front.service.JiaoshiService;
import com.web.front.service.XkjsService;
import com.web.front.service.XkkmzService;
public class BeikeAction extends BaseNaviAction
{
    private static final long serialVersionUID = -4927528685023543732L;
    private Logger logger=Logger.getLogger(this.getClass());
    @Autowired
    private JiaoshiService jiaoshifrontService;
    @Autowired
    private BeikeService beikeService;
    private List theJs;
    private String xknum;//学科编号区分那个学科
    private int type;
    public List beikeList;
    private int dtcurrentpage=1;
    private int dttotalpage;
    private  int dtstart;
    private  int dtlimit=10;
    private int  bkbh;
    
    public String toJtbk(){
        dtstart=(dtcurrentpage-1)*dtlimit;
        int thecount =beikeService.countPage(1);
        if(thecount%dtlimit>0){
            dttotalpage=thecount/dtlimit+1;
        }else{
            dttotalpage=thecount/dtlimit;
        }
        beikeList= beikeService.queryBeike(dtstart,dtlimit,getXknumFromSession());
        for(int y=0;y<beikeList.size();y++){
            Map map=(Map) beikeList.get(y);
            List cyrList=beikeService.getCyrbybh(String.valueOf(map.get("bkbh")));
            List fjList=beikeService.getfjbybh(String.valueOf(map.get("bkbh")));
            map.put("cyrList", cyrList);
            map.put("fjList", fjList);
            System.out.println(cyrList.toString());
        }
        this.setNavi("jtbk"); 
        return SUCCESS;   
    }
    /**
     * 转到备课表单页面
     * @return
     */
 public String toBeike(){
         //拿出前100个。应该够了吧 
        theJs=jiaoshifrontService.getJiaoshiByXueKe(getXknumFromSession(), 0, 100);
        System.out.println(getXknumFromSession());
        System.out.println(theJs.toString());
        this.setNavi("jtbk"); 
        return SUCCESS;  
   }
 /**
  * 转到备课详情页面
  * @return
  */
 public String beikeDetail(){
     beikeList=beikeService.getBeikebybh(bkbh);
     Map map=(Map) beikeList.get(0);
     List cyrList=beikeService.getCyrbybh(bkbh+"");
     List fjList=beikeService.getfjbybh(bkbh+"");
     map.put("cyrList", cyrList);
     map.put("fjList", fjList);
     this.setNavi("jtbk"); 
     return SUCCESS;   
 }
 /**
  * 转到备课详情页面
  * @return
  */
 public String cyrbeike() throws Exception{
     HttpServletRequest request = getRequest();
     HttpServletResponse response = getResponse();
     getResponse().setCharacterEncoding("UTF-8");
     PrintWriter pw = response.getWriter();
     Jiaoshi jiaoshi=(Jiaoshi) getRequest().getSession().getAttribute("jiaoshi");
     int cyr=0;
     if(jiaoshi!=null){
         cyr=jiaoshi.getJsbh();
     }else{
         //未登录。跳转到登陆页面
         return "homeIndex";
     }
     List list=beikeService.getCyrbybh(bkbh+"");
     Boolean flag=false;
     for (int x=0;x<list.size();x++){
         Map map=(Map)list.get(x);
         if(Integer.parseInt(String.valueOf(map.get("cyr")))==cyr){
             flag=true;
             break;
         }
     }  
     if(!flag){
         //没有资格参与备课。
         pw.write("youshouldjoinfirst");
         return null;
        
     }
     beikeList=beikeService.getBeikebybh(bkbh);
     Map map=(Map) beikeList.get(0);
     List cyrList=beikeService.getCyrbybh(bkbh+"");
     List fjList=beikeService.getfjbybh(bkbh+"");
     map.put("cyrList", cyrList);
     map.put("fjList", fjList);
     this.setNavi("jtbk"); 
     return SUCCESS;   
 }
 /**
  * 备课表单提交接收
  * @return
  */
 public String fqBeike(){
     String[] str=getRequest().getParameterValues("cyr");
     String xkbhstr=getXknumFromSession();
    
     int xkbh=0;
     if(!Utils.isNull(xkbhstr)){
         xkbh=Integer.parseInt(xkbhstr);
     }else{
         //学科信息丢失。。咋办？
         return "homeIndex";
     }
     Jiaoshi jiaoshi=(Jiaoshi) getRequest().getSession().getAttribute("jiaoshi");
     int fqr=0;
     if(jiaoshi!=null){
         fqr=jiaoshi.getJsbh();
     }else{
         //未登录。跳转到登陆页面
         return "homeIndex";
     }
     String bkmc=getRequest().getParameter("bkmc");
     String bknr=getRequest().getParameter("bknr");
     String fjdz =getRequest().getParameter("fjdz");
     String fjmc =getRequest().getParameter("fjmc");
     int x= beikeService.saveBeike(xkbh,fqr,str,bkmc,bknr,fjdz,fjmc);
     this.setNavi("jtbk"); 
  return SUCCESS;   
}
 /**
  * 参与人备课表单提交接收
  * @return
  */
 public String cyrFqbeike() throws Exception{
     HttpServletRequest request = getRequest();
     HttpServletResponse response = getResponse();
     getResponse().setCharacterEncoding("UTF-8");
     PrintWriter pw = response.getWriter();
     Jiaoshi jiaoshi=(Jiaoshi) getRequest().getSession().getAttribute("jiaoshi");
     int cyr=0;
     if(jiaoshi!=null){
         cyr=jiaoshi.getJsbh();
     }else{
         //未登录。跳转到登陆页面
         return "homeIndex";
     }
     List list=beikeService.getCyrbybh(bkbh+"");
     Boolean flag=false;
     for (int x=0;x<list.size();x++){
         Map map=(Map)list.get(x);
         if(Integer.parseInt(String.valueOf(map.get("cyr")))==cyr){
             flag=true;
             break;
         }
     }  
     if(!flag){
         //没有资格参与备课。
         pw.write("youshouldjoinfirst");
         return null;   
     }
 
     String bknr=getRequest().getParameter("bknr");
     String fjdz =getRequest().getParameter("fjdz");
     String fjmc =getRequest().getParameter("fjmc");
     int x= beikeService.saveCyrBeike(cyr,bkbh+"",bknr,fjdz,fjmc);
     this.setNavi("jtbk"); 
     return SUCCESS;   
 }

/**
 * 获得学科编号
 * @return
 */
 private String getXknumFromSession(){
    String xknumString= String.valueOf(getRequest().getSession().getAttribute("xknum"));
     logger.debug("xknum:"+xknumString);
     return xknumString;
     }

public JiaoshiService getJiaoshifrontService()
{
    return jiaoshifrontService;
}
public void setJiaoshifrontService(JiaoshiService jiaoshifrontService)
{
    this.jiaoshifrontService = jiaoshifrontService;
}
public BeikeService getBeikeService()
{
    return beikeService;
}
public void setBeikeService(BeikeService beikeService)
{
    this.beikeService = beikeService;
}
public List getTheJs()
{
    return theJs;
}
public void setTheJs(List theJs)
{
    this.theJs = theJs;
}
public String getXknum()
{
    return xknum;
}
public void setXknum(String xknum)
{
    this.xknum = xknum;
}

public int getType()
{
    return type;
}
public void setType(int type)
{
    this.type = type;
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
public List getBeikeList()
{
    return beikeList;
}
public void setBeikeList(List beikeList)
{
    this.beikeList = beikeList;
}
public int getBkbh()
{
    return bkbh;
}
public void setBkbh(int bkbh)
{
    this.bkbh = bkbh;
}
   

}
