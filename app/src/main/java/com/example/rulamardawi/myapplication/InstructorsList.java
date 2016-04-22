package com.example.rulamardawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class InstructorsList extends AppCompatActivity {
    private ListView instructorListView;
    private List<String> instructorItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructors_list);

        instructorListView = (ListView) findViewById(R.id.items_list);
        instructorItems = new ArrayList<>();
        instructorItems.add("Item1");
        instructorItems.add("Item1");
        instructorItems.add("Item2");
        instructorItems.add("Item2");
        instructorListView.setAdapter(new InstructorAdapter());
    }
    public View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //code to be written to handle the click event
            startActivity(new Intent(InstructorsList.this, InstructorProfile.class));

        }
    };
    private class InstructorAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return instructorItems.size();
        }

        @Override
        public Object getItem(int position) {
            return instructorItems.get(position);
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
