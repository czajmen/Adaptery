package com.example.kczaja.lab6;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kczaja on 26.04.2017.
 */

public class GroupListActivity extends AppCompatActivity {

    private ArrayAdapter<entry> mAdapter;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        initAdapter();
        initList();
    }

    private void initAdapter() {
        mAdapter = new EntryAdapter(this, R.layout.grid_item, getEntries());
    }

    private void initList() {
        mGridView = (GridView) findViewById(R.id.grid_view);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(getOnItemClickListener());
    }

    private List<entry> getEntries() {
        ArrayList<entry> entries = new ArrayList<>();
        String[] names = getArray();
        TypedArray logos = getLogos();

        for (int i = 0; i < names.length; i++) {
            entries.add(new entry(logos.getResourceId(i, 0), names[i]));
        }
        return entries;
    }

    private String[] getArray() {
        return getResources().getStringArray(R.array.images_names);
    }

    private TypedArray getLogos() {
        return getResources().obtainTypedArray(R.array.images);
    }

    private AdapterView.OnItemClickListener getOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = ((TextView) view.findViewById(R.id.name)).getText().toString();
                String result = i + " - " + text;
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        };
    }
}
