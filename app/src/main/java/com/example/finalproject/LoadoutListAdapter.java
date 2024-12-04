package com.example.finalproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoadoutListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Loadout> listOfLoadouts;
    ArrayList<Primary> listOfPrimaries;
    ArrayList<Secondary> listOfSecondaries;
    ArrayList<LoadoutRating> listOfLoadoutRatings;

    public LoadoutListAdapter(Context c, ArrayList<Loadout> ll, ArrayList<Primary> lp, ArrayList<Secondary> ls, ArrayList<LoadoutRating> llr){
        context = c;
        listOfLoadouts = ll;
        listOfPrimaries = lp;
        listOfSecondaries = ls;
        listOfLoadoutRatings = llr;
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
        TextView fUpgrade = view.findViewById(R.id.tv_v_cc_fieldUpgrade);

        Loadout loadout = listOfLoadouts.get(i);
        Primary primaries = listOfPrimaries.get(i);
        Secondary secondaries = listOfSecondaries.get(i);

        //Log.d("Blueberry", listOfLoadouts.get(i).loadoutName);


        creator.setText(loadout.getUsername());
        lName.setText(loadout.getLoadoutName());
        primary.setText(primaries.getPrimaryName());
        secondary.setText(secondaries.getSecondaryName());
        fUpgrade.setText(loadout.getFieldUpgrade());

        return view;
    }
}
