package com.vadym.pectoralepawnshop;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

public class ForClientDetailAvtivity extends Activity {

    public static final String EXTRA_TOPICNO = "topicNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_client_detail_avtivity);

        //Включение кнопки Вверх
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //Вывод подробной информации о пицце
        int topicNo = (Integer)getIntent().getExtras().get(EXTRA_TOPICNO);
        String topicName = ClientSection.topics[topicNo].getName();
        TextView textView = (TextView)findViewById(R.id.pizza_text);
        textView.setText(topicName);
        int topicImage = ClientSection.topics[topicNo].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.pizza_image);
        imageView.setImageDrawable(getResources().getDrawable(topicImage));
        imageView.setContentDescription(topicName);
    }

}
