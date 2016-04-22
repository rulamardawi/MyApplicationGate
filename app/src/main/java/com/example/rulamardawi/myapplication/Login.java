package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void toStudentLogin(View view)
    {

        startActivity(new Intent(this, StudentSignin.class));
    }
    public void toInstructorLogin(View view)
    {

        startActivity(new Intent(this, InstructorSignin.class));
    }
    public void toUtilityLogin(View view)
    {

        startActivity(new Intent(this, UtilitySignin.class));
    }

}
