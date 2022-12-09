package com.task1.springboothelloworld;

import java.sql.*;

public class Message {
    public String returnTranslation(String language) throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/langdb", "root", "edin");
        Statement stmt = connection.createStatement();

        String returnMessageQuery = "SELECT message " +
                "FROM messages " +
                "WHERE language = '" + language + "';";
        ResultSet resultSet = stmt.executeQuery(returnMessageQuery);
        String result = null;

        while(resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;
    }
}
