package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class Market extends AppCompatActivity {

    private ListView marketListView;
    private List<String> marketItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        marketListView = (ListView) findViewById(R.id.market_list_view);
        marketItems = new ArrayList<>();
        marketItems.add("Item1");
        marketItems.add("Item1");
        marketItems.add("Item2");
        marketItems.add("Item2");
        marketListView.setAdapter(new MarketAdapter());
       final Intent marketIntent = new Intent(this, AddItemToMarketForm.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(marketIntent);
            }
        });



    }

    private class MarketAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return marketItems.size();
        }

        @Override
        public Object getItem(int position) {
            return marketItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View Item = getLayoutInflater().inflate(R.layout.market_item,null);
            return Item;
        }
    }

    public void StudentHome(View view) {
        startActivity(new Intent(this, HomePage.class));

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HomePage.class));
        //moveTaskToBack(true);
    }
}
