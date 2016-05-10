package com.vadym.pectoralepawnshop.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.activities.DetailActivity;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.utils.CaptionedImagesAdapter;

public class HowItWorksFragment extends Fragment {

    public static final String CLASSNAME = "HowItWorksFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView howItWorksRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_recyclerview, container, false);
        String[] topicNames = new String[DataBaseSimulation.topics_for_how_it_works.length];
        for (int i = 0; i < topicNames.length; i++) {
            topicNames[i] = DataBaseSimulation.topics_for_how_it_works[i].getName();
        }
        int[] topicImages = new int[DataBaseSimulation.topics_for_how_it_works.length];
        for (int i = 0; i < topicImages.length; i++) {
            topicImages[i] = DataBaseSimulation.topics_for_how_it_works[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(topicNames, topicImages);
        howItWorksRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        howItWorksRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TOPICNO, position);
                intent.putExtra(DetailActivity.EXTRA_CALLEDFRAG, CLASSNAME);
                getActivity().startActivity(intent);
            }
        });

        return howItWorksRecycler;
    }
}
