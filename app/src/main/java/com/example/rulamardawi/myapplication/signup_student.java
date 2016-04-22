package com.example.rulamardawi.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class signup_student extends AppCompatActivity {

    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();

    // url to create new account
    private static String url_create_account = "http://192.168.43.158/stdlogin.aspx";

    ArrayList mSelectedItems;

    EditText chooseClubs;
    EditText chooseCourses;

   public String firstName;
   public String id ;
   public String lastName;
   public String email;
   public String college;
   public String password;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_student);

        chooseClubs = (EditText) findViewById(R.id.chooseClubs);
        chooseCourses = (EditText) findViewById(R.id.chooseCourses);

//        Intent i = getIntent();
//        id = i.getStringExtra("id");
//        firstName = i.getExtras().getString("firstname");
//        lastName = i.getExtras().getString("lastname");
//        email = i.getExtras().getString("email");
//        password =i.getExtras().getString("pwd");



    }


    public void clubsAlert(View v) {

        // where we will store or remove selected items
        mSelectedItems = new ArrayList<Integer>();

        AlertDialog.Builder builder = new AlertDialog.Builder(signup_student.this);

        // set the dialog title
        String[] clubsItems = new String[]{"IEEE", "Marje3", "DART", "نون"};
        builder.setTitle("Clubs:")


                // specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive call backs when items are selected
                // R.array.choices were set in the resources res/values/strings.xml
                .setMultiChoiceItems(clubsItems, null, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if (isChecked) {
                            // if the user checked the item, add it to the selected items
                            mSelectedItems.add(which);
                        } else if (mSelectedItems.contains(which)) {
                            // else if the item is already in the array, remove it
                            mSelectedItems.remove(Integer.valueOf(which));
                        }

                        // you can also add other codes here,
                        // for example a tool tip that gives user an idea of what he is selecting
                        // showToast("Just an example description.");
                    }

                })

                        // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        // user clicked OK, so save the mSelectedItems results somewhere
                        // here we are trying to retrieve the selected items indices
                        String selectedIndex = "";
                        for (Object i : mSelectedItems) {
                            selectedIndex += i + ", ";
                        }

                        //showToast("Selected index: " + selectedIndex);

                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                }).create();

        builder.show();

    }

    public void coursesAlert(View v) {

        // where we will store or remove selected items
        mSelectedItems = new ArrayList<Integer>();

        AlertDialog.Builder builder = new AlertDialog.Builder(signup_student.this);

        // set the dialog title
        String[] coursesItems = new String[]{"JAVA", "Database", "Algorithms", "C++"};
        builder.setTitle("Courses")


                // specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive call backs when items are selected
                // R.array.choices were set in the resources res/values/strings.xml
                .setMultiChoiceItems(coursesItems, null, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if (isChecked) {
                            // if the user checked the item, add it to the selected items
                            mSelectedItems.add(which);
                        } else if (mSelectedItems.contains(which)) {
                            // else if the item is already in the array, remove it
                            mSelectedItems.remove(Integer.valueOf(which));
                        }

                        // you can also add other codes here,
                        // for example a tool tip that gives user an idea of what he is selecting
                        // showToast("Just an example description.");
                    }

                })

                        // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        // user clicked OK, so save the mSelectedItems results somewhere
                        // here we are trying to retrieve the selected items indices
                        String selectedIndex = "";
                        for (Object i : mSelectedItems) {
                            selectedIndex += i + ", ";
                        }

                        //showToast("Selected index: " + selectedIndex);

                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                }).create();

        builder.show();

    }

    public void submit(View view){
//        new Signup().execute();

    }

    class Signup extends AsyncTask<String, String, String> {


        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(signup_student.this);
            pDialog.setMessage("Authorizing..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        /**
         * ceating account
         */
        protected String doInBackground(String... args) {

//            Intent i = getIntent();
//            id = i.getStringExtra("id");
//            firstName = i.getExtras().getString("firstname");
//            lastName = i.getExtras().getString("lastname");
//            email = i.getExtras().getString("email");
//            password =i.getExtras().getString("pwd");

            HashMap<String, String> parms = new HashMap<>();

            parms.put("StudentID",id);
            parms.put("FirstName", firstName);
            parms.put("LastName", lastName);
            parms.put("College", "kdkj");
            parms.put("Email", email);
            parms.put("Password", password);

            JSONObject json = jsonParser.makeHttpRequest(url_create_account, "GET", parms);

            if (json==null)
                return "";
            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt("result");

                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), Signup.class);
                    startActivity(i);
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;


        }
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }
//    class Signin extends AsyncTask<String, String, String> {
//
//
//        String id = instructorid.getText().toString();
//        String pwd = password.getText().toString();
//
//        @Override
//        protected String doInBackground(String... params) {
//            return null;
//        }
//
//        /**
//         * Before starting background thread Show Progress Dialog
//         */
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pDialog = new ProgressDialog(InstructorSignin.this);
//            pDialog.setMessage("Authorizing..");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.show();
//        }

    }
}
