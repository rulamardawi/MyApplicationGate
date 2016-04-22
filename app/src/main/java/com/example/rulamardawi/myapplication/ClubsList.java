package com.example.rulamardawi.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ClubsList extends AppCompatActivity {
    private ListView clubListView;
    private List<String> clubItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_list);

        clubListView = (ListView) findViewById(R.id.items_list);
        clubItems = new ArrayList<>();
        clubItems.add("Item1");
        clubItems.add("Item1");
        clubItems.add("Item2");
        clubItems.add("Item2");
        clubListView.setAdapter(new ClubAdapter());


    }
    public View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //code to be written to handle the click event
            startActivity(new Intent(ClubsList.this, Club.class));

        }
    };

    private class ClubAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return clubItems.size();
        }

        @Override
        public Object getItem(int position) {
            return clubItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View Item = getLayoutInflater().inflate(R.layout.list_item,null);
            Item.setClickable(true);
            Item.setOnClickListener(myClickListener);
            return Item;
        }
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
