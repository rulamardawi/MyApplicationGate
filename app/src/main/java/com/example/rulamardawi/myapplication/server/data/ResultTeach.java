package com.example.rulamardawi.myapplication.server.data;

import com.example.rulamardawi.myapplication.Course;

import org.json.JSONObject;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultTeach implements Result{
    public static int CourseID;
    public static int  InstructorID;

    public void ResultTeach(JSONObject json)
    {
        CourseID = json.optInt("CourseID");
        InstructorID = json.optInt("InstructorID");

    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try{
            json.put("CourseID",CourseID);
            json.put("InstructorID",InstructorID);
        }
        catch (Exception ignore){}
        return json;
    }
}
