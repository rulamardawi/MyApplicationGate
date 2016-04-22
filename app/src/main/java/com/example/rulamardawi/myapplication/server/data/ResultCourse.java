package com.example.rulamardawi.myapplication.server.data;

import com.example.rulamardawi.myapplication.server.data.Result;
import org.json.JSONObject;

public class ResultCourse implements Result {
    public final String name;
    public final String desc;
    public final int id;
    public final String image;

    public ResultCourse(JSONObject json) {
        name = json.optString("name");
        desc = json.optString("desc");
        id = json.optInt("id");
        image = json.optString("image");
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("desc", desc);
            json.put("id", id);
            json.put("image", image);
        } catch (Exception ignore) {
        }
        return json;
    }
}