package com.vadym.pectoralepawnshop.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vadym.pectoralepawnshop.R;

/**
 * Created by Vadym on 30.06.2016.
 */
public class PectoraleDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "pectorale"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных

    public PectoraleDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE TOPIC ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "SECTION TEXT, "
                    + "NAME TEXT, "
                    + "URL TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");

            db.execSQL("CREATE TABLE DEPARTMENT ( "
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "COORDINATE_X REAL, "
                    + "COORDINATE_Y REAL, "
                    + "CITY TEXT, "
                    + "ADDRESS TEXT, "
                    + "WORKING_HOURS TEXT);");

            db.execSQL("CREATE TABLE TELEPHONE ("
                    + "TELEPHONE_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "DEPARTMENT_ID INTEGER NOT NULL, "
                    + "TELEPHONE TEXT);");

            insertDataTopic(db, "HOW_IT_WORKS", "КАК ЖЕ ЭТО РАБОТАЕТ", "http://pectorale.com.ua/stat/kak-eto-rabotaet", R.drawable.howitworks);
            insertDataTopic(db, "HOW_IT_WORKS", "ЧЕТЫРЕ ПРОСТЫХ ШАГА", "http://pectorale.com.ua/stat/4-prostyh-shaga", R.drawable.steps);
            insertDataTopic(db, "HOW_IT_WORKS", "ВОПРОСЫ И ОТВЕТЫ", "http://pectorale.com.ua/stat/faq", R.drawable.faq);
            insertDataTopic(db, "HOW_IT_WORKS", "ГРУППЫ ЗАЛОГОВ", "http://pectorale.com.ua/stat/groups", R.drawable.securedloans);
            insertDataTopic(db, "HOW_IT_WORKS", "КАК УПРАВЛЯТЬ СВОИМ ЛИЧНЫМ КАБИНЕТОМ", "http://pectorale.com.ua/stat/kak-upravljat-svoim-lichnym-kabinetom", R.drawable.howmanageaccount);

            insertDataTopic(db, "NEWS", "Новый продукт – новые возможности!", "http://pectorale.com.ua/stat/novyi-produkt---novye-vozmozhnosti", R.drawable.newproductnewvozm);
            insertDataTopic(db, "NEWS", "Открыто новое отделение в районе метро Левобережная", "http://pectorale.com.ua/stat/novoe-otdelenie-8", R.drawable.newdepartment);
            insertDataTopic(db, "NEWS", "Кредит на карту в ломбарде онлайн", "http://pectorale.com.ua/stat/kredit-na-kartu-v-lombard-onlain", R.drawable.kreditnakartu);
            insertDataTopic(db, "NEWS", "Первый мобильный онлайн ломбард в Украине", "http://pectorale.com.ua/stat/lombard-pektoral---pervyi-mobilnyi-onlain-lombard-v-ukraine", R.drawable.perviymobilniy);
            insertDataTopic(db, "NEWS", "Доставка/передача предмета залога для выдачи кредита на карту", "http://pectorale.com.ua/stat/dostavkaperedacha-predmeta-zaloga-dlja-vydachi-kredita-na-kartu", R.drawable.dostavka);

            insertDataTopic(db, "FOR_CLIENTS", "Партнерская программа", "http://pectorale.com.ua/stat/partnerskaja-programma", R.drawable.partnprogramm);
            insertDataTopic(db, "FOR_CLIENTS", "Кредитная линия", "http://pectorale.com.ua/stat/kredit_line", R.drawable.kreditnylimit);

            insertDepartment(db, "Отделение №1 в г. Боярка", 50.327975, 30.292260, "Боярка", "ул. Белгородская, 19А", new String[]{"(068) 345-00-01", "(045) 984-75-60"}, "Пн-Сб 9:00 - 20:00\nВс 10:00 - 19:00");
            insertDepartment(db, "Отделение №2 в г. Киев", 50.466737, 30.627153, "Киев", "ул. Братиславская, 14", new String[]{"(068) 345-00-02", "(044) 513-83-84"}, "Пн-Сб 09:00 - 20.00\nВс 10:00 - 19:00");
            insertDepartment(db, "Отделение №3 в г. Васильков", 50.174529, 30.320692, "Васильков", "ул. Владимирская, 13", new String[]{"(068) 345-00-03", "(045) 712-38-43"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
            insertDepartment(db, "Отделение №4 в г. Фастов", 50.079042, 29.912097, "Фастов", "ул. Соборная, 47", new String[]{"(068) 345-00-04", "(045) 655-25-57"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
            insertDepartment(db, "Отделение №5 в г. Белая Церковь", 49.811197, 30.107896, "Белая Церковь", "ул. Вокзальная, 22, пом. 129", new String[]{"(068) 345-00-05", "(045) 638-28-69"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
            insertDepartment(db, "Отделение №6 в г. Киев", 50.491590, 30.464159, "Киев", "ул. Фрунзе, 152", new String[]{"(068) 345-22-75", "(044) 468-50-01"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
            insertDepartment(db, "Отделение №7 в г. Киев", 50.470150, 30.338976, "Киев", "ул. Академика Булаховского, 5Б", new String[]{"(068) 345-22-74", "(044) 390-31-48"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
            insertDepartment(db, "Отделение №8 в г. Киев", 50.4562694, 30.5917248, "Киев", "ул. Луначарского, 22", new String[]{"(068) 354-03-33"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
            insertDepartment(db, "Отделение №9 в г. Буча", 50.550236, 30.208768, "Буча", "ул. Энергетиков, 14А", new String[]{"(068) 345-22-01", "(045) 97-26-101"}, "Пн-Сб 09:00 – 20:00\nВс 10:00 – 19:00");
        }
        if (oldVersion < 2) {

        }
    }

    private static void insertDataTopic(SQLiteDatabase db, String section, String name,
                                        String url, int resourceId) {
        ContentValues values = new ContentValues();
        values.put("SECTION", section);
        values.put("NAME", name);
        values.put("URL", url);
        values.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("TOPIC", null, values);
    }

    private static void insertDepartment(SQLiteDatabase db, String name,
                                         double coordinateX, double coordinateY,
                                         String city, String address, String[] telephoneNumbers, String workingHours) {
        ContentValues valuesDepartment = new ContentValues();
        valuesDepartment.put("NAME", name);
        valuesDepartment.put("COORDINATE_X", coordinateX);
        valuesDepartment.put("COORDINATE_Y", coordinateY);
        valuesDepartment.put("CITY", city);
        valuesDepartment.put("ADDRESS", address);
        valuesDepartment.put("WORKING_HOURS", workingHours);
        long idInsertedDepartment = db.insert("DEPARTMENT", null, valuesDepartment);
        for (String number : telephoneNumbers) {
            ContentValues valuesNumbers = new ContentValues();
            valuesNumbers.put("DEPARTMENT_ID", idInsertedDepartment);
            valuesNumbers.put("TELEPHONE", number);
            db.insert("TELEPHONE", null, valuesNumbers);
        }
    }
}
