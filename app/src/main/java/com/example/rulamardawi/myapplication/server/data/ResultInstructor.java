package com.example.rulamardawi.myapplication.server.data;
import java.lang.String;
import java.security.PublicKey;
import java.sql.ResultSet;
import org.json.JSONObject;
public class  ResultInstructor implements Result
{
    public final String name;
    public final int id;
    public final String image;
    public final String email;
    public final String bio;
    public final String officeNumber;
    public final String officeHours;
    public final String password;
    public  ResultInstructor (JSONObject json)
    {
        id = json.optInt("id");
        name = json.optString("name");
        image = json.optString("image");
        email = json.optString("email");
        bio = json.optString("bio");
        officeNumber = json.optString("officeNumber");
        officeHours = json.optString("officeHours");
        password = json.optString("password");
    }
    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("id", id);
            json.put("email", email);
            json.put("bio", bio);
            json.put("image", image);
            json.put("officeNumber", officeNumber);
            json.put("officeHours", officeHours);
            json.put("password", password);
        } catch (Exception ignore) {
        }
        return json;
    }
}