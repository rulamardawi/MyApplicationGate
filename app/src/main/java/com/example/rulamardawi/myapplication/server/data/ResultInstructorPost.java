package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultInstructorPost implements Result {
    public final int InsID;
    public final String date;
    public ResultInstructorPost(JSONObject json) {
        InsID = json.optInt("InsID");
        date = json.optString("date");
    }


    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();

        try{
             json.put("InsID",InsID);
            json.put("date",date);
        }
        catch (Exception ignore){}
        return json;
    }
}
