package com.example.rulamardawi.myapplication.server.data;

import org.json.JSONObject;

/**
 * Created by rulamardawi on 4/12/16.
 */
public class ResultMessage implements Result{
    public final int Serial ;
    public final int SenderID;
    public final int ReceiverID;
    public final String MessageData;

    public ResultMessage(JSONObject json)
    {
        Serial = json.optInt("Serial");
        SenderID = json.optInt("SenderID");
        ReceiverID = json.optInt("RecieverID");
        MessageData = json.optString("MessageData");

    }
    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("Serial",Serial);
            json.put("SenderID",SenderID);
            json.put("ReceiverID",ReceiverID);
            json.put("MessageData",MessageData);

        }
        catch (Exception ignore)
        {

        }
        return json;
    }
}
