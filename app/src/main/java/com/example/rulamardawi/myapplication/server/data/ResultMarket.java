package com.example.rulamardawi.myapplication.server.data;

import com.example.rulamardawi.myapplication.server.data.Result;

import java.lang.String;
import java.security.PublicKey;
import java.sql.ResultSet;
import org.json.JSONObject;
public class  ResultMarket implements Result
{
    public final String name;
    public final int id;
    public final String image;
    public final String category;
    public final int price;
    public final int owner;
    public  ResultMarket(JSONObject json)
    {
        id = json.optInt("id");
        name = json.optString("name");
        category = json.optString("category");
        price = json.optInt("price");
        owner = json.optInt("owner");
        image = json.optString("image");
    }
    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("id", id);
            json.put("category", category);
            json.put("price", price);
            json.put("image", image);
            json.put("owner", owner);
        } catch (Exception ignore) {
        }
        return json;
    }
}