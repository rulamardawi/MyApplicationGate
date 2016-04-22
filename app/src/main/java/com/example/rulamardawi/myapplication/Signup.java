package com.example.rulamardawi.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import org.json.JSONObject;

import java.security.PublicKey;
import java.util.HashMap;

public class Signup extends AppCompatActivity {
    private ProgressDialog pDialog;


    JSONParser jsonParser = new JSONParser();

    // url to create new product
    private static String url_create_product = "http://192.168.43.158/signupInstructor.aspx";
    private static String url_create_student = "http://192.168.43.158/stdsignup.aspx";

     EditText universityId;
     EditText firstName;
     EditText lastName;
     EditText email;
     EditText password;
     EditText reEnteredPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        universityId = (EditText) findViewById(R.id.universityId);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        reEnteredPassword = (EditText) findViewById(R.id.reEnteredPassword);

        Spinner facultySpinner = (Spinner) findViewById(R.id.faculty);
        String[] facultyItems = new String[]{"It","Engineering","Buiseness"};

        ArrayAdapter<String> faccultyAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, facultyItems);
        facultySpinner.setAdapter(faccultyAdapter);
    }
    public void signUp(View view)
    {
        String id = universityId.getText().toString();
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String mail = email.getText().toString();
        String pwd1 = password.getText().toString();
        String pwd2 = reEnteredPassword.getText().toString();
        //TODo: validation
        toNextSignup(view);
    }
    public void toNextSignup(View view)
    {
        RadioButton student = (RadioButton) findViewById(R.id.studentRadioButton);
        RadioButton instructor = (RadioButton) findViewById(R.id.instructorRadioButton);

        if (student.isChecked() == true)
        {
            new SignupStudent().execute();
        }
        else if(instructor.isChecked() == true)
        {

        new SignupInstructor().execute();
        }
    }

    class SignupInstructor extends AsyncTask<String, String, String>{

        String id = universityId.getText().toString();
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String mail = email.getText().toString();
        String pwd1 = password.getText().toString();
        String pwd2 = reEnteredPassword.getText().toString();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Signup.this);
            pDialog.setMessage("Creating Account...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
        }

        @Override
        protected String doInBackground(String... args) {


            HashMap<String, String> parms = new HashMap<>();
//            parms.put("StudentID", id);
//            parms.put("FirstName", fname);
            parms.put("InstructorID", id);
            parms.put("FirstName",fname);
            parms.put("LastName",lname);
            parms.put("Email",mail);
            parms.put("Password",pwd1);


            JSONObject json = jsonParser.makeHttpRequest(url_create_product,"GET",parms);
            if (json == null)
                return"";
            return null;
        }
    }


    class SignupStudent extends AsyncTask<String, String, String>{

        String id = universityId.getText().toString();
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String mail = email.getText().toString();
        String pwd1 = password.getText().toString();
        String pwd2 = reEnteredPassword.getText().toString();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Signup.this);
            pDialog.setMessage("Creating Account...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
        }

        @Override
        protected String doInBackground(String... args) {


            HashMap<String, String> parms = new HashMap<>();
//            parms.put("StudentID", id);
//            parms.put("FirstName", fname);
            parms.put("StudentID", id);
            parms.put("FirstName",fname);
            parms.put("LastName",lname);
            parms.put("Email",mail);
            parms.put("Password",pwd1);


            JSONObject json = jsonParser.makeHttpRequest(url_create_student,"GET",parms);
            if (json == null)
                return"";
            return null;
        }
    }


}
