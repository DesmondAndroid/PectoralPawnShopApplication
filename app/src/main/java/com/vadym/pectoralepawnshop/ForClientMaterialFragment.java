package com.vadym.pectoralepawnshop;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ForClientMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView forClientsRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_for_client_material, container, false);
        String[] topicNames = new String[ClientSection.topics.length];
        for (int i = 0; i < topicNames.length; i++) {
            topicNames[i] = ClientSection.topics[i].getName();
        }
        int[] topicImages = new int[ClientSection.topics.length];
        for (int i = 0; i < topicImages.length; i++) {
            topicImages[i] = ClientSection.topics[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(topicNames, topicImages);
        forClientsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        forClientsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ForClientDetailAvtivity.class);
                intent.putExtra(ForClientDetailAvtivity.EXTRA_TOPICNO, position);
                getActivity().startActivity(intent);
            }
        });

        return forClientsRecycler;
    }
}
