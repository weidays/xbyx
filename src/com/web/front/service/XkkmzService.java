package com.web.front.service;

import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touch4u.common.JdbcBaseDao;

@Service
public class XkkmzService
{
    @Autowired
   private JdbcBaseDao jdbcBaseDao;
    public void saveReplay(int num, int replayId, int jsbh, String replayArea,int superReplayId)
    {
        StringBuffer sql=new StringBuffer("insert into xkjs_xkbk_hf(BKBH,SJHFBH,HFNR,HFSJ,HFR,SUPERHFBH)");
        sql.append(" values(");
        sql.append(num);
        sql.append(",'");
        sql.append(replayId);
        sql.append("','");
        sql.append(replayArea);
        sql.append("',NOW(),");
        sql.append(jsbh);
        sql.append(",");
        sql.append(superReplayId);
        sql.append(")");
        jdbcBaseDao.getJdbcTemplate().update(sql.toString());
    }
/**
 * 根据博客编号查询回复
 * @param num
 * @param start
 * @param limit
 * @return
 */
    public List queryReplay(int num,int start,int limit)
    {
        StringBuffer sql=new StringBuffer("select hf.hfbh,hf.BKBH,hf.SJHFBH,hf.HFNR,DATE_FORMAT( hf.HFSJ,'%Y-%m-%d %H:%i')  HFSJ,hf.HFR,b.jsxm,hf.SUPERHFBH,b.jstx from xkjs_xkbk_hf hf , jsb b where hf.hfr=b.jsbh and bkbh=");
        sql.append(num);
        sql.append(" and hf.sjhfbh=0");
        sql.append(" order by hf.hfsj desc");
        sql.append(" limit ");
        sql.append(start);
        sql.append(",");
        sql.append(limit);
        return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    }
    
    public int countReplay(int num)
    {

        StringBuffer sql=new StringBuffer("select count(1) from xkjs_xkbk_hf hf , jsb b where hf.hfr=b.jsbh and bkbh=");
        sql.append(num);
        sql.append(" and hf.sjhfbh=0");
        return jdbcBaseDao.getJdbcTemplate().queryForInt(sql.toString());
    
    }
    /**
     * 根据回复编号查询回复
     * @param hfbh
     * @param start
     * @param limit
     * @param sjhf 上级回复编号
     * @return
     */
    public List queryReplaySon( int start, int limit, Integer superHfbh)
    {
    StringBuffer sql=new StringBuffer("SELECT sonhf.hfbh,sonhf.BKBH,sonhf.SJHFBH,sonhf.HFNR,sonhf.HFR,sonb.jsxm sonjsxm,b.jsxm jsxm,sonb.jstx,DATE_FORMAT( hf.HFSJ,'%Y-%m-%d %H:%i')  sonHFSJ,sonhf.superhfbh ");

    sql.append(" FROM xkjs_xkbk_hf sonhf ,xkjs_xkbk_hf hf ,  jsb b, jsb sonb"); 
    sql.append(" WHERE  sonhf.sjhfbh=hf.hfbh AND hf.hfr=b.jsbh AND sonhf.hfr=sonb.jsbh AND sonhf.superhfbh=");
    sql.append(superHfbh);
    
    sql.append(" ORDER BY sonhf.hfsj ,sonhf.hfbh");
    sql.append(" limit ");
    sql.append(start);
    sql.append(",");
    sql.append(limit);
    return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    }
    
    /**
     * 根据回复编号统计子回复
     * @param sjhf 上级回复编号
     * @return
     */
    public int countReplaySon(  Integer superHfbh)
    {
    StringBuffer sql=new StringBuffer("SELECT  count(1) FROM xkjs_xkbk_hf sonhf ,xkjs_xkbk_hf hf ,  jsb b, jsb sonb"); 
    sql.append(" WHERE  sonhf.sjhfbh=hf.hfbh AND hf.hfr=b.jsbh AND sonhf.hfr=sonb.jsbh AND sonhf.superhfbh=");
    sql.append(superHfbh);
    
    return jdbcBaseDao.getJdbcTemplate().queryForInt(sql.toString());
    }
    public List queryBkPhb(int start,int limit)
    {
        StringBuffer sql=new StringBuffer("SELECT  bkbh, bkbt,djs FROM xkjs_xkbk "); 
        sql.append(" order by djs desc");
        sql.append(" limit ");
        sql.append(start);
        sql.append(",");
        sql.append(limit);
        return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    }
    
  /**
   * 发表博客  
   * @param title
   * @param content
   * @param techNo
   * @param type
   * @param state
   */

public int writeBlog(String title, String content,int techNo,int type,int state)
{
    StringBuffer sql=new StringBuffer("insert into xkjs_xkbk(bkbt,bknr,fbr,fbsj,bkfl,bkzt)");
    sql.append(" values('");
    sql.append(title);
    sql.append("','");
    sql.append(content);
    sql.append("',");
    sql.append(techNo);
    sql.append(",now(),");
    sql.append(type);
    sql.append(",");
    sql.append(state);
    sql.append(")");
    System.out.println(sql);
    return jdbcBaseDao.getJdbcTemplate().update(sql.toString());
}
public List queryFl(int jsbh)
{
    StringBuffer sql=new StringBuffer("SELECT  * FROM xkjs_xkbk_fl where type=1 and jsbh="+jsbh); 
    sql.append(" union all SELECT  * FROM xkjs_xkbk_fl  where type=0");
    return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    
}
public int saveFl(String flmc,int jsbh)
{
    StringBuffer sql=new StringBuffer("insert into xkjs_xkbk_fl(flmc,jsbh,type)");
    sql.append(" values(");
    sql.append(flmc);
    sql.append(",");
    sql.append(jsbh);
    sql.append(",1");//默认设置为1
    sql.append(")");
    return jdbcBaseDao.getJdbcTemplate().update(sql.toString());
}
}
