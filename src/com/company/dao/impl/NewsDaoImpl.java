package com.company.dao.impl;

import com.company.model.NewsModel;
import com.company.dao.BaseDao;
import com.company.dao.NewsDao;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public boolean addNews(NewsModel newsModel) {
        String sql = "INSERT INTO news(news_title, news_text, publication_time) \n" +
                "VALUES (?, ?, ?);\nCOMMIT;";

        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            Date date = new Date();
            newsModel.setPublicationTime(new Timestamp(date.getTime()));

            preparedStatement.setString(1, newsModel.getTitle());
            preparedStatement.setString(2, newsModel.getText());
            preparedStatement.setTimestamp(3, newsModel.getPublicationTime());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public void showNews(String date) {
        String sql = "SELECT n.news_title, n.news_text FROM news n\n" +
                "WHERE n.publication_time::date = '" + date + "'";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = connect();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("news_title") +
                        "\n" + resultSet.getString("news_text") + " \n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean deleteNews(int id) {
        String sql = "DELETE FROM news \n" +
                "WHERE id = ?";

        try (Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean changeTextTitleNews(int id) {
        String sql = "UPDATE news \n" +
                "SET news_title = ?, news_text = ?\n" +
                "WHERE id = ?;";

        try (Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            System.out.println("Enter title to change: ");
            preparedStatement.setString(1, new Scanner(System.in).nextLine());
            System.out.println("Enter text to change: ");
            preparedStatement.setString(2, new Scanner(System.in).nextLine());
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
