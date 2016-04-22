package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InstructorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_profile);
    }
    public void StudentHome(View view)
    {
        startActivity(new Intent(this, HomePage.class));

    }

    public void getAppointment(View view)
    {
        startActivity(new Intent(this,Appointments.class));
    }
    public void askQuestion(View view)
    {
        startActivity(new Intent(this,AskQuestion.class));
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, InstructorsList.class));
        //moveTaskToBack(true);
    }
}
