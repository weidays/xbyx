package com.touch4u.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao
{
    
    @Autowired
    private TxDaoSupport daoSupport;
    
    public JdbcTemplate getTemplate(){
        return daoSupport.getJdbcTemplate();
    }
    
    

}
