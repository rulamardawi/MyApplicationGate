package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultEnroll implements Result {
    public final int StdID;
    public final int CoursID;
    public ResultEnroll(JSONObject json)
    {
        StdID = json.optInt("StdID");
        CoursID = json.optInt("CoursID");
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try{
            json.put("StdID",StdID);
            json.put("CoursID",CoursID);
        }
        catch (Exception ignore){}
        return json;

    }
}
