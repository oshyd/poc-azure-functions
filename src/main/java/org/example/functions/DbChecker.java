package org.example.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbChecker {
    //jdbc:postgresql://pg-poc-azure-func-elektro739-549a.d.aivencloud.com:17649/defaultdb?ssl=require&user=avnadmin&password=************************
    //postgresql-42.3.2.jar
    public static void main(String[] args) throws ClassNotFoundException {
        try (final Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://pg-poc-azure-func-elektro739-549a.d.aivencloud.com:17649/defaultdb?ssl=require&user=avnadmin&password=AVNS_pt3tQam6TKBe9SyjYTS");
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery("SELECT version()")) {

            while (resultSet.next()) {
                System.out.println("Version: " + resultSet.getString("version"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}