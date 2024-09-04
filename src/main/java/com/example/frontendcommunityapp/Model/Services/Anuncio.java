package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Anuncio {


    private String fecha;
    private String asunto;
    private String descripcion;
    private int idAdmin;

    public Anuncio(String fecha, String asunto, String descripcion, int idAdmin) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.idAdmin = idAdmin;
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
        return this.idAdmin;
    }

    public void registrarAnuncioDB() {
        String query = "INSERT INTO anuncio (idAdmin, fecha, asunto, anuncio) VALUES ("
                + idAdmin + ", '" + fecha + "', '" + asunto + "', '" + descripcion + "')";
        System.out.println("Consulta SQL: " + query); // Para depuración
        DbConnection connection = new DbConnection();

        try {
            connection.updateDataBase(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Anuncio> obtenerTodosLosAnuncios() {
        DbConnection connection = new DbConnection();
        String query = "SELECT fecha, asunto, anuncio, idAdmin FROM anuncio";
        List<Anuncio> listaAnuncios = new ArrayList<>();

        try {
            ResultSet resultSet = connection.getQueryTable(query);

            while (resultSet.next()) {
                String fecha = resultSet.getString("fecha");
                String asunto = resultSet.getString("asunto");
                String descripcion = resultSet.getString("anuncio");
                int idAdmin = resultSet.getInt("idAdmin");

                Anuncio anuncio = new Anuncio(fecha, asunto, descripcion, idAdmin);
                listaAnuncios.add(anuncio);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaAnuncios;
    }
}
