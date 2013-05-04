package com.web.front.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.back.model.News;
import com.web.front.dao.JydtDao;
@Service
public class JydtService
{
    @Autowired
    private JydtDao jydtDao;

    public  List querynews(int start, int limit, int i)
    {
        StringBuffer sql=new StringBuffer("SELECT * from news  ");
        sql.append("where type = '"+i+"'");
        sql.append(" ORDER BY time desc");
        sql.append(" limit ");
        sql.append(start);
        sql.append(",");
        sql.append(limit);
        
        return jydtDao.querynews(sql);
    }

    public News querynewsbyId(String dtbh)
    {
        StringBuffer sql=new StringBuffer("SELECT * from news  ");
        sql.append("where id = '"+dtbh+"'");
        List list= jydtDao.querynews(sql);
        if(list.size()>0){
        Map listM=(Map) list.get(0);
        
        News news=new News();
        news.setContent(listM.get("content")+"");
        news.setName(listM.get("name")+"");
        Date date=(Date)listM.get("time");
        news.setTime(date);
        
        return news;
        }
        else{
            return null;
        }
      
        
        
    }

    public int countPage(int type)
    {
        StringBuffer sql=new StringBuffer("SELECT count(1) from news s");
        sql.append(" where s.type=");
        sql.append(type);
     
        return jydtDao.querycount(sql);
    }

}
