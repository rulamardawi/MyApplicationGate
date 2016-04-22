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

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class InstructorSignin extends AppCompatActivity {

    private ProgressDialog pDialog;

    public Button LoginButton;

    JSONParser jsonParser = new JSONParser();

    public static EditText instructorid;
    public static EditText password;


    // url to create new product
    private static String url_instructor_signin = "http://10.100.6.177/stdlogin.aspx";

    // JSON Node names
    private static final String TAG_RESULT = "result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signin);

        LoginButton = (Button) findViewById(R.id.loginButton);

        instructorid = (EditText) findViewById(R.id.instructorId);
        password = (EditText) findViewById(R.id.instructorPwd);



//      btnLogin.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              new CreateNewProduct().execute();
//              //new JSONTask().execute();
//          }
//      });

    }

    class Signin extends AsyncTask<String, String, String> {


        String id = instructorid.getText().toString();
        String pwd = password.getText().toString();

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(InstructorSignin.this);
            pDialog.setMessage("Authorizing..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * password Encrypting
         */
        public String md5(String s) {
            try {
                // Create MD5 Hash
                MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
                digest.update(s.getBytes());
                byte messageDigest[] = digest.digest();

                // Create Hex String
                StringBuffer hexString = new StringBuffer();
                for (int i=0; i<messageDigest.length; i++)
                    hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return "";
        }
        /**
         * Login process
         */
        protected String doInBackground(String... args) {

            pwd = md5(pwd);

            HashMap<String, String> parms = new HashMap<>();
            parms.put("StudentID", id);
            parms.put("Password", pwd);

            JSONObject json = jsonParser.makeHttpRequest(url_instructor_signin, "GET", parms);

            if (json == null)
                return "";
            try {

                String success = json.getString(TAG_RESULT);

                if (success.equals("0")) {
                    onLoginFailure();
                }
                else if (success.equals("1"))
                    onLoginSuccess();

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


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

        String id = instructorid.getText().toString();
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
    public void onLoginFailure()
    {
        startActivity(new Intent(InstructorSignin.this, Login.class));
        Toast.makeText(getApplicationContext(), "Invalid Login", Toast.LENGTH_LONG).show();
    }
    public void onLoginSuccess()
    {
        //ToDo: add Student's data to send as extra with the intent 

        startActivity(new Intent(InstructorSignin.this, HomePage.class));
        finish();
    }
}
