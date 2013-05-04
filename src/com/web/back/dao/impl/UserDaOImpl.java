package com.web.back.dao.impl;

import java.util.List;

import com.touch4u.common.JdbcBaseDao;
import com.touch4u.common.util.Utils;
import com.web.back.dao.UserDaO;

public class UserDaOImpl  implements UserDaO
{
    private JdbcBaseDao jdbcBaseDao;
    public JdbcBaseDao getJdbcBaseDao()
    {
        return jdbcBaseDao;
    }

    public void setJdbcBaseDao(JdbcBaseDao jdbcBaseDao)
    {
        this.jdbcBaseDao = jdbcBaseDao;
    }



    /**
     * 根据STAFF_CODE查询STAFF
     * @author
     * @param staffCode
     * @return
     */
    public List getUserbyUserId(String userName)
    {
        if (Utils.isNull(userName))
        {
            return null;
        }
        String sql="select user_id, user_name, login_name, password" +
        		"   from user where user_name ='"+userName+"'";
        List list = jdbcBaseDao.getJdbcTemplate().queryForList(sql);
        return list;
    }
}