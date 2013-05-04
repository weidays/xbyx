package com.web.front.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touch4u.common.BaseDao;

@Service("beikeService")
public class BeikeService extends BaseDao
{
    @Transactional
    public int saveBeike(final int xkbh,final int fqr,String[] str, final String bkmc,final String bknr, String fjdz,String fjmc)
    {   
//        String sql="INSERT INTO xkjs_jtbk (xkbh, bkmc,fqr,bkzt,fqsj,jssj,bkms) VALUES ('002','hello','1','1',NOW(),NOW(),'233333333333333333')";
//        int x=this.getTemplate().update(sql);
//        return x;
        final String sql = "INSERT INTO xkjs_jtbk (xkbh, bkmc,fqr,fqsj,jssj,bkms) VALUES(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
     
        getTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) {
                PreparedStatement ps = null ;
                try
                {
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, xkbh);
                    ps.setString(2, bkmc);
                    ps.setInt(3,fqr);
                    ps.setTimestamp(4, new Timestamp(new Date().getTime()));
                    ps.setTimestamp(5, new Timestamp(new Date().getTime()));
                    ps.setString(6, bknr);
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return ps;
            }
        }, keyHolder);
        
        int x= keyHolder.getKey().intValue();
         for(String s:str){
             String sql2="INSERT INTO xkjs_jtbk_cyr(bkbh,cyr,cysj) VALUES("+x+",'"+s+"',NOW())";
             this.getTemplate().update(sql2);
         }
         
         String[] fjdzs=fjdz.split("#");
         String[] fjmcs=fjmc.split("#");
         for(int i=0;i<fjdzs.length;i++){
             String sql2="INSERT INTO xkjs_jtbk_fj(bkbh,fjmc,fjdz,fjsj,scr) VALUES("+x+",'"+fjmcs[i]+"','"+fjdzs[i]+"',NOW(),'"+fqr+"')";
             this.getTemplate().update(sql2);
         }
         
        return x;
    }
    public List queryBeike(int start, int limit, String xknum)
    {
        StringBuffer sql=new StringBuffer("SELECT t1.*,t2.xkmc,t3.jsxm FROM xkjs_jtbk t1 ,xkjs_xkb t2 , jsb t3 WHERE t1.xkbh=t2.xkbh AND t1.fqr=t3.jsbh and t1.xkbh=");
        sql.append(xknum);
        sql.append(" order by t1.fqsj limit ");
        sql.append(start);
        sql.append(",");
        sql.append(limit);
        return getTemplate().queryForList(sql.toString());
    }
    public List getCyrbybh(String beikebh)
    {
        StringBuffer sql=new StringBuffer("SELECT * FROM xkjs_jtbk_cyr t1,jsb t2 WHERE t1.cyr=t2.jsbh AND bkbh=");
        sql.append(beikebh);
   
        return getTemplate().queryForList(sql.toString());
        
    }
    public List getfjbybh(String beikebh)
    {
        StringBuffer sql=new StringBuffer("SELECT * FROM xkjs_jtbk_fj t1 WHERE bkbh=");
        sql.append(beikebh);
   
        return getTemplate().queryForList(sql.toString());
        
    }
    public int countPage(int i)
    {
        String sql ="SELECT count(1) from xkjs_jtbk";
        return this.getTemplate().queryForInt(sql);
    }
    public List getBeikebybh(int bkbh)
    {
        StringBuffer sql=new StringBuffer("SELECT t1.*,t2.xkmc,t3.jsxm FROM xkjs_jtbk t1 ,xkjs_xkb t2 , jsb t3 WHERE t1.xkbh=t2.xkbh AND t1.fqr=t3.jsbh and t1.bkbh=");
        sql.append(bkbh);
        return getTemplate().queryForList(sql.toString());
        
    }
    @Transactional
    public int saveCyrBeike(int cyr, String bkbh, String bknr, String fjdz, String fjmc)
    {
       //update 参与人
        String sql2="UPDATE xkjs_jtbk_cyr SET bknr='"+bknr+"' WHERE bkbh='"+bkbh+"' AND cyr='"+cyr+"'";
        this.getTemplate().update(sql2);
        
        //insert 附件
        String[] fjdzs=fjdz.split("#");
        String[] fjmcs=fjmc.split("#");
        for(int i=0;i<fjdzs.length;i++){
            sql2="INSERT INTO xkjs_jtbk_fj(bkbh,fjmc,fjdz,fjsj,scr) VALUES("+bkbh+",'"+fjmcs[i]+"','"+fjdzs[i]+"',NOW(),'"+cyr+"')";
            this.getTemplate().update(sql2);
        }
        
        return 0;
    }
}
