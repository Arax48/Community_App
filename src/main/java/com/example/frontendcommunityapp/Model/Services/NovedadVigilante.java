package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class NovedadVigilante {

    private String fecha;
    private String asunto;
    private String descripcion;
    private int idVigilante;

    public NovedadVigilante(String fecha, String asunto, String descripcion, int idVigilante) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.idVigilante = idVigilante;
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
        return this.idVigilante;
    }

    public void registrarNovedadDB() {
        String query = "INSERT INTO novedadesvigilante (idVigilante, fecha, Asunto, Peticion) VALUES ("
                + idVigilante + ", '" + fecha + "', '" + asunto + "', '" + descripcion + "')";
        System.out.println("Consulta SQL: " + query); // Para depuración
        DbConnection connection = new DbConnection();

        try {
            connection.updateDataBase(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<NovedadVigilante> obtenerTodasLasNovedades() {
        DbConnection connection = new DbConnection();
        String query = "SELECT idVigilante, fecha, Asunto, Peticion FROM novedadesvigilante";
        List<NovedadVigilante> listaNovedades = new ArrayList<>();

        try {
            ResultSet resultSet = connection.getQueryTable(query);

            while (resultSet.next()) {
                String fecha = resultSet.getString("fecha");
                String asunto = resultSet.getString("Asunto");
                String descripcion = resultSet.getString("Peticion");
                int idVigilante = resultSet.getInt("idVigilante");

                NovedadVigilante novedad = new NovedadVigilante(fecha, asunto, descripcion, idVigilante);
                listaNovedades.add(novedad);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaNovedades;
    }
}


