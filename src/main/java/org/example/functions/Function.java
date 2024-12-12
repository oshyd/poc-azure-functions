package org.example.functions;

import com.microsoft.azure.functions.ExecutionContext;

import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 * Azure Functions with Timer Trigger.
 */
public class Function {

    @FunctionName("timeScheduledRunner")
    public void run(
            @TimerTrigger(name = "timeScheduledRunnerTrigger",
                    schedule = "0 */1 * * * *") String timerInfo,
            final ExecutionContext context) {
        context.getLogger().info("Timer is triggered: " + timerInfo);
        context.getLogger().info("Triggered at: " + LocalDateTime.now());
        String envVarValue = System.getenv("TEST_ENV_VAR");


        context.getLogger().info("Work finished");
        context.getLogger().info("TEST_ENV_VAR=" + envVarValue);
        context.getLogger().info("2024-12-05 22:46:47.664 Starting process for application A");
        context.getLogger().info("Error: Unable to connect to database");
        context.getLogger().info("Retrying in 5 seconds...");
        context.getLogger().info("2024-12-05 22:47:10.123 Process for application B started successfully");

    }

/*
    public void performDbCheck(ExecutionContext context) {
        String dbConnString = System.getenv("DB_CONNECTION_STRING");

        try {
            Connection connection = DriverManager.getConnection(dbConnString);
            context.getLogger().info("Connected to PostgreSQL");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                context.getLogger().info("Employee: " + firstName + " " + lastName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            context.getLogger().severe("Error: " + e.getMessage());
        }
    }
    */

}
