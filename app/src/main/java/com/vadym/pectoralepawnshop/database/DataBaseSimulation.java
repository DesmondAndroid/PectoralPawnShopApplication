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

    public static final CaptionedImageEntity[] topics_news = {
            new CaptionedImageEntity("Новый продукт – новые возможности!", R.drawable.newproductnewvozm, "http://pectorale.com.ua/stat/novyi-produkt---novye-vozmozhnosti"),
            new CaptionedImageEntity("Открыто новое отделение в районе метро Левобережная", R.drawable.newdepartment, "http://pectorale.com.ua/stat/novoe-otdelenie-8"),
            new CaptionedImageEntity("Кредит на карту в ломбарде онлайн", R.drawable.kreditnakartu, "http://pectorale.com.ua/stat/kredit-na-kartu-v-lombard-onlain"),
            new CaptionedImageEntity("Первый мобильный онлайн ломбард в Украине", R.drawable.perviymobilniy, "http://pectorale.com.ua/stat/lombard-pektoral---pervyi-mobilnyi-onlain-lombard-v-ukraine"),
            new CaptionedImageEntity("Доставка/передача предмета залога для выдачи кредита на карту", R.drawable.dostavka, "http://pectorale.com.ua/stat/dostavkaperedacha-predmeta-zaloga-dlja-vydachi-kredita-na-kartu"),
    };

    public static final DepartmentEntity[] departments = {
            new DepartmentEntity("Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка",
                    "ул. Белгородская, 19А", new String[]{"(068) 345-00-01", "(045) 984-75-60"},
                    "Пн-Сб 9:00 - 20:00\nВс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №2 в г. Киев", 50.466737, 30.627153, "Киев",
                    "ул. Братиславская, 14", new String[]{"(068) 345-00-02", "(044) 513-83-84"},
                    "Пн-Сб 09:00 - 20.00\nВс 10:00 - 19:00"),

            new DepartmentEntity("Отделение №3 в г. Васильков", 50.174529, 30.320692, "Васильков",
                    "ул. Владимирская, 13", new String[]{"(068) 345-00-03", "(045) 712-38-43"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00"),

            new DepartmentEntity("Отделение №4 в г. Фастов", 50.079042, 29.912097, "Фастов",
                    "ул. Соборная, 47", new String[]{"(068) 345-00-04", "(045) 655-25-57"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00"),

            new DepartmentEntity("Отделение №5 в г. Белая Церковь", 49.811197, 30.107896, "Белая Церковь",
                    "ул. Вокзальная, 22, пом. 129", new String[]{"(068) 345-00-05", "(045) 638-28-69"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00"),

            new DepartmentEntity("Отделение №6 в г. Киев", 50.491590, 30.464159, "Киев",
                    "ул. Фрунзе, 152", new String[]{"(068) 345-22-75", "(044) 468-50-01"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00"),

            new DepartmentEntity("Отделение №7 в г. Киев", 50.470150, 30.338976, "Киев",
                    "ул. Академика Булаховского, 5Б", new String[]{"(068) 345-22-74", "(044) 390-31-48"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00"),

            new DepartmentEntity("Отделение №8 в г. Киев", 50.4562694, 30.5917248, "Киев",
                    "ул. Луначарского, 22", new String[]{"(068) 354-03-33"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00"),

            new DepartmentEntity("Отделение №9 в г. Буча", 50.550236, 30.208768, "Буча",
                    "ул. Энергетиков, 14А", new String[]{"(068) 345-22-01", "(045) 97-26-101"},
                    "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00")
    };

}
