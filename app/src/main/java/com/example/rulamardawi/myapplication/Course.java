package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Course extends AppCompatActivity {
    Button enrolled ;
    Button enroll;
    EditText post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        post = (EditText) findViewById(R.id.post);
        enroll = (Button)findViewById(R.id.enroll);
    }
    public void enroll(View view)
    {

        post.setVisibility(view.VISIBLE);

        enroll.setText("Enrolled");
    }
    public void enrolled(View view)
    {
        enrolled.setVisibility(view.INVISIBLE);
        post.setVisibility(view.INVISIBLE);
        enroll.setVisibility(view.VISIBLE);

    }
    public void StudentHome(View view)
    {
        startActivity(new Intent(this, HomePage.class));

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, CourseList.class));
        //moveTaskToBack(true);
    }
}
