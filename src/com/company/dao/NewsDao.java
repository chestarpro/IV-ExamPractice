package com.company.dao;

import com.company.model.NewsModel;

public interface NewsDao {
    boolean addNews(NewsModel newsModel);
    void showNews(String date);  // В условии не было понятно отображение новости как именно. Я решил отоборажать новости по дате. Думаю так логично)
    boolean deleteNews(int id);
    boolean changeTextTitleNews(int id);
}
