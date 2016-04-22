package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultAppointment implements Result {
    public final int Std ;
    public final int instID;
    public final String date;
    public final String Time;
    public final String State;
    public  ResultAppointment(JSONObject json)
    {
        Std = json.optInt("Std");
        instID = json.optInt("instID");
        date = json.optString("date");
        Time = json.optString("Time");
        State = json.optString("State");

    }
    @Override
    public JSONObject getJson() {

        JSONObject json = new JSONObject();
        try {
            json.put("Std", Std);
            json.put("instID",instID);
            json.put("date",date);
            json.put("Time",Time);
            json.put("State",State);
        } catch (Exception ignore) {
        }
        return json;
    }
}
