package com.web.front.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.touch4u.common.BaseDao;
@Repository
public class JydtDao extends BaseDao
{
    public List querynews(StringBuffer sql2){
       String sql=sql2.toString();
        return this.getTemplate().queryForList(sql);
    }
    public int querycount(StringBuffer sql2){
        String sql=sql2.toString();
         return this.getTemplate().queryForInt(sql);
     }
}
