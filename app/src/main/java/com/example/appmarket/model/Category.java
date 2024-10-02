package com.example.appmarket.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("Id")
    private int Id;

    @SerializedName("title")
    private String title;

    @SerializedName("Icon")
    private String Icon;

    @SerializedName("description")
    private String description;



}
