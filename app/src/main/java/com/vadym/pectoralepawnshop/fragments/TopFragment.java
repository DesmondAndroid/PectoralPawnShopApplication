package com.vadym.pectoralepawnshop.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.activities.DetailTopicsActivity;
import com.vadym.pectoralepawnshop.activities.SignInActivity;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.utils.CaptionedImagesAdapter;

import butterknife.InjectView;

public class TopFragment extends Fragment {

//    @InjectView(R.id.btn_autorization) Button loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)
                inflater.inflate(R.layout.fragment_top, container, false);
        Button loginButton = (Button) layout.findViewById(R.id.btn_autorization);
        RecyclerView newsRecycler = (RecyclerView)layout.findViewById(R.id.news_recycler);

        String[] newsNames = new String[DataBaseSimulation.topics_news.length];
        for (int i = 0; i < newsNames.length; i++) {
            newsNames[i] = DataBaseSimulation.topics_news[i].getName();
        }

        int[] newsImages = new int[DataBaseSimulation.topics_news.length];
        for (int i = 0; i < newsImages.length; i++) {
            newsImages[i] = DataBaseSimulation.topics_news[i].getImageResourceId();
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        newsRecycler.setLayoutManager(layoutManager);
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter("NEWS", layout.getContext());
        newsRecycler.setAdapter(adapter);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailTopicsActivity.class);
                intent.putExtra(DetailTopicsActivity.ID_TOPIC, position);
                getActivity().startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return layout;
    }
}
