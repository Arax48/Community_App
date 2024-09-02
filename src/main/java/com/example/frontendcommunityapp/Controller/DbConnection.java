package com.example.frontendcommunityapp.Controller;

import java.sql.*;

public class DbConnection {

    private final String dbUrl = "jdbc:mysql://localhost:3306/communityappdb";
    private final String userName = "silvana";
    private final String password = "";

    // Método para establecer la conexión a la base de datos
    private Connection connect() {
        try {
            return DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para obtener un Statement
    private Statement getStatement() {
        try {
            Connection connection = connect();
            if (connection != null) {
                return connection.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para ejecutar una consulta y devolver un ResultSet
    public ResultSet getQueryTable(String query) {
        try {
            Statement statement = getStatement();
            if (statement != null) {
                return statement.executeQuery(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para actualizar la base de datos (INSERT, UPDATE, DELETE)
    public int updateDataBase(String query) {
        int result = 0;
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Método para contar registros
    public int getCount(String query) {
        int count = 0;
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            if (rs.next()) {
                count = rs.getInt(1); // Obtener el conteo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        ResultSet rs = conn.getQueryTable("SELECT * FROM usuarios");
        if (rs != null) {
            System.out.println("Connection Successful");
            try {
                while (rs.next()) {
                    // Aquí puedes acceder a los datos de los usuarios
                    System.out.println("Usuario: " + rs.getString("nombre")); // Cambia "nombre" según el campo que desees mostrar
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection Failed");
        }
    }
}


