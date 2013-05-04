package com.web.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touch4u.common.JdbcBaseDao;
@Service("jiaoshifrontService")
public class JiaoshiService
{
@Autowired
private JdbcBaseDao jdbcBaseDao;
public List getJiaoshiByXueKe(String xknum ,int start,int  limit){
    
    StringBuffer sql=new StringBuffer("select * from jsb where rjkm=");
    sql.append(xknum);
    sql.append(" limit ");
    sql.append(start);
    sql.append(",");
    sql.append(limit);
    return  jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    }

}
