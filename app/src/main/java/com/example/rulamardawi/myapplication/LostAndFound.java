package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LostAndFound extends AppCompatActivity {

    private ListView LostAndFoundListView;
    private List<String> LostAndFoundItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_found);
        LostAndFoundListView = (ListView) findViewById(R.id.laf_list_view);
        LostAndFoundItems = new ArrayList<>();
        LostAndFoundItems.add("Item1");
        LostAndFoundItems.add("Item1");
        LostAndFoundItems.add("Item2");
        LostAndFoundItems.add("Item2");
        LostAndFoundListView.setAdapter(new LostAndFoundAdapter());
        final Intent LostAndFoundIntent = new Intent(this, AddItemToLAFForm.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(LostAndFoundIntent);
            }
        });



    }

    private class LostAndFoundAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return LostAndFoundItems.size();
        }

        @Override
        public Object getItem(int position) {
            return LostAndFoundItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View Item = getLayoutInflater().inflate(R.layout.lost_item,null);
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
