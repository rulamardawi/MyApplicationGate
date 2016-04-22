package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddItemToMarketForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_market_form);
    }
    public void StudentHome(View view)
    {
        startActivity(new Intent(this, HomePage.class));

    }
    public void cancel(View view)
    {
        startActivity(new Intent(this, Market.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Market.class));
        //moveTaskToBack(true);
    }
}
