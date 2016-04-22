package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AskQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);
    }
    public void StudentHome(View view)
    {
        startActivity(new Intent(this, HomePage.class));

    }
    public void cancel(View view)
    {
        startActivity(new Intent(this,InstructorProfile.class));
    }
}
