package com.example.kczaja.lab6;

import android.app.ExpandableListActivity;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Expandable_activity extends AppCompatActivity {
    private ExpandableAdapter mAdapter;
    private ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expend_list);

        initAdapter();
        initList();
    }

    private void initAdapter() {
        mAdapter = new ExpandableAdapter(this, getEntries());
    }

    private void initList() {
        mListView = (ExpandableListView) findViewById(R.id.list_viewex);
        mListView.setAdapter(mAdapter);
        mListView.setOnGroupClickListener(getOnGroupClickListener());
        mListView.setOnChildClickListener(getOnChildClickListener());
    }

    private List<entry> getEntries() {
        ArrayList<entry> entries = new ArrayList<>();
        String[] names = getArray();
        TypedArray logos = getTypedArray(R.array.images);
        TypedArray children = getTypedArray(R.array.podKategorie);

        for (int i = 0; i < names.length; i++) {
            String[] childrenArray = getResources().getStringArray(children.getResourceId(i, -1));
            entries.add(new entry(logos.getResourceId(i, -1), names[i], childrenArray));
        }
        return entries;
    }

    private String[] getArray() {
        return getResources().getStringArray(R.array.images_names);
    }

    private TypedArray getTypedArray(int arrayId) {
        return getResources().obtainTypedArray(arrayId);
    }

    private ExpandableListView.OnGroupClickListener getOnGroupClickListener() {
        return new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                String text = ((TextView) view.findViewById(R.id.textViewgroup)).getText().toString();
                String result = i + " - " + text;
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
    }

    private ExpandableListView.OnChildClickListener getOnChildClickListener() {
        return new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String text = ((TextView) view.findViewById(R.id.childName)).getText().toString();
                String result = i + "." + i1 + " - " + text;
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
    }
}
