package com.web.front.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.touch4u.common.JdbcBaseDao;
import com.touch4u.common.util.Utils;
@Service("xkjsService")
public class XkjsService
{
    private JdbcBaseDao jdbcBaseDao;
    
    /**
     * 按照学科编号查询学科
     * xkNum 学科编号
     * isms 是否是名师1表示是名师，0表示是学科建设
     */
    public List queryXk(String xkNum,int isms)
    {
        StringBuffer sql=new StringBuffer("select * from xkjs_xkb where isms=");
        sql.append(isms);
        if (!Utils.isNull(xkNum))
      {
          sql.append(" and xkbh=");
          sql.append(xkNum);
      }
        sql.append(" ORDER BY xkbh");
          return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
      }
    
    public void setJdbcBaseDao(JdbcBaseDao jdbcBaseDao)
    {
        this.jdbcBaseDao = jdbcBaseDao;
    }
    /**
     * 查询动态
     * @param num
     * * @param num
     *  @param xknum学科编号
     * @param type
     * @param start
     * @param limit
     * @return
     */
    public List querynews(int num,int type,int start , int limit,String xknum){
        StringBuffer sql=new StringBuffer("SELECT s.ID,s.XKBH,s.name,s.content,s.type,DATE_FORMAT(s.time,'%Y-%m-%d %H:%k') time,b.xkmc from news s ,xkjs_xkb b where s.xkbh=b.xkbh");
        sql.append("  and s.type=");
        sql.append(type);
        if (num>0)
        {
            sql.append(" and  s.id=");
            sql.append(num);
        }
        if (xknum!=null&&!"".equals(xknum))
        {
            sql.append(" and s.xkbh=");
            sql.append(xknum);
        }
        sql.append(" ORDER BY time desc");
        sql.append(" limit ");
        sql.append(start);
        sql.append(",");
        sql.append(limit);
          return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    }
    /**
     * 查询备课表
     * @param num
     *  @param xknum学科编号
     * @param start
     * @param limit
     * @return
     */
    public List queryXkjtbk(int num,int start , int limit,String xknum)
    {
        StringBuffer sql=new StringBuffer("SELECT bkbh,s.jsxm,bkmc,CASE WHEN bkzt=1 THEN '备课进行中' ELSE '备课完成' END bkzt,k.fqr,b.xkmc " +
        		"FROM xkjs_jtbk k,xkjs_xkb b,jsb s WHERE k.xkbh=b.xkbh and s.jsbh=k.fqr ");
    if (num>0)
  {
      sql.append(" and bkbh=");
      sql.append(num);
  }
    if (xknum!=null&&!"".equals(xknum))
    {
        sql.append(" and k.xkbh=");
        sql.append(xknum);
    }
    sql.append(" ORDER BY k.fqsj desc");
    sql.append(" limit ");
    sql.append(start);
    sql.append(",");
    sql.append(limit);
      return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    }
/**
 * 查询研讨活动
 * @param num
 * @param start
 * @param limit
 * @return
 */
    public List queryythd(int num, int start, int limit,String xknum)
    {

        StringBuffer sql=new StringBuffer("SELECT h.*,s.jsxm from xkjs_ythd h ,jsb s  where h.fqr=s.jsbh");
    if (num>0)
  {
      sql.append(" and  HDBH=");
      sql.append(num);
  }
    if (xknum!=null&&!"".equals(xknum))
    {
        sql.append(" and s.rjkm=");
        sql.append(xknum);
    }
    
    sql.append(" ORDER BY cjsj desc");
    sql.append(" limit ");
    sql.append(start);
    sql.append(",");
    sql.append(limit);
      return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());
    
    }
/**
 * 查询学科博客
 * @param num
 * @param i
 * @param start
 * @param limit
 * @return
 */
public List queryxkbk(  int start, int limit,String xknum)
{

    StringBuffer sql=new StringBuffer("SELECT bk.bkbh,bk.bkbt,bk.bknr,bk.fbr,bk.djs,bk.bkfl,bk.bkzt,DATE_FORMAT(bk.fbsj,'%Y-%m-%d %H:%i') fbsj,b.jsxm,f.flmc FROM xkjs_xkbk bk,xkjs_xkbk_fl f,jsb b  WHERE bk.fbr=b.jsbh AND bk.bkfl=f.flbh");
if (!Utils.isNull(xknum))
{
    sql.append(" and b.rjkm=");
    sql.append(xknum);
}

sql.append(" ORDER BY fbsj desc");
sql.append(" limit ");
sql.append(start);
sql.append(",");
sql.append(limit);
  return jdbcBaseDao.getJdbcTemplate().queryForList(sql.toString());

}
/**
 * 查询学科博客
 * @param num
 * @param i
 * @param start
 * @param limit
 * @return
 */
public Map queryxkbkById(  int id)
{

    StringBuffer sql=new StringBuffer("SELECT bk.bkbh,bk.bkbt,bk.bknr,bk.fbr,bk.djs,bk.bkfl,bk.bkzt,DATE_FORMAT(bk.fbsj,'%Y-%m-%d %H:%i') fbsj,b.jsxm,f.flmc FROM xkjs_xkbk bk,xkjs_xkbk_fl f,jsb b  WHERE bk.fbr=b.jsbh AND bk.bkfl=f.flbh");
    sql.append(" and bk.bkbh=");
    sql.append(id);
  return jdbcBaseDao.getJdbcTemplate().queryForMap(sql.toString());

}
public int countnews(int type, String xknum)
{
    StringBuffer sql=new StringBuffer("SELECT count(1) from news s ,xkjs_xkb b where s.xkbh=b.xkbh");
    sql.append("  and s.type=");
    sql.append(type);
    if (xknum!=null&&!"".equals(xknum))
    {
        sql.append(" and s.xkbh=");
        sql.append(xknum);
    }
      return jdbcBaseDao.getJdbcTemplate().queryForInt(sql.toString());
}

public Map queryOneNews(int num)
{
    StringBuffer sql=new StringBuffer("SELECT * from news s  where s.id=");
    sql.append(num);
    return jdbcBaseDao.getJdbcTemplate().queryForMap(sql.toString());
}

public int countXkbk(int type, String xknum)
{
    StringBuffer sql=new StringBuffer("SELECT count(1) FROM xkjs_xkbk bk,xkjs_xkbk_fl f,jsb b  WHERE bk.fbr=b.jsbh AND bk.bkfl=f.flbh");
   
    if (xknum!=null&&!"".equals(xknum))
    {
        sql.append(" and b.rjkm=");
        sql.append(xknum);
    }
      return jdbcBaseDao.getJdbcTemplate().queryForInt(sql.toString());
}

/**
 * 根据id更新博客点击
 * @param num
 * @return
 */
public int updateXkbkDj(int num)
{
   return jdbcBaseDao.getJdbcTemplate().update("update xkjs_xkbk set djs=djs+1 where bkbh="+num);
    
}

}
