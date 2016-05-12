package com.vadym.pectoralepawnshop.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vadym.pectoralepawnshop.utils.CaptionedImagesAdapter;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.activities.DetailActivity;
import com.vadym.pectoralepawnshop.R;

public class ForClientFragment extends Fragment {

    public static final String CLASSNAME = "ForClientFragment";

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
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(topicNames, topicImages);
        forClientsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        forClientsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.URL, DataBaseSimulation.topics_for_clients[position].getUrl());
                getActivity().startActivity(intent);
            }
        });

        return forClientsRecycler;
    }
}
