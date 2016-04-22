package com.example.rulamardawi.myapplication.server.data;
import java.lang.String;
import java.sql.ResultSet;
import org.json.JSONObject;
public class  ResultUtility implements Result
{
    public final int id ;
    public final String name ;
    public final String description;
    public final int rate;
    public final String image;
    public final String username;
    public final String password;
    public  ResultUtility(JSONObject json)
    {
        id = json.optInt("id");
        name = json.optString("name");
        description = json.optString("description");
        rate = json.optInt("rate");
        image = json.optString("image");
        username = json.optString("username");
        password = json.optString("password");
    }
    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("id", id);
            json.put("description", description);
            json.put("rate", rate);
            json.put("image", image);
            json.put("username", username);
            json.put("password", password);
        } catch (Exception ignore) {
        }
        return json;
    }
}