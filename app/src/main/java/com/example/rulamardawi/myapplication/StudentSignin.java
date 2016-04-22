package com.example.rulamardawi.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rulamardawi.myapplication.server.data.ResultStudent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class StudentSignin extends AppCompatActivity {

    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();

    EditText studentId;
    EditText password;


    // url to create new product
    private static String url_create_product = "http://192.168.43.158/stdlogin.aspx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signin);

        studentId = (EditText) findViewById(R.id.studentId);
        password = (EditText) findViewById(R.id.studentPwd);

    }
    public void doLogIn(View view)
    {
        if (!validate())
            onInvalidLogin();
        else if (validate())
            onValidLogin();

    }

    public boolean validate()
    {
        boolean valid = true;

        String id = studentId.getText().toString();
        String pwd = password.getText().toString();


        if(id.isEmpty() || pwd.isEmpty())

            valid = false;


        return valid;
    }
    public void onInvalidLogin() {
        Toast.makeText(getApplicationContext(), "All filelds must be filled...", Toast.LENGTH_LONG).show();
    }
    public void onValidLogin(){
      new Signin().execute();
    }


    class Signin extends AsyncTask<String, String, String> {


        String id = studentId.getText().toString();
        String pwd = password.getText().toString();

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(StudentSignin.this);
            pDialog.setMessage("Authorizing..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * password Encrypting
         */
//        public String md5(String s) {
//            try {
//                // Create MD5 Hash
//                MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
//                digest.update(s.getBytes());
//                byte messageDigest[] = digest.digest();
//
//                // Create Hex String
//                StringBuffer hexString = new StringBuffer();
//                for (int i=0; i<messageDigest.length; i++)
//                    hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
//                return hexString.toString();
//
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//            return "";
//        }
        /**
         * Login process
         */
        protected String doInBackground(String... args) {


            HashMap<String, String> parms = new HashMap<>();
            parms.put("StudentID", id);
            parms.put("Password", pwd);

            JSONObject json = jsonParser.makeHttpRequest(url_create_product,"GET",parms);


            if (json == null)
                return "";
            try{

                String success = json.getString("result");

                if(success.equals("0"))
                    startActivity(new Intent(StudentSignin.this, Login.class));
                    // Toast.makeText(getApplicationContext(), "result = 0", Toast.LENGTH_LONG).show();
                else  if(success.equals("1")) {
                    Intent i =  new Intent(StudentSignin.this, StudentMyProfile.class);

                    startActivity(i);


                }
                finish();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


    }


}
