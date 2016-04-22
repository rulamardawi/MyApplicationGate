package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void toSignup(View view)
    {

        startActivity(new Intent(this, Signup.class));
    }
    public void toLogin(View view)
    {
        startActivity(new Intent(this,Login.class));
    }

}
