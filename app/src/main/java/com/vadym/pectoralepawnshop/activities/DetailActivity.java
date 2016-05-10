package com.vadym.pectoralepawnshop.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.vadym.pectoralepawnshop.R;
import com.vadym.pectoralepawnshop.database.DataBaseSimulation;
import com.vadym.pectoralepawnshop.fragments.ForClientFragment;
import com.vadym.pectoralepawnshop.fragments.HowItWorksFragment;

public class DetailActivity extends Activity {

    public static final String EXTRA_TOPICNO = "topicNo";
    public static final String EXTRA_CALLEDFRAG = "calledFrag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //Включение кнопки Вверх
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //Вывод подробной информации о пицце
        int topicNo = (Integer) getIntent().getExtras().get(EXTRA_TOPICNO);
        String calledFragment = (String) getIntent().getExtras().get(EXTRA_CALLEDFRAG);

        String topicName = "";
        int topicImage = 0;
        switch (calledFragment){
            case ForClientFragment.CLASSNAME:
                topicName = DataBaseSimulation.topics_for_clients[topicNo].getName();
                topicImage = DataBaseSimulation.topics_for_clients[topicNo].getImageResourceId();
                break;
            case HowItWorksFragment.CLASSNAME:
                topicName = DataBaseSimulation.topics_for_how_it_works[topicNo].getName();
                topicImage = DataBaseSimulation.topics_for_how_it_works[topicNo].getImageResourceId();
                break;
        }
        getActionBar().setTitle(topicName);
        ImageView imageView = (ImageView) findViewById(R.id.imageDetailed);
        imageView.setImageDrawable(getResources().getDrawable(topicImage));
        imageView.setContentDescription(topicName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
