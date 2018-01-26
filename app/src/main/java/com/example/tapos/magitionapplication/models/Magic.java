package com.example.tapos.magitionapplication.models;

/**
 * Created by tapos on 1/26/18.
 */

public class Magic {
    private long id;
    private String title;
    private String description;
    private int thumbnail;

    public Magic() {

    }


    public Magic(long id, String title, String description, int thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public Magic(String mTitle, String description, int thumbnail) {
        this.title = mTitle;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
