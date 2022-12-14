package com.task1.springboothelloworld;

import java.sql.*;
import java.util.HashMap;

public class ReturnMessage {

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/langdb", "root", "edin");
    Statement stmt = connection.createStatement();

    public ReturnMessage() throws SQLException {
    }

    public String returnTranslation(String language) throws Exception{

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

    /*public HashMap<String, String> insert(String language, String message) throws SQLException {

        String insertQuery = "INSERT INTO messages(language, message) VALUES ('" + language + "', '" + message + "')";
        stmt.executeUpdate(insertQuery);

        String selectQuery = "SELECT * FROM messages WHERE language = '" + language + "';";

        ResultSet resultSet = stmt.executeQuery(selectQuery);

        String resultLang = null, resultMess = null;

        while(resultSet.next()){
            resultLang = resultSet.getString(1);
            resultMess = resultSet.getString(2);
        }

        HashMap<String, String> result = new HashMap<>();
        result.put(resultLang, resultMess);
        return  result;
    }*/
}
