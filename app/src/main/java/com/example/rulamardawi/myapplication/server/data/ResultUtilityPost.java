package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultUtilityPost implements Result {
    public final int UtilityID;
    public final String Date;
    public ResultUtilityPost (JSONObject json)
    {
        UtilityID = json.optInt("UtilityID");
        Date = json.optString("Date");
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try{
            json.put("UtilityID",UtilityID);
            json.put("Date",Date);
        }
        catch (Exception ignore){}
        return json;
    }
}
