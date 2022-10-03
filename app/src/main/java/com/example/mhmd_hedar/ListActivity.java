package com.example.mhmd_hedar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listView);

        //make an array list
        ArrayList<String> arrayList = new ArrayList<>();

        //add items to arraylist
        arrayList.add("Banana");
        arrayList.add("watermelon");

        //initialize the adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, arrayList);

        //connect adapter to array
        listView.setAdapter(arrayAdapter);

        //handle items clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this,
                        "clicked item " + i + "" + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}