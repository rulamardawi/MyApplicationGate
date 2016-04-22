package com.example.rulamardawi.myapplication.server.data;
import java.lang.String;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.util.Date;

import org.json.JSONObject;

public class  ResultLAFitem implements Result
{
    public final String name;
    public final int id;
    public final String image;
    public final String date;
    public final String location;
    public final int owner;
    public final String details;

    public  ResultLAFitem(JSONObject json)
    {
        id = json.optInt("id");
        name = json.optString("name");
        date = json.optString("date");
        location = json.optString("location");
        owner = json.optInt("owner");
        image = json.optString("image");
        details = json.optString("details");
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("id", id);
            json.put("date", date);
            json.put("location",location);
            json.put("image", image);
            json.put("owner", owner);
            json.put("details", details);
        } catch (Exception ignore) {
        }
        return json;
    }


}