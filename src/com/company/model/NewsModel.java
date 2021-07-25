package com.company.model;

import java.sql.Timestamp;

public class NewsModel {
    private int id;
    private String title;
    private String text;
    private Timestamp publicationTime;

    public NewsModel() {}

    public NewsModel(String title, String text) {
        this.title = title;
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getPublicationTime() {
        return  publicationTime;
    }

    public void setPublicationTime(Timestamp publicationTime) {
        this.publicationTime = publicationTime;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", publicationTime=" + publicationTime +
                '}';
    }
}
