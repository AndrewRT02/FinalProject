package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoadoutListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Loadout> listOfLoadouts;


    public LoadoutListAdapter(Context c, ArrayList<Loadout> ls){
        context = c;
        listOfLoadouts = ls;
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

        TextView creator = view.findViewById(R.id.tv_v_cc_creator);
        TextView lName = view.findViewById(R.id.tv_v_cc_loadoutName);
        TextView primary = view.findViewById(R.id.tv_v_cc_primary);
        TextView secondary = view.findViewById(R.id.tv_v_cc_secondary);
        TextView melee = view.findViewById(R.id.tv_v_cc_melee);
        TextView fUpgrade = view.findViewById(R.id.tv_v_cc_fieldUpgrade);

        Loadout loadout = listOfLoadouts.get(i);

        creator.setText(loadout.getUsername());

        return view;
    }
}
