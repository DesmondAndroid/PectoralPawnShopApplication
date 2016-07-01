package com.vadym.pectoralepawnshop.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vadym.pectoralepawnshop.database.PectoraleDatabaseHelper;
import com.vadym.pectoralepawnshop.utils.CaptionedImagesAdapter;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.activities.DetailTopicsActivity;
import com.vadym.pectoralepawnshop.R;

public class ForClientFragment extends Fragment {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView forClientsRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_recyclerview, container, false);
        String[] topicNames = new String[DataBaseSimulation.topics_for_clients.length];
        for (int i = 0; i < topicNames.length; i++) {
            topicNames[i] = DataBaseSimulation.topics_for_clients[i].getName();

        }
        int[] topicImages = new int[DataBaseSimulation.topics_for_clients.length];
        for (int i = 0; i < topicImages.length; i++) {
            topicImages[i] = DataBaseSimulation.topics_for_clients[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter("FOR_CLIENTS", forClientsRecycler.getContext());
        forClientsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        forClientsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailTopicsActivity.class);
                intent.putExtra(DetailTopicsActivity.ID_TOPIC, position);
                getActivity().startActivity(intent);
            }
        });

        return forClientsRecycler;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
