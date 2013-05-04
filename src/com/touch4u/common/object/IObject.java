package com.touch4u.common.object;

import org.json.JSONException;
import org.json.JSONObject;

public interface IObject
{
    public abstract JSONObject toJSONObject() throws JSONException;
}
