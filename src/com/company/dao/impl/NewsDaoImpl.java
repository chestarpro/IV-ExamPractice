package com.company.dao.impl;

import com.company.model.NewsModel;
import com.company.dao.BaseDao;
import com.company.dao.NewsDao;

import java.sql.*;
import java.util.Date;

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
    public void displayNews(int year, int month, int date) {
        String sql = "SELECT n.news_title, n.news_text FROM news n\n" +
                "WHERE n.publication_time::date = '" + year + "-" + month + "-" + date +"'";

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
            e.printStackTrace();
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
    public boolean deleteNews(Long id) {
        String sql = "";
        return false;
    }

    @Override
    public boolean changeTextTitleNews(Long id) {
        String sql = "";
        return false;
    }
}
