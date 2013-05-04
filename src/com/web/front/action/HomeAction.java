package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseAction;
import com.web.front.service.HomeService;
import com.web.front.service.XkjsService;
public class HomeAction extends BaseAction
{
    private String navi;
    private List kmlist;
    
    @Autowired
    private HomeService homeService;
    @Autowired
    private XkjsService xkjsService;
    public String index(){
        homeService.sayHello();
        kmlist= xkjsService.queryXk(null,0);
        navi = "home";
        return SUCCESS;
    }
    
    public String getNavi()
    {
        return navi;
    }


    public void setNavi(String navi)
    {
        this.navi = navi;
    }


    public List getKmlist()
    {
        return kmlist;
    }


    public void setKmlist(List kmlist)
    {
        this.kmlist = kmlist;
    }
    

    
    
}
