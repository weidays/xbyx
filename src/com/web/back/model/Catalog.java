package com.web.back.model;

import org.json.JSONException;
import org.json.JSONObject;
import com.touch4u.common.object.IObject;

public class Catalog implements IObject
{
    private String resstr;

    private String parentstr;

    private String resname;

    private String iconcls;

    private String url;

    private String comments;

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getIconcls()
    {
        return iconcls;
    }

    public void setIconcls(String iconcls)
    {
        this.iconcls = iconcls;
    }

    public String getParentstr()
    {
        return parentstr;
    }

    public void setParentstr(String parentstr)
    {
        this.parentstr = parentstr;
    }

    public String getResname()
    {
        return resname;
    }

    public void setResname(String resname)
    {
        this.resname = resname;
    }

    public String getResstr()
    {
        return resstr;
    }

    public void setResstr(String resstr)
    {
        this.resstr = resstr;
    }

    public JSONObject toJSONObject() throws JSONException
    {
        JSONObject obj = new JSONObject();
        obj.put("resstr", this.resstr);
        obj.put("parentstr", this.parentstr);
        obj.put("resname", this.resname);
        obj.put("iconcls", this.iconcls);
        obj.put("url", this.url);
        obj.put("comments", this.comments);
        return obj;
    }

}
