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

public class CourseList extends AppCompatActivity {
    private ListView courseListView;
    private List<String> courseItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);


        courseListView = (ListView) findViewById(R.id.items_list);
        courseItems = new ArrayList<>();
        courseItems.add("Item1");
        courseItems.add("Item1");
        courseItems.add("Item2");
        courseItems.add("Item2");
        courseListView.setAdapter(new CourseAdapter());
    }
    public View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //code to be written to handle the click event
            startActivity(new Intent(CourseList.this, Course.class));

        }
    };
    private class CourseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return courseItems.size();
        }

        @Override
        public Object getItem(int position) {
            return courseItems.get(position);
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
