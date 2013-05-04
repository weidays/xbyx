package com.web.front.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.touch4u.common.BaseDao;
import com.web.back.model.Jypx;
import com.web.back.model.Xbkc;

@Repository
public class XbkcDao extends BaseDao
{

    public List<Xbkc> list(String keyword, Integer page, Integer pageSize)
    {
        List<Xbkc> result = new ArrayList<Xbkc>();
        StringBuffer sql = new StringBuffer();
        List params = new ArrayList();
        sql.append("select * from xbkc where 1=1");
        if (!StringUtils.isBlank(keyword))
        {
            sql.append(" and (kcbt like '%" + keyword + "%')");
        }
        sql.append(" order by scsj");
        sql.append(" limit ?,?");
        params.add((page - 1) * pageSize);
        params.add(pageSize);
        List<Map> list = this.getTemplate().queryForList(sql.toString(), params.toArray());
        for (Map record : list)
        {
            Xbkc xbkc = new Xbkc();
            xbkc.setKcbh(Integer.parseInt(record.get("KCBH").toString()));
            xbkc.setKcbt(record.get("KCBT").toString());
            xbkc.setSpjs(record.get("SPJS").toString());
            xbkc.setSpdz(record.get("SPDZ").toString());
            xbkc.setScsj((Date) record.get("SCSJ"));
            result.add(xbkc);
        }
        return result;
    }

    public Integer count(String keyword)
    {
        StringBuffer sql = new StringBuffer();
        List params = new ArrayList();
        sql.append("select count(1) from xbkc where 1=1");
        if (!StringUtils.isBlank(keyword))
        {
            sql.append(" and (kcbt like '%" + keyword + "%')");
        }
        return this.getTemplate().queryForInt(sql.toString(), params.toArray());
    }

    public void save(Xbkc xbkc)
    {
        String sql = "insert into xbkc(kcbh,kcbt,spjs,spdz,scsj) values(?,?,?,?,?)";
        this.getTemplate().update(sql,
            new Object[] { xbkc.getKcbh(), xbkc.getKcbt(), xbkc.getSpjs(), xbkc.getSpdz(), xbkc.getScsj() });

    }

}
