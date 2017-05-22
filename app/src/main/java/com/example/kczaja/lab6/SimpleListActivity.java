package com.example.kczaja.lab6;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        String[] imgsNames = getResources().getStringArray(R.array.images_names);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, imgsNames);

        final ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int itemPosition     = i;
                String  itemValue    = (String) listView.getItemAtPosition(i);

                Toast.makeText(getApplicationContext(),
                        "Pozycja :"+itemPosition+" "+itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });

    }
}
