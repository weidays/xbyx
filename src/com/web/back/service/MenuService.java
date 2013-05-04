package com.web.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.SystemException;

import com.web.back.dao.MenuDAO;
import com.web.back.model.Catalog;

public class MenuService 
{

    private MenuDAO menuDAO;

    public MenuDAO getMenuDAO()
    {
        return menuDAO;
    }

    public void setMenuDAO(MenuDAO menuDAO)
    {
        this.menuDAO = menuDAO;
    }

    /**
     * 获取用户具有访问权限的菜单
     * 
     * @param menuId
     * @return List
     * @throws SystemException
     */
    public List getMenus(Integer menuId) throws Exception
    {
        List list = new ArrayList();
        List listRel = menuDAO.getMenus(menuId);
        for(int i = 0 ; i < listRel.size() ; i++)
        {
            Map menu = (Map) listRel.get(i);
            Catalog br = new Catalog();
            String menuID = menu.get("menu_id").toString();
            System.out.println(menuID);
            br.setResstr(menuID);
            String parentMenuID = menu.get("PARENT_MENU_ID").toString();
            if("0".equals(parentMenuID)) parentMenuID ="";
            br.setParentstr(parentMenuID);
            String menuName = menu.get("MENU_NAME").toString();
            br.setResname(menuName);
            String iconcls = menu.get("ICONCLS").toString();
            br.setIconcls(iconcls);
            String url = menu.get("URL").toString();
            br.setUrl(url);
            br.setComments("");
            list.add(br);
        }

        return list;
    }
}

