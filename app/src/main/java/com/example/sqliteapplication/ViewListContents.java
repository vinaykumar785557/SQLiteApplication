package com.example.sqliteapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DBHelper DB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontent_layout);

        ListView listView = (ListView) findViewById(R.id.listView);

        DB = new DBHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor cursor = DB.getdata();


        if(cursor.getCount() ==0){
            Toast.makeText(ViewListContents.this, "Nothing existed!", Toast.LENGTH_SHORT).show();
        }

        else {
            while(cursor.moveToNext()){
                theList.add("Name: "+cursor.getString(0)+"\n");
                theList.add("Content: "+cursor.getString(1)+"\n");
                theList.add("Date of Birth: "+cursor.getString(2)+"\n\n\n");

                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }





    }
}
