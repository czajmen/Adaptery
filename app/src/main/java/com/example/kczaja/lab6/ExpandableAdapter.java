package com.example.kczaja.lab6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kczaja on 26.04.2017.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private List<entry> entries;
    private LayoutInflater mInflater;

    public ExpandableAdapter(Context context, List<entry> entries) {
        this.entries = entries;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return entries.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return entries.get(groupPosition).getTab().length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return entries.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return entries.get(groupPosition).getTab()[childPosition];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int position, boolean b, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.group_item, parent, false);
        }

        TextView groupNameTextView = (TextView) convertView.findViewById(R.id.textViewgroup);
        ImageView logo = (ImageView) convertView.findViewById(R.id.imageView);

        entry entry = (entry) getGroup(position);
        groupNameTextView.setText(entry.getName());
        logo.setImageResource(entry.getLogo());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup parent) {
        int layoutId = childPosition % 2 == 0 ? R.layout.left_item : R.layout.right_item;
        convertView = mInflater.inflate(layoutId, parent, false);

        TextView childNameTextView = (TextView) convertView.findViewById(R.id.childName);

        childNameTextView.setText((String) getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}

