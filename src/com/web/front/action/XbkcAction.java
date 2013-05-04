package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseNaviAction;
import com.web.back.model.Xbkc;
import com.web.front.service.XbkcService;

public class XbkcAction extends BaseNaviAction
{

    @Autowired
    private XbkcService xbkcService;

    private List<Xbkc> list;

    private Xbkc xbkc;

    private String keyword;

    private Integer page = 1;
    private Integer pageSize = 5;
    private Integer pageCount = 0;

    public String index()
    {
        list = xbkcService.list(keyword, page, pageSize);
        Integer count = xbkcService.count(keyword);
        pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0);
        this.setNavi("xbkc");
        return SUCCESS;
    }

    public String gotoUploadPage()
    {
        this.setNavi("xbkc");
        return SUCCESS;
    }

    public String save()
    {
        xbkcService.save(xbkc);
        this.setNavi("xbkc");
        return SUCCESS;
    }

    /**
     * @return the list
     */
    public List<Xbkc> getList()
    {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Xbkc> list)
    {
        this.list = list;
    }

    /**
     * @return the xbkc
     */
    public Xbkc getXbkc()
    {
        return xbkc;
    }

    /**
     * @param xbkc the xbkc to set
     */
    public void setXbkc(Xbkc xbkc)
    {
        this.xbkc = xbkc;
    }

    /**
     * @return the keyword
     */
    public String getKeyword()
    {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    /**
     * @return the page
     */
    public Integer getPage()
    {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page)
    {
        this.page = page;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize()
    {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageCount
     */
    public Integer getPageCount()
    {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(Integer pageCount)
    {
        this.pageCount = pageCount;
    }

    // ========================================================
    // ========================================================

}
