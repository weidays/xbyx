package com.touch4u.common.object;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 该类用于保存form对象内容,用于java到json的转换
 * 
 * @author JerryLane
 */
public class FormObject implements IObject
{

    private boolean success;

    private Map errors = new HashMap();

    private IObject data;

    public IObject getData()
    {
        return data;
    }

    public void setData(IObject data)
    {
        this.data = data;
    }

    public Map getErrors()
    {
        return errors;
    }

    public void setErrors(Map errors)
    {
        this.errors = errors;
    }

    public void addErrors(String key, String message)
    {
        this.errors.put(key, message);
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public JSONObject toJSONObject() throws JSONException
    {
        JSONObject obj = new JSONObject();
        obj.put("success", this.success);
        JSONObject errors = new JSONObject(this.errors);
        obj.put("errors", errors);
        if (this.data != null)
            obj.put("data", this.data.toJSONObject());
        return obj;
    }
}
