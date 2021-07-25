package com.company;

import com.company.dao.NewsDao;
import com.company.dao.impl.NewsDaoImpl;
import com.company.model.NewsModel;


public class Main {

    public static void main(String[] args) {
        NewsModel newsModel = new NewsModel("some title1", "som text1...");

        NewsDao newsDao = new NewsDaoImpl();

        if(newsDao.addNews(newsModel)) {
            System.out.println("News added!");
        } else System.out.println("Error!");

        newsDao.displayNews(2021, 7, 25);



    }
}
