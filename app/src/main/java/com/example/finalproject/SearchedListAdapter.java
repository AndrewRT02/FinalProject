package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.sql.Array;
import java.util.ArrayList;

public class SearchedListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Loadout> listOfLoadouts;

    public SearchedListAdapter(Context c, ArrayList<Loadout> lA){
        context = c;
        listOfLoadouts = lA;
    }

    @Override
    public int getCount() {
        return listOfLoadouts.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfLoadouts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(viewLoadouts.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.activity_custom_cell, null);
        }



        return view;
    }
}
