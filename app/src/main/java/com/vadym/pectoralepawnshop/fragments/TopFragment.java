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

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.activities.DetailTopicsActivity;
import com.vadym.pectoralepawnshop.activities.SignInActivity;
import com.vadym.pectoralepawnshop.database.PectoraleDatabaseHelper;
import com.vadym.pectoralepawnshop.utils.CaptionedImagesAdapter;

public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)
                inflater.inflate(R.layout.fragment_top, container, false);
        Button loginButton = (Button) layout.findViewById(R.id.btn_autorization);
        RecyclerView newsRecycler = (RecyclerView)layout.findViewById(R.id.news_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        newsRecycler.setLayoutManager(layoutManager);
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(PectoraleDatabaseHelper.SECTION_NEWS, layout.getContext());
        newsRecycler.setAdapter(adapter);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int idTopic) {
                Intent intent = new Intent(getActivity(), DetailTopicsActivity.class);
                intent.putExtra(DetailTopicsActivity.ID_TOPIC, idTopic);
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
