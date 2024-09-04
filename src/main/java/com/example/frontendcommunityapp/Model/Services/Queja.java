package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queja {

    private String fecha;
    private String asunto;
    private String descripcion;
    private int idUsuario;

    public Queja(String fecha, String asunto, String descripcion, int idUsuario) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getAsunto() {
        return this.asunto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void registrarQuejaDB() {
        String query = "INSERT INTO quejasYpeticiones (id_usuario, fecha, asunto, peticion) VALUES ("
                + idUsuario + ", '" + fecha + "', '" + asunto + "', '" + descripcion + "')";
        System.out.println("Consulta SQL: " + query); // Para depuración
        DbConnection connection = new DbConnection();

        try {
            connection.updateDataBase(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Queja> obtenerTodasLasQuejas() {
        List<Queja> quejas = new ArrayList<>();
        String query = "SELECT * FROM quejasYpeticiones";
        DbConnection connection = new DbConnection();

        try {
            ResultSet resultSet = connection.getQueryTable(query);
            while (resultSet.next()) {
                String fecha = resultSet.getString("fecha");
                String asunto = resultSet.getString("asunto");
                String descripcion = resultSet.getString("peticion");
                int idUsuario = resultSet.getInt("id_usuario");

                Queja queja = new Queja(fecha, asunto, descripcion, idUsuario);
                quejas.add(queja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quejas;
    }

}
