package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultClubPost implements Result {
    public final String ClubName ;
    public final String date;
    public ResultClubPost(JSONObject json)
    {
        ClubName = json.optString("ClubName");
        date = json.optString("date");
    }
    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try{
            json.put("ClubName", ClubName);
            json.put("date", date);
        }
        catch (Exception ignore) {
        }

        return json;
    }
}
