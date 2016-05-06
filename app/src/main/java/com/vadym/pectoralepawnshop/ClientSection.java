package com.vadym.pectoralepawnshop;

/**
 * Created by Vadym on 06.05.2016.
 */
public class ClientSection {

    private String name;
    private int imageResourceId;

    public static final ClientSection[] topics = {
            new ClientSection("Партнерская программа", R.drawable.partnprogramm),
            new ClientSection("Кредитная линия", R.drawable.kreditnylimit)
    };

    private ClientSection(String name, int imageResourceId) {
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
