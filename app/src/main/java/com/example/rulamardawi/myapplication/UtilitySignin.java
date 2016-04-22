package com.example.rulamardawi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class UtilitySignin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility_signin);

        Spinner utilitySpinner = (Spinner)findViewById(R.id.utility);
        String[] utilityItems = new String[]{"Library",
                "Cafeteria", "Gym"};
        ArrayAdapter<String> utilityAdapter = new ArrayAdapter<String>(this,  R.layout.spinner_item, utilityItems);
        utilitySpinner.setAdapter(utilityAdapter);
    }
}
