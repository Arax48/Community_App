package com.example.frontendcommunityapp.Model.Users;

import com.example.frontendcommunityapp.Controller.DbConnection;
import com.example.frontendcommunityapp.Model.Services.NovedadVigilante;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Visitante {

    private int idVisitante;

    private String nombre;

    private String fecha;

    private String horaVisita;

    private String telefono;

    private String torre;

    private String apto;

    private String docIdentidad;

    private String proposito;


    public Visitante(int idVisitante, String nombre, String fecha,
                     String horaVisita, String telefono, String docIdentidad,
                     String torre, String apto,
                     String proposito) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaVisita = horaVisita;
        this.telefono = telefono;
        this.torre = torre;
        this.apto = apto;
        this.docIdentidad = docIdentidad;
        this.proposito = proposito;
    }


    public int getIdVisitante() {
        return idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }


    public String getTorre() {
        return torre;
    }

    public String getApto() {
        return apto;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }




    public void registrarVisitanteDB(String nombre, String fecha, String horaVisita,
                                     String telefono, String docIdentidad, String torre,
                                     String apto, String proposito) {

        String query = "INSERT INTO visitante(nombre, fecha, horaVisita, telefono, docIdentidad," +
                " torre, apto, proposito) VALUES( '" + nombre + "', " +
                " '" + fecha + "', '" + horaVisita + "','" + telefono + "'," +
                " '" + docIdentidad + "', '" + torre + "', '" + apto + "', '" + proposito + "' )";
        DbConnection connection = new DbConnection();

        try {
            int rs = connection.updateDataBase(query);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Visitante> obtenerTodosLosVisitantes() {
        DbConnection connection = new DbConnection();
        String query = "SELECT * FROM visitante";
        List<Visitante> listaVisitantes = new ArrayList<>();

        try {
            ResultSet resultSet = connection.getQueryTable(query);

            while (resultSet.next()) {
                int idVisitante = resultSet.getInt("id_Visitante");
                String nombre = resultSet.getString("nombre");
                String fecha = resultSet.getString("fecha");
                String horaVisita = resultSet.getString("horaVisita");
                String telefono = resultSet.getString("telefono");
                String torre = resultSet.getString("proposito");
                String apto = resultSet.getString("apto");
                String docIdentidad = resultSet.getString("docIdentidad");
                String proposito = resultSet.getString("proposito");

                Visitante visitante = new Visitante(idVisitante, nombre, fecha, horaVisita, telefono, docIdentidad, torre, apto, proposito);
                listaVisitantes.add(visitante);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaVisitantes;
    }

}
