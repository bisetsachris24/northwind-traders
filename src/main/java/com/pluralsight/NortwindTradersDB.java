package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NortwindTradersDB {
    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("yearup26");
        System.out.println("--Product Names-- ");

        String sql = """
                SELECT
                   *
                FROM
                    Products
                """;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet results = stmt.executeQuery();
        ) {
            while (results.next()) {
              String productname = results.getString("productname");

                System.out.println(productname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}