package com.example.rulamardawi.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;
import java.util.jar.Attributes;

public class StudentMyProfile extends AppCompatActivity {


    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();

    private static final int RESULT_LOAD_IMAGE = 1;

    ImageView profilePic;

    TextView Name ;
    TextView Bio;




    // url to create new product
    private static String url_get_student = "http://192.168.43.158/getstudent.aspx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_my_profile);


        profilePic = (ImageView) findViewById(R.id.studentProfilePicture);
         Name = (TextView) findViewById(R.id.studentName);
        Bio = (TextView) findViewById(R.id.Bio);



        new Signin().execute();

    }


   class Signin extends AsyncTask<String, String, String>{



       String name;
       String firstName;
       String lastName ;
       String bio;

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
//           pDialog = new ProgressDialog(StudentMyProfile.this);
//           pDialog.setMessage("Creating Product..");
//           pDialog.setIndeterminate(false);
//           pDialog.setCancelable(true);
//           pDialog.show();
       }

       protected String doInBackground(String... args) {

           HashMap<String, String> parms = new HashMap<>();
           parms.put("StudentID", "1234");

           JSONObject json = jsonParser.makeHttpRequest(url_get_student,"GET",parms);

           if (json == null)
               return "";
           try {

                firstName = json.getString("FirstName");
               lastName = json.getString("LastName");
               bio = json.getString("Bio");



               StudentMyProfile.this.runOnUiThread(new Runnable() {
                   public void run() {
                       name = firstName+""+lastName;
                       Name.setText(name);
                       Bio.setText(bio);
                   }
               });





           } catch (JSONException e) {
               e.printStackTrace();
           }

           return null;
           }

       @Override
       protected void onProgressUpdate(String... values) {
           super.onProgressUpdate(values);
//           Name.setText(firstName);
       }
   }




    public void editImage(View v)
    {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null)
        {
            Uri SelectedImage = data.getData();
            profilePic.setImageURI(SelectedImage);


        }
    }
    public void StudentHome(View view)
    {
        startActivity(new Intent(this, HomePage.class));

    }
}
