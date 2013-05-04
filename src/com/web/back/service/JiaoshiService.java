package com.web.back.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touch4u.common.object.FormObject;
import com.touch4u.common.util.ServletTool;
import com.web.back.dao.JiaoshiDao;
import com.web.back.model.Jiaoshi;
@Service
public class JiaoshiService
{
    @Autowired
    private JiaoshiDao jiaoshiDao;
    

    public Jiaoshi loginJudge(String userId, String password)
    {
        List list = jiaoshiDao.getJiaoshibydlzh(userId);
        Jiaoshi jiaoshi= new Jiaoshi();
        // 用户不存在
        if (null == list || list.size() < 1)
        {
            return null;
        }
        else
        {
            
            for (int i = 0; i < list.size(); i++)
            {
                Map jiaoshiM = (Map) list.get(i);
                int jsbh= Integer.parseInt(jiaoshiM.get("jsbh")+"");
                jiaoshi.setJsbh(jsbh);
                jiaoshi.setDlmm(jiaoshiM.get("dlmm")+"");
                jiaoshi.setDlzh(jiaoshiM.get("dlzh")+"");
                jiaoshi.setJstx(jiaoshiM.get("jstx")+"");
                jiaoshi.setJsxm(jiaoshiM.get("jsxm")+"");
            }
            if (!password.equals(jiaoshi.getDlmm()))
            {
               return null;
                
            }
            else
            {
              return jiaoshi;
            }
        }
    }


    public int registJiaoshi(Jiaoshi js)
    {
        int x=jiaoshiDao.registJiaoshi(js);
        return x;
    }

}
