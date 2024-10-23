package com.bitloader.demo;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// @SpringBootApplication
public class DemoApplication {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final String DB_USER = "postgres";
    static final String DB_PASS = "admin";
    static final String DB_QUERY = "select * from actor";
    static final String DB_PREPARED = "UPDATE actor SET first_name = 'Thor' WHERE actor_id = 200";


    public static void main(String[] args) {


        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); 
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(DB_QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("actor_id"));
                System.out.print(", first: " + rs.getString("first_name"));
                System.out.print(", last: " + rs.getString("last_name"));
                System.out.println(", time: " + rs.getString("last_update"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // SpringApplication.run(DemoApplication.class, args);
    }

}
