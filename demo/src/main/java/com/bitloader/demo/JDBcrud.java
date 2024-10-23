package com.bitloader.demo;

import java.sql.*;

public class JDBcrud {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final String DB_USER = "postgres";
    static final String DB_PASS = "admin";
    static final String DB_QUERY = "select * from actor";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
        ) {
//            String sql = "CREATE DATABASE STUDENTS";
//            String sql = "CREATE TABLE REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";

//            String QUERY1 = "CREATE TEMPORARY TABLE EMPLOYEES_COPY SELECT * FROM actor";
//            stmt.execute(QUERY1);
//            String QUERY2 = "SELECT * FROM EMPLOYEES_COPY";
//            ResultSet rs = stmt.executeQuery(QUERY2);
//
//            while (rs.next()){
//                System.out.print("Id: " + rs.getInt("id"));
//                System.out.print(" Age: " + rs.getInt("age"));
//                System.out.print(" First: " + rs.getString("first"));
//                System.out.println(" Last: " + rs.getString("last"));
//                System.out.println("------------------------------------------");
//            }

             String sql = "SELECT * FROM actor";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.print("Id: " + rs.getInt("actor_id"));
                System.out.print(" Age: " + rs.getString("first_name"));
                System.out.print(" First: " + rs.getString("last_name"));
                System.out.println("------------------------------------------");
            }
            System.out.println("Database created successfully...");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
