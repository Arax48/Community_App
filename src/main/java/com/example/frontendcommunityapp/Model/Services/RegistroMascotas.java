package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroMascotas extends Services {

    private static final Logger logger = Logger.getLogger(RegistroMascotas.class.getName());

    private String nombre;
    private String raza;
    private String idUsuario;
    private String casaOapto;
    private boolean perdido;

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getCasaOapto() {
        return casaOapto;
    }

    public boolean isPerdido() {
        return perdido;
    }

    public RegistroMascotas(String nombre, String raza, String idUsuario, String casaOapto, boolean perdido) {
        super(0, "RegistroMascotas");
        this.nombre = nombre;
        this.raza = raza;
        this.idUsuario = idUsuario;
        this.casaOapto = casaOapto;
        this.perdido = perdido;
    }

    public String registrarMascota() {
        DbConnection connection = new DbConnection();

        // Verificar si la mascota ya está registrada
        if (existeMascota()) {
            // Actualizar el estado de la mascota
            if (actualizarMascota()) {
                logger.log(Level.INFO, "Estado de la mascota actualizado exitosamente.");
                return "Estado de la mascota actualizado exitosamente.";
            } else {
                logger.log(Level.WARNING, "Error al actualizar la mascota.");
                return "Error al actualizar la mascota.";
            }
        } else {
            // Si no existe, proceder a crear un nuevo registro
            String query = "INSERT INTO mascotas(nombre, raza, id_usuario, casa_o_apto, perdido) VALUES ('"
                    + this.nombre + "', '"
                    + this.raza + "', '"
                    + this.idUsuario + "', '"
                    + this.casaOapto + "', "
                    + (this.perdido ? 1 : 0) + ")";

            try {
                int result = connection.updateDataBase(query);
                if (result > 0) {
                    logger.log(Level.INFO, "Mascota registrada exitosamente.");
                    return "Mascota registrada exitosamente.";
                } else {
                    logger.log(Level.WARNING, "Error al registrar la mascota.");
                    return "Error al registrar la mascota.";
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error al registrar la mascota: " + e.getMessage());
                return "Error al registrar la mascota.";
            }
        }
    }

    public boolean existeMascota() {
        DbConnection connection = new DbConnection();
        String query = "SELECT COUNT(*) FROM mascotas WHERE nombre = '" + this.nombre +
                "' AND raza = '" + this.raza + "' AND id_usuario = '" + this.idUsuario + "'";

        try {
            int count = connection.getCount(query);
            return count > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al verificar existencia de mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarMascota() {
        DbConnection connection = new DbConnection();
        String updateQuery = "UPDATE mascotas SET perdido = " + (this.perdido ? 1 : 0) +
                " WHERE nombre = '" + this.nombre + "' AND id_usuario = '" + this.idUsuario + "'";

        try {
            int result = connection.updateDataBase(updateQuery);
            if (result > 0) {
                logger.log(Level.INFO, "Mascota actualizada exitosamente.");
                return true;
            } else {
                logger.log(Level.WARNING, "No se encontró la mascota para actualizar.");
                return false;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar la mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEstadoPerdido() {
        DbConnection connection = new DbConnection();
        String updateQuery = "UPDATE mascotas SET perdido = 1 WHERE nombre = '" + this.nombre + "' AND id_usuario = '" + this.idUsuario + "'";

        try {
            int result = connection.updateDataBase(updateQuery);
            if (result > 0) {
                logger.log(Level.INFO, "Estado de la mascota actualizado a perdido exitosamente.");
                return true;
            } else {
                logger.log(Level.WARNING, "No se encontró la mascota para actualizar.");
                return false;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar el estado de la mascota: " + e.getMessage());
            return false;
        }
    }

}


