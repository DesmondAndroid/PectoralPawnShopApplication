package com.vadym.pectoralepawnshop.database;

import com.vadym.pectoralepawnshop.R;

/**
 * Created by Vadym on 06.05.2016.
 */
public class DataBaseSimulation {

    private String name;
    private int imageResourceId;

    public static final DataBaseSimulation[] topics_for_clients = {
            new DataBaseSimulation("Партнерская программа", R.drawable.partnprogramm),
            new DataBaseSimulation("Кредитная линия", R.drawable.kreditnylimit),
    };

    public static final DataBaseSimulation[] topics_for_how_it_works = {
            new DataBaseSimulation("КАК ЖЕ ЭТО РАБОТАЕТ", R.drawable.howitworks),
            new DataBaseSimulation("ЧЕТЫРЕ ПРОСТЫХ ШАГА", R.drawable.steps),
            new DataBaseSimulation("ВОПРОСЫ И ОТВЕТЫ", R.drawable.faq),
            new DataBaseSimulation("ГРУППЫ ЗАЛОГОВ", R.drawable.securedloans),
            new DataBaseSimulation("КАК УПРАВЛЯТЬ СВОИМ ЛИЧНЫМ КАБИНЕТОМ", R.drawable.howmanageaccount),
    };

    private DataBaseSimulation(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }


}
