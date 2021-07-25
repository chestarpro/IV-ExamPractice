package com.company;

import com.company.dao.NewsDao;
import com.company.dao.impl.NewsDaoImpl;
import com.company.model.NewsModel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NewsModel newsModel = new NewsModel();

        createNews(newsModel);

        System.out.println("--------------------");

        showNewsByDate(); // Вывод заголовка и текста новости по дате выхода.

        changeTitleTextNews();

        System.out.println("--------------------");

        deleteNews();

    }

    public static void createNews(NewsModel newsModel) {
        NewsDao newsDao = new NewsDaoImpl();
        Scanner scanner = new Scanner(System.in);;
        System.out.println("Enter news title: ");
        String title = scanner.nextLine();
        newsModel.setTitle(title);
        System.out.println("Enter news text: ");
        String text = scanner.nextLine();
        newsModel.setText(text);
        if(newsDao.addNews(newsModel)) {
            System.out.println("News added!");
        } else System.out.println("Error!");
    }

    public static void showNewsByDate() {
        NewsDao newsDao = new NewsDaoImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date(YYYY-MM-DD): ");
        String date = scanner.nextLine();
        newsDao.showNews(date);
    }

    public static void changeTitleTextNews() {
        NewsDao newsDao = new NewsDaoImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter news id to change title and text:");
        int id = scanner.nextInt();
        if(newsDao.changeTextTitleNews(id)) {
            System.out.println("News changed!");
        } else System.out.println("Error!");
    }

    public static void deleteNews() {
        NewsDao newsDao = new NewsDaoImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter news id to delete news:");
        int id = scanner.nextInt();
        if(newsDao.deleteNews(id)) {
            System.out.println("News deleted!");
        } else System.out.println("Error!");
    }
}
