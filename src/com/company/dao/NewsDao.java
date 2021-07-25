package com.company.dao;

import com.company.model.NewsModel;

import java.util.Date;

public interface NewsDao {
    boolean addNews(NewsModel newsModel);
    void displayNews(int year, int month, int date);  // В условии не было понятно отображение новости как именно. Я решил отоборажать новости по дате. Думаю так логично)
    boolean deleteNews(Long id);
    boolean changeTextTitleNews(Long id);
}
