package com.web.back.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.touch4u.common.BaseDao;
import com.touch4u.common.util.Utils;
import com.web.back.model.Jiaoshi;
@Repository
public class JiaoshiDao extends BaseDao
{
    /**
     * 根据登陆账号查询教师
     * 
     * @author
     * @param staffCode
     * @return
     */
    public List getJiaoshibydlzh(String userId)
    {
        System.out.println(userId+"--------------------");
        if (Utils.isNull(userId))
        {
            return null;
        }
        String sql="SELECT * FROM jsb t WHERE t.dlzh ='"+userId+"'";
        List list = this.getTemplate().queryForList(sql);
        return list;
    }

    public int registJiaoshi(Jiaoshi js)
    {
        String sql="INSERT INTO jsb (dlzh, dlmm,jsxm,rjkm) VALUES ('"+js.getDlzh()+"','"+js.getDlmm()+"','"+js.getJsxm()+"','"+js.getRjkm()+"')";
        int x=this.getTemplate().update(sql);
        return x;
    }
}
