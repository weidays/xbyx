package com.web.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.touch4u.common.BaseNaviAction;
import com.web.back.model.Jypx;
import com.web.front.service.JypxService;

public class JypxAction extends BaseNaviAction
{
    private static final long serialVersionUID = -7253368493741872822L;

    @Autowired
    private JypxService jypxService;

    private List<Jypx> list;

    private Jypx jypx;

    private String pxlx;
    private String keyword;

    private Integer page = 1;
    private Integer pageSize = 5;
    private Integer pageCount = 0;

    public String index()
    {
        list = jypxService.list(pxlx, keyword, page, pageSize);
        Integer count = jypxService.count(pxlx,keyword);
        pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0);
        this.setNavi("jypx");
        return SUCCESS;

    }

    public String gotoUploadPage()
    {
        this.setNavi("jypx");
        return SUCCESS;
    }

    public String save()
    {
        jypxService.save(jypx);
        this.setNavi("jypx");
        return SUCCESS;
    }

    /**
     * @return the list
     */
    public List<Jypx> getList()
    {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Jypx> list)
    {
        this.list = list;
    }

    /**
     * @return the jypx
     */
    public Jypx getJypx()
    {
        return jypx;
    }

    /**
     * @param jypx the jypx to set
     */
    public void setJypx(Jypx jypx)
    {
        this.jypx = jypx;
    }

    /**
     * @return the pxlx
     */
    public String getPxlx()
    {
        return pxlx;
    }

    /**
     * @param pxlx the pxlx to set
     */
    public void setPxlx(String pxlx)
    {
        this.pxlx = pxlx;
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

}
