package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersLoadoutListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Loadout> listOfUsersLoadouts;
    //ArrayList<Primary> listOfUsersPrimaries;
    //ArrayList<Secondary> listOfUsersSecondaries;



    public UsersLoadoutListAdapter(Context c, ArrayList<Loadout> ull/*, ArrayList<Primary> ulp, ArrayList<Secondary> uls*/){
        context = c;
        listOfUsersLoadouts = ull;
        //listOfUsersPrimaries = ulp;
        //listOfUsersSecondaries = uls;
    }



    @Override
    public int getCount() {
        return listOfUsersLoadouts.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfUsersLoadouts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(viewUsersLoadouts.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.activity_users_laodout_cell, null);
        }

        TextView creator = view.findViewById(R.id.tv_v_ul_creator);
        TextView lName = view.findViewById(R.id.tv_v_ul_loadoutName);
        //TextView primary = view.findViewById(R.id.tv_v_ul_primary);
        //TextView secondary = view.findViewById(R.id.tv_v_ul_secondary);
        //TextView fUpgrade = view.findViewById(R.id.tv_v_ul_fieldUpgrade);

        Loadout loadout = listOfUsersLoadouts.get(i);


        creator.setText(loadout.getUsername());
        lName.setText(loadout.getLoadoutName());

        //primary.setText(primaries.getPrimaryName());


        //secondary.setText(secondaries.getSecondaryName());

        //fUpgrade.setText(loadout.getFieldUpgrade());


        return view;
    }
}
