package com.web.back.dao.impl;

import java.util.List;

import com.touch4u.common.JdbcBaseDao;
import com.web.back.dao.MenuDAO;

public class MenuDAOImpl  implements MenuDAO {

   private JdbcBaseDao jdbcBaseDao;
   
    public JdbcBaseDao getJdbcBaseDao()
{
    return jdbcBaseDao;
}

public void setJdbcBaseDao(JdbcBaseDao jdbcBaseDao)
{
    this.jdbcBaseDao = jdbcBaseDao;
}

   
    public List getMenus(Integer menuId)
    {
        String sql=" select menu_id, PARENT_MENU_ID, MENU_NAME, ICONCLS, URL"+
     " from MENU where  MENU_ID like '"+menuId+"%' ";
        List list = jdbcBaseDao.getJdbcTemplate().queryForList(sql);
        return list;
    }

    
}