package com.example.kczaja.lab6;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kczaja on 26.04.2017.
 */

public class GroupListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        String[] imgsNames = getResources().getStringArray(R.array.category_names);
        TypedArray imgs = getResources().obtainTypedArray(R.array.images);


        ArrayList<entry> list = new ArrayList<>();
        int i = 0;

        for(String name : imgsNames )
        {
            list.add(new entry(name, imgs.getResourceId(i,0)));
            i++;
        }

       ExpandableAdapter arrayAdapter = new ExpandableAdapter(this, R.layout.list_item, list);
        final ListView listView = (ListView)findViewById(R.id.list_item);

        listView.setAdapter(arrayAdapter);
    }


}
