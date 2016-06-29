package com.vadym.pectoralepawnshop.database;

import com.vadym.pectoralepawnshop.R;

/**
 * Created by Vadym on 06.05.2016.
 */
public class DataBaseSimulation {

    public static final CaptionedImageEntity[] topics_for_clients = {
            new CaptionedImageEntity("Партнерская программа", R.drawable.partnprogramm, "http://pectorale.com.ua/stat/partnerskaja-programma"),
            new CaptionedImageEntity("Кредитная линия", R.drawable.kreditnylimit, "http://pectorale.com.ua/stat/kredit_line"),
    };

    public static final CaptionedImageEntity[] topics_for_how_it_works = {
            new CaptionedImageEntity("КАК ЖЕ ЭТО РАБОТАЕТ", R.drawable.howitworks, "http://pectorale.com.ua/stat/kak-eto-rabotaet"),
            new CaptionedImageEntity("ЧЕТЫРЕ ПРОСТЫХ ШАГА", R.drawable.steps, "http://pectorale.com.ua/stat/4-prostyh-shaga"),
            new CaptionedImageEntity("ВОПРОСЫ И ОТВЕТЫ", R.drawable.faq, "http://pectorale.com.ua/stat/faq"),
            new CaptionedImageEntity("ГРУППЫ ЗАЛОГОВ", R.drawable.securedloans, "http://pectorale.com.ua/stat/groups"),
            new CaptionedImageEntity("КАК УПРАВЛЯТЬ СВОИМ ЛИЧНЫМ КАБИНЕТОМ", R.drawable.howmanageaccount, "http://pectorale.com.ua/stat/kak-upravljat-svoim-lichnym-kabinetom"),
    };

    public static final DepartmentEntity[] departments = {
            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00\nВс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №2 в г. Киев", 50.466737, 30.627153, "Киев",
                    "ул. Братиславская, 14", new String[]{"(068) 345-00-02","(044) 513-83-84"},
                    "Пн-Сб 09:00 - 20.00\nВс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01","(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00 Вс 10:00 - 19:00")
    };

}
