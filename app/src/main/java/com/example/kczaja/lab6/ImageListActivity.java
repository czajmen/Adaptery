package com.example.kczaja.lab6;

import android.content.res.TypedArray;
import android.icu.text.DisplayContext;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        String[] imgsNames = getResources().getStringArray(R.array.images_names);
        TypedArray imgs = getResources().obtainTypedArray(R.array.images);

        ArrayList<entry> list = new ArrayList<>();
        int i = 0;

        for(String name : imgsNames )
        {
            list.add(new entry(name, imgs.getResourceId(i,0)));
            i++;
        }

        EntryAdapter arrayAdapter = new EntryAdapter(this, R.layout.group_item, list);
        final ListView listView = (ListView)findViewById(R.id.list_item);
        listView.setAdapter(arrayAdapter);
    }
}
