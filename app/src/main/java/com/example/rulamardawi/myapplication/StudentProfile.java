package com.example.rulamardawi.myapplication;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StudentProfile extends AppCompatActivity {

    TextView name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);



  }
    public void StudentHome(View view)
    {
        startActivity(new Intent(this, HomePage.class));

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HomePage.class));
        //moveTaskToBack(true);
    }
}
