package com.example.rulamardawi.myapplication.server.data;
import android.content.Context;
import android.util.Log;
import org.json.JSONObject;
import java.io.IOException;
import com.example.rulamardawi.myapplication.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Server {
    private static final String TAG = Server.class.getSimpleName();
    private OkHttpClient mClient;
    private static Server sInstance;
    public static Server getInstance() {
        if (sInstance == null)
            sInstance = new Server();
        return sInstance;
    }
    public Server() {
        mClient = new OkHttpClient();
    }
    public ServerResponse getFaculties() {
        return makeGet("http://private-c1e73-psutgate.apiary-mock.com/get-faculties.php");
    }
    public ServerResponse getClubs() {
        return makeGet("http://private-c1e73-psutgate.apiary-mock.com/get-clubs.php");
    }
    public ServerResponse getCourses() {
        return makeGet("http://private-c1e73-psutgate.apiary-mock.com/get-courses.php");
    }
    public ServerResponse getUtility() {
        return makeGet("http://private-c1e73-psutgate.apiary-mock.com/get-utility.php");
    }
    public ServerResponse getInstructors() {
        return makeGet("http://10.100.5.21/webservice1.asmx/Get_All_Instructor");
    }
    public ServerResponse getMarketItems() {
        return makeGet("http://private-c1e73-psutgate.apiary-mock.com/get-marketItems.php");
    }
    public ServerResponse getLafItems() {
        return makeGet("http://private-c1e73-psutgate.apiary-mock.com/get-lafItems.php");
    }
    public ServerResponse getStudents(){
        return makeGet("http://10.100.6.195/webservice1.asmx?op=Get_All_Student");
    }
    public ServerResponse getAppointment(){
        return makeGet("http://10.100.6.195/webservice1.asmx?op=Get_All_Appointment");

    }
    public ServerResponse getMessages(){
        return makeGet("http://10.100.6.195/webservice1.asmx?op=Get_All_Messages");
    }
    public ServerResponse getClubpost(){
        return makeGet("http://10.100.6.195/webservice1.asmx?op=Get_All_Messages");
    }
    public ServerResponse getClubPost(){
        return makeGet("");
    }



    public ServerResponse getTeach(){
        return makeGet("");
    }
    private ServerResponse makeGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        if (BuildConfig.DEBUG) Log.i(TAG, "Calling URL: " + url);
        String responseBody;
        try {
            Response response = mClient.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            if (BuildConfig.DEBUG) Log.e(TAG, "getFaculties: unable to call server", e);
            return null;
        }
        if (BuildConfig.DEBUG) Log.i(TAG, "Called URL: " + url);
        if (BuildConfig.DEBUG) Log.i(TAG, "got response: " + responseBody);
        JSONObject json;
        try {
            json = new JSONObject(responseBody);
        } catch (Exception ex) {
            if (BuildConfig.DEBUG)
                Log.e(TAG, "getFaculties: was not able to parse JSON", ex);
            return null;
        }
        return new ServerResponse(json);
    }
}
