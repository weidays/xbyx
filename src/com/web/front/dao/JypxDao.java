package com.web.front.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.touch4u.common.BaseDao;
import com.web.back.model.Jypx;

@Repository
public class JypxDao extends BaseDao
{

    @SuppressWarnings({ "rawtypes", "unused", "unchecked" })
    public List<Jypx> list(String pxlx,String keyword,Integer page, Integer pageSize)
    {
        List<Jypx> result = new ArrayList<Jypx>();
        StringBuffer sql = new StringBuffer();
        List params = new ArrayList();
        sql.append("select * from jypx where 1=1");
        if(!StringUtils.isBlank(pxlx)){
            sql.append(" and pxlx=?");
            params.add(pxlx);
        }
        if(!StringUtils.isBlank(keyword)){
            sql.append(" and (pxbt like '%"+keyword+"%')");
        }
        sql.append(" order by scsj");
        sql.append(" limit ?,?");
        params.add((page-1)*pageSize);
        params.add(pageSize);
        List<Map> list = this.getTemplate().queryForList(sql.toString(),params.toArray());
        for (Map record : list)
        {
            Jypx jypx = new Jypx();
            jypx.setPxbh(Integer.parseInt(record.get("PXBH").toString()));
            jypx.setPxbt(record.get("PXBT").toString());
            jypx.setSpjs(record.get("SPJS").toString());
            jypx.setSpdz(record.get("SPDZ").toString());
            jypx.setScsj((Date)record.get("SCSJ"));
            result.add(jypx);
        }
        return result;
    }

    public void save(Jypx jypx)
    {
        String sql = "insert into jypx(pxbh,pxbt,spjs,spdz,pxlx,scsj) values(?,?,?,?,?,?)";
        this.getTemplate().update(
            sql,
            new Object[] { jypx.getPxbh(), jypx.getPxbt(), jypx.getSpjs(), jypx.getSpdz(), jypx.getPxlx(),
                    jypx.getScsj() });
    }

    public Integer count(String pxlx,String keyword)
    {
        StringBuffer sql = new StringBuffer();
        List params = new ArrayList();
        sql.append("select count(1) from jypx where 1=1");
        if(!StringUtils.isBlank(pxlx)){
            sql.append(" and pxlx=?");
            params.add(pxlx);
        }
        if(!StringUtils.isBlank(keyword)){
            sql.append(" and (pxbt like '%"+keyword+"%')");
        }
        return this.getTemplate().queryForInt(sql.toString(), params.toArray());
    }

}
