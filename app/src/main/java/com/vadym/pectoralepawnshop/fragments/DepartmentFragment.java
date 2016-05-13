package com.vadym.pectoralepawnshop.fragments;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vadym.pectoralepawnshop.activities.DetailTopicsActivity;
import com.vadym.pectoralepawnshop.activities.MapsActivity;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;

public class DepartmentFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(com.vadym.pectoralepawnshop.R.array.departments));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        Toast.makeText(getActivity(), "Item " + pos + " was clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        getActivity().startActivity(intent);
    }
}
