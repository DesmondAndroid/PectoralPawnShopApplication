package com.vadym.pectoralepawnshop.database;

/**
 * Created by Vadym on 25.06.2016.
 */
public class CaptionedImageEntity {

    private String name;
    private int imageResourceId;
    private String url;

    public CaptionedImageEntity(String name, int imageResourceId, String url) {
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
