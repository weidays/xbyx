package com.web.front.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.back.model.Xbkc;
import com.web.front.dao.XbkcDao;

@Service
public class XbkcService
{

    @Autowired
    private XbkcDao xbkcDao;
    
    public List<Xbkc> list(String keyword, Integer page, Integer pageSize)
    {
        List<Xbkc> list = xbkcDao.list(keyword, page, pageSize);
        return list;
    }

    public Integer count(String keyword)
    {
        return xbkcDao.count(keyword);
    }

    public void save(Xbkc xbkc)
    {
        xbkc.setScsj(new Date());
        xbkcDao.save(xbkc);

    }

}
