package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServerResponse {
    public final String result_type;
    public final int status_code;
    public final Result[] results;
    public static final String TYPE_FACULTY = "faculty";
    public static final String TYPE_COURSE = "course";
    public static final String TYPE_CLUB = "club";
    public static final String TYPE_UTILITY = "utility";
    public static final String TYPE_INSTRUCTOR = "instructor";
    public static final String TYPE_MARKETITEMS = "marketitems";
    public static final String TYPE_LAFITEMS = "lafitems";
    public static final String TYPE_POST = "postitems";
    public static final String TYPE_STUDENT = "student";
    public static final String TYPE_APPOINTMENT = "appointment";
    public static final String TYPE_MESSAGE = "message";
    public static final String TYPE_CLUBPOST = "clubpost";
    public static final String TYPE_INSTRUCTORPOST = "instructorpost";
    public static final String TYPE_UTILITYPOST = "utilitypost";
    public static final String TYPE_TEACH = "teach";


    public ServerResponse(JSONObject json){
        result_type = json.optString("result_type").toLowerCase();//document element
        status_code = json.optInt("status_code");
        JSONArray jsonArray = json.optJSONArray("results");
        if(jsonArray == null) {
            this.results = new Result[0];
            return;
        }

        this.results = new Result[jsonArray.length()];
        for (int i = 0; i < this.results.length; i++) {
            this.results[i] = getResult(jsonArray.optJSONObject(i), result_type);
        }
    }
    public static Result getResult(JSONObject json, String type) {
        switch (type){
            case TYPE_CLUB:
                return new ResultClub(json);
            case TYPE_COURSE:
                return new ResultCourse(json);
            case TYPE_FACULTY:
                return new ResultFaculty(json);
            case TYPE_UTILITY:
                return new ResultUtility(json);
            case TYPE_INSTRUCTOR:
                return new ResultInstructor(json);
            case TYPE_MARKETITEMS:
                return new ResultMarket(json);
            case TYPE_LAFITEMS :
                return new ResultLAFitem(json);
            case TYPE_STUDENT:
                return new ResultStudent(json);
            case TYPE_APPOINTMENT:
                return new ResultAppointment(json);
            case TYPE_MESSAGE:
                return new ResultMessage(json);
            case TYPE_CLUBPOST:
                return new ResultClubPost(json);
            case TYPE_INSTRUCTORPOST:
                return  new ResultInstructorPost(json);
            case TYPE_UTILITYPOST:
                return new ResultUtilityPost(json);



        }
        return null;
    }
}