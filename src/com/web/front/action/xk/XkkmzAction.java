package com.web.front.action.xk;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.touch4u.common.BaseNaviAction;
import com.web.front.service.BeikeService;
import com.touch4u.common.util.JsonUtil;
import com.touch4u.common.util.Utils;
import com.web.back.model.Jiaoshi;
import com.web.front.service.JiaoshiService;
import com.web.front.service.XkjsService;
import com.web.front.service.XkkmzService;
public class XkkmzAction extends BaseNaviAction
{
    
    private static final long serialVersionUID = -4927528685023543732L;
    private Logger logger=Logger.getLogger(this.getClass());
    @Autowired
    private XkjsService xkjsService;
    @Autowired
    private XkkmzService xkkmzService;
    @Autowired
    private JiaoshiService jiaoshifrontService;
    @Autowired
    private BeikeService beikeService;
    
    private List xks;
    private List xkjtbks;
    private List ythd;
    private List ytdt;
    private List kycg;
    private List xkbk;
    private List theJs;
    private List others;
    private String xknum;//学科编号区分那个学科
    private int start;
    private List news;
    private Map onenew;
    private Map oneMap;
    private int num;//ID编号
    private int replayId;//回复时，回复表的id
    private int superReplayId;//顶级回复
    private int type;
    private int currentpage=1;
    private int limit=10;//多少条
    private int allPage;
    private int state;
    private String replayArea;
    private String title;
    /**
     * 学科组首页
     * @return
     */
    public String index()
    {
        if (!Utils.isNull(xknum))
        {
            getRequest().getSession().setAttribute("xknum", xknum);
        }else {
            xknum=getXknumFromSession();
        }
       List xks= xkjsService.queryXk(xknum,0);
        if (xks!=null&&xks.size()>0)
        {
            getRequest().getSession().setAttribute("xkmap", xks.get(0));
        }
       
        start=(currentpage-1)*limit;
        ythd=xkjsService.queryythd(0, start, limit,String.valueOf(xknum));
        xkjtbks= xkjsService.queryXkjtbk(0,start,4,String.valueOf(xknum));
        ytdt=xkjsService.querynews(0, 1, start, limit,String.valueOf(xknum));
        kycg=xkjsService.querynews(0, 2, start, limit,String.valueOf(xknum));
        xkbk=xkjsService.queryxkbk( start, 2,String.valueOf(xknum));
        theJs=jiaoshifrontService.getJiaoshiByXueKe(xknum, start, 9);
        this.setNavi("home");
        return SUCCESS;
    }
    /**
     * 教研动态或者教研成果某个详细页面
     * @return
     */
    public String newDetail(){
        onenew=xkjsService.queryOneNews(num);
        xkjtbks= xkjsService.queryXkjtbk(0,start,4,getXknumFromSession());
        
        if (type==1)
        {
            this.setNavi("jydt");   
        }else if(type==2) {
            this.setNavi("jycg"); 
        }
        return SUCCESS; 
    }
    /**
     * 到教研动态或者教研成果页面
     * @return
     */
    public String news(){
        xkjtbks= xkjsService.queryXkjtbk(0,start,4,getXknumFromSession());
        if (limit<=0)
        {
           return  SUCCESS;
        }
        start=(currentpage-1)*limit;
        news=xkjsService.querynews(0,type, start, limit,getXknumFromSession());
        int count=xkjsService.countnews(type,getXknumFromSession());
         allPage=count/limit;
        if (count%limit>0)
        {
            allPage+=1;
        }
        if (type==1)
        {
            this.setNavi("jydt");   
        }else if(type==2) {
            this.setNavi("jycg"); 
        }
        return SUCCESS;   
    }
    /**
     * 跳转到学科博客
     * @return
     */
    public String toXkbk(){
        
        String xknum=getXknumFromSession() ; 
        if (limit<=0)
        {
           return  SUCCESS;
        }
        start=(currentpage-1)*limit;
        xkbk=xkjsService.queryxkbk(  start, limit,xknum);
       
       // news=xkjsService.querynews(0,type, start, limit,xknum);
        others=xkkmzService.queryBkPhb(start,limit);
        int count=xkjsService.countXkbk(type,xknum);
         allPage=count/limit;
        if (count%limit>0)
        {
            allPage+=1;
        }
        if (type==1)
        {
            this.setNavi("jydt");   
        }else if(type==2) {
            this.setNavi("jycg"); 
        }
        this.setNavi("xkbk"); 
        return SUCCESS;   
    }
   /**
    * 发表博客
    * @return
    */
    public String writeBlog(){ 
        try
        {
            logger.debug("replayArea:"+replayArea);
        Jiaoshi js=(Jiaoshi) this.getRequest().getSession().getAttribute("jiaoshi");
       
            xkkmzService.writeBlog(title,replayArea,1,type,state); 
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        JSONObject jsonObject=new JSONObject();
        try
        {
            jsonObject.put("succ", true);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        returnMsg(jsonObject.toString()); 
        return null;   
    }
    /**
     * 获得博客分类
     * @return
     */
    public String queryFl(){
        Jiaoshi js=(Jiaoshi) this.getRequest().getSession().getAttribute("jiaoshi");
      List list=  xkkmzService.queryFl(1);
        returnMsg(JsonUtil.listMapToJsonObject(list, "root").toString()); 
        return null;
    }
    /**
     * 添加分类
     */
    public String saveFl(){
        Jiaoshi js=(Jiaoshi) this.getRequest().getSession().getAttribute("jiaoshi");
        xkkmzService.saveFl(title,1);
        
        return null;
    }
    /**
     * 学科博客回复
     * @return
     */
    public String replay(){
        Jiaoshi js=(Jiaoshi) this.getRequest().getSession().getAttribute("jiaoshi");
        xkkmzService.saveReplay(num,replayId,1,replayArea,superReplayId);
        getreplays();
        return SUCCESS;  
    }
    public String getReplay(){
        getreplays();
        return SUCCESS;  
    }
   /**
    * 查看某个博客的详细信息
    * @return
    */
    public String xkbknr(){
        //更新点击
        xkjsService.updateXkbkDj(num);
        oneMap=xkjsService.queryxkbkById(num);
        others=xkkmzService.queryBkPhb(start,limit);
        getreplays();
        this.setNavi("xkbk"); 
        return SUCCESS;  
    }
  
    private void getreplays(){
        if (limit<=0)
        {
            limit=10;
        }
        
        start=limit*(currentpage-1);
        //先查询出第一级回复
        news=xkkmzService.queryReplay(num,start,limit);
        int counta=xkkmzService.countReplay(num);
        allPage=counta/limit;
        if (counta%limit>0)
        {
            allPage+=1;
        }
        //查询出子级回复
        if (news!=null&&news.size()>0)
        {
            for (int i = 0; i <news.size(); i++)
            {
                Map map=(Map) news.get(i);
                List sonnews= xkkmzService.queryReplaySon(start,limit,Integer.valueOf(String.valueOf(map.get("hfbh")))); 
                map.put("sonnews", sonnews);
            }
            
        }
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
   
 
 private void returnMsg(String msg){
     logger.debug("msg："+msg);
     getResponse().setContentType("text/json; charset=UTF-8"); 
     
     try {
         getResponse().getWriter().write(msg);
         
     } catch (IOException e) {
         e.printStackTrace();
     }finally{
         try {
             getResponse().getWriter().flush();
             getResponse().getWriter().close();
         } catch (Exception e2) {
         }
     }
 }
 
 
 public void setXkjsService(XkjsService xkjsService)
    {
        this.xkjsService = xkjsService;
    }
    public void setYtdt(List ytdt)
    {
        this.ytdt = ytdt;
    }
    public void setStart(int start)
    {
        this.start = start;
    }
    public void setLimit(int limit)
    {
        this.limit = limit;
    }
    public List getYtdt()
    {
        return ytdt;
    }
    public int getStart()
    {
        return start;
    }
    public int getLimit()
    {
        return limit;
    }
    public List getXkjtbks()
    {
        return xkjtbks;
    }
    public List getYthd()
    {
        return ythd;
    }
    public List getKycg()
    {
        return kycg;
    }
    public List getXkbk()
    {
        return xkbk;
    }
    public List getTheJs()
    {
        return theJs;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public List getNews()
    {
        return news;
    }

    public int getAllPage()
    {
        return allPage;
    }

    public int getCurrentpage()
    {
        return currentpage;
    }

    public void setCurrentpage(int currentpage)
    {
        this.currentpage = currentpage;
    }
    public int getNum()
    {
        return num;
    }
    public void setNum(int num)
    {
        this.num = num;
    }
    public Map getOnenew()
    {
        return onenew;
    }
    public Map getOneMap()
    {
        return oneMap;
    }
    public void setReplayArea(String replayArea)
    {
        this.replayArea = replayArea;
    }
    public String getXknum()
    {
        return xknum;
    }
    public void setXknum(String xknum)
    {
        this.xknum = xknum;
    }
    public void setReplayId(int replayId)
    {
        this.replayId = replayId;
    }
    public void setSuperReplayId(int superReplayId)
    {
        this.superReplayId = superReplayId;
    }
    public List getOthers()
    {
        return others;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setState(int state)
    {
        this.state = state;
    }
}
