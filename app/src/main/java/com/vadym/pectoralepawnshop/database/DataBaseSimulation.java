package com.vadym.pectoralepawnshop.database;

import com.vadym.pectoralepawnshop.R;

/**
 * Created by Vadym on 06.05.2016.
 */
public class DataBaseSimulation {

    private String name;
    private int imageResourceId;
    private String url;

    public static final DataBaseSimulation[] topics_for_clients = {
            new DataBaseSimulation("Партнерская программа", R.drawable.partnprogramm, "http://pectorale.com.ua/stat/partnerskaja-programma"),
            new DataBaseSimulation("Кредитная линия", R.drawable.kreditnylimit, "http://pectorale.com.ua/stat/kredit_line"),
    };

    public static final DataBaseSimulation[] topics_for_how_it_works = {
            new DataBaseSimulation("КАК ЖЕ ЭТО РАБОТАЕТ", R.drawable.howitworks, "http://pectorale.com.ua/stat/kak-eto-rabotaet"),
            new DataBaseSimulation("ЧЕТЫРЕ ПРОСТЫХ ШАГА", R.drawable.steps, "http://pectorale.com.ua/stat/4-prostyh-shaga"),
            new DataBaseSimulation("ВОПРОСЫ И ОТВЕТЫ", R.drawable.faq, "http://pectorale.com.ua/stat/faq"),
            new DataBaseSimulation("ГРУППЫ ЗАЛОГОВ", R.drawable.securedloans, "http://pectorale.com.ua/stat/groups"),
            new DataBaseSimulation("КАК УПРАВЛЯТЬ СВОИМ ЛИЧНЫМ КАБИНЕТОМ", R.drawable.howmanageaccount, "http://pectorale.com.ua/stat/kak-upravljat-svoim-lichnym-kabinetom"),
    };

    private DataBaseSimulation(String name, int imageResourceId, String url) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.url = url;
    }

    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getUrl() {
        return url;
    }


}
