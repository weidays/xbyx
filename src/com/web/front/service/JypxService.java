package com.web.front.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.back.model.Jypx;
import com.web.front.dao.JypxDao;

@Service
public class JypxService
{
    @Autowired
    private JypxDao jypxDao;
    
    public List<Jypx> list(String pxlx,String keyword,Integer page, Integer pageSize){
        List list =  jypxDao.list(pxlx,keyword,page,pageSize);
        return list;
    }

    public void save(Jypx jypx)
    {
        jypx.setScsj(new Date());
        jypxDao.save(jypx);
        
    }

    public Integer count(String pxlx,String keyword)
    {
        return jypxDao.count(pxlx,keyword);
    }

}
