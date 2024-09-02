package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroMascotas extends Services {

    private String nombreMascota;
    private String raza;
    private int idCasaApto; // ID del residente
    private boolean perdido;

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public int getIdCasaApto() {
        return idCasaApto;
    }

    public boolean isPerdido() {
        return perdido;
    }

    public RegistroMascotas(String nombreMascota, String raza, int idCasaApto, boolean perdido) {
        super(0, "RegistroMascotas"); // Llama al constructor de la clase Services
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.idCasaApto = idCasaApto;
        this.perdido = perdido;
    }

    public void registrarMascota() {
        DbConnection connection = new DbConnection();
        String query = "SELECT COUNT(*) FROM mascotas WHERE nombre = '" + this.nombreMascota +
                "' AND tipo_animal = '" + this.raza + "' AND id_usuario = " + this.idCasaApto;

        try {
            int count = connection.getCount(query);
            if (count > 0) {
                // Si la mascota ya está registrada, muestra un mensaje
                System.out.println("La mascota ya se encuentra registrada.");
                return; // Salir del método, ya no es necesario continuar
            } else {
                // Si la mascota no está registrada, realiza el registro
                String insertQuery = "INSERT INTO mascotas(nombre, tipo_animal, id_usuario, perdido) VALUES ('"
                        + this.nombreMascota + "', '"
                        + this.raza + "', "
                        + this.idCasaApto + ", "
                        + (this.perdido ? 1 : 0) + ")";

                int result = connection.updateDataBase(insertQuery);
                if (result > 0) {
                    System.out.println("Mascota registrada exitosamente.");
                } else {
                    System.out.println("Error al registrar la mascota.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean existeMascotaPerdida() {
        DbConnection connection = new DbConnection();
        String query = "SELECT COUNT(*) FROM mascotas WHERE nombre = '" + this.nombreMascota +
                "' AND tipo_animal = '" + this.raza + "' AND id_usuario = " + this.idCasaApto +
                " AND perdido = 1";

        try {
            int count = connection.getCount(query);
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void actualizarMascota() {
        DbConnection connection = new DbConnection();
        String updateQuery = "UPDATE mascotas SET perdido = 0 WHERE nombre = '" + this.nombreMascota +
                "' AND tipo_animal = '" + this.raza +
                "' AND id_usuario = " + this.idCasaApto;

        try {
            int result = connection.updateDataBase(updateQuery);
            if (result > 0) {
                System.out.println("Estado de la mascota actualizado exitosamente a encontrado.");
            } else {
                System.out.println("Error al actualizar el estado de la mascota.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RegistroMascotas pet1 = new RegistroMascotas("tin", "Labrador", 123, false);
        pet1.registrarMascota();
    }
}
//
