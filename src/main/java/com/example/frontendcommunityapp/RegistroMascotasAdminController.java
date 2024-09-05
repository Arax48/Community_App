package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;
import com.example.frontendcommunityapp.Controller.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.SelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroMascotasAdminController {
    private static final Logger logger = Logger.getLogger(RegistroMascotasAdminController.class.getName());

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<String> listViewMascotas;

    @FXML
    private TextArea textAreaMascotasPerdidas;

    @FXML
    private TextArea textAreaDetallesMascota; // Para mostrar detalles de la mascota seleccionada

    @FXML
    public void initialize() {
        cargarMascotas();
        cargarMascotasPerdidas();
    }

    private void cargarMascotas() {
        DbConnection connection = new DbConnection();
        String query = "SELECT nombre, raza FROM mascotas";
        try {
            ResultSet resultSet = connection.getQueryTable(query);
            while (resultSet != null && resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String raza = resultSet.getString("raza");
                listViewMascotas.getItems().add(nombre + " - " + raza);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar las mascotas.", e);
        }
    }

    private void cargarMascotasPerdidas() {
        DbConnection connection = new DbConnection();
        String query = "SELECT nombre, raza FROM mascotas WHERE perdido = 1";
        try {
            ResultSet resultSet = connection.getQueryTable(query);
            StringBuilder mascotasPerdidas = new StringBuilder();
            while (resultSet != null && resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String raza = resultSet.getString("raza");
                mascotasPerdidas.append(nombre).append(" - ").append(raza).append("\n");
            }
            textAreaMascotasPerdidas.setText(mascotasPerdidas.toString());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar las mascotas perdidas.", e);
        }
    }

    @FXML
    private void mostrarDetallesMascota(MouseEvent event) {
        String selectedItem = listViewMascotas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String nombre = selectedItem.split(" - ")[0]; // Obtener el nombre de la mascota
            mostrarDetalles(nombre);
        }
    }

    private void mostrarDetalles(String nombreMascota) {
        DbConnection connection = new DbConnection();
        String query = "SELECT mascotas.nombre AS nombreM, mascotas.raza AS raza,  usuarios.nombre AS id_usuario, mascotas.casa_o_apto, mascotas.perdido FROM mascotas INNER JOIN usuarios ON mascotas.id_usuario = usuarios.id_usuario WHERE mascotas.nombre = '" + nombreMascota + "' ";
        try {
            ResultSet resultSet = connection.getQueryTable(query);
            if (resultSet != null && resultSet.next()) {
                String detalles = "Nombre: " + resultSet.getString("nombreM") + "\n" +
                        "Raza: " + resultSet.getString("raza") + "\n" +
                        "Nombre Usuario: " + resultSet.getString("id_usuario") + "\n" +
                        "Casa/Apartamento: " + resultSet.getString("casa_o_apto") + "\n" +
                        "Estado Perdido: " + (resultSet.getBoolean("perdido") ? "Sí" : "No");
                textAreaDetallesMascota.setText(detalles);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar los detalles de la mascota.", e);
        }
    }

    @FXML
    private void handleBackButtonAction() {
        try {
            // Cargar la vista de ServicesAdmin.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) listViewMascotas.getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


