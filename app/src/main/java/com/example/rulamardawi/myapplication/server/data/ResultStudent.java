package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultStudent implements Result {
    public final int StudentID;
    public final String FirstName;
    public final String LastName;
    public final String Email;
    public final String Bio;
    public final String Image;
    public final String College;
    public final String Password;

    public ResultStudent(JSONObject json) {
        FirstName = json.optString("FirstName");
        LastName = json.optString("LastName");
        Email = json.optString("Email");
        Bio = json.optString("Bio");
        Image = json.optString("Image");
        College = json.optString("College");
        StudentID = json.optInt("StudentID");
        Password = json.optString("Password");
    }
    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("FirstName", FirstName);
            json.put("LastName", LastName);
            json.put("Email",Email);
            json.put("College", College);
            json.put("StudentID", StudentID);
            json.put("Bio", Bio);
            json.put("Image", Image);
            json.put("Password", Password);
        } catch (Exception ignore) {
        }
        return json;

    }
}
