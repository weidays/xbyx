package com.touch4u.common.util;

import java.util.Collection;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.omg.CORBA.SystemException;

public class JSONFormat
{

    /**
     * 将实现IObject接口的java集合转换为JSONArray对象
     * 
     * @param c
     * @return
     * @throws SystemException
     */
    public static JSONArray toJSONArray(Collection c) throws  JSONException
    {
        JSONArray jsonArray = new JSONArray();
        for (Iterator it = c.iterator(); it.hasNext();)
        {
            Object o = it.next();
            jsonArray.put(JsonUtil.toJSONObject(o));
        }
        return jsonArray;
    }
}
