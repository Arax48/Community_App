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

public class ListadosVigilanteController {
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
        String query = "SELECT asunto, estado FROM novedadesvigilante";
        try {
            ResultSet resultSet = connection.getQueryTable(query);
            while (resultSet != null && resultSet.next()) {
                String asunto = resultSet.getString("asunto");
                String estado = resultSet.getString("estado");
                listViewMascotas.getItems().add(asunto + " - " + estado);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar las mascotas.", e);
        }
    }

    private void cargarMascotasPerdidas() {
        DbConnection connection = new DbConnection();
        String query = "SELECT asunto, estado FROM novedadesvigilante WHERE estado = 'A'";
        try {
            ResultSet resultSet = connection.getQueryTable(query);
            StringBuilder mascotasPerdidas = new StringBuilder();
            while (resultSet != null && resultSet.next()) {
                String asunto = resultSet.getString("asunto");
                String estado = resultSet.getString("estado");
                mascotasPerdidas.append(asunto).append(" - ").append(estado).append("\n");
            }
            textAreaMascotasPerdidas.setText(mascotasPerdidas.toString());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar las novedades de vigilantes.", e);
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
        String query = "SELECT * FROM novedadesvigilante WHERE asunto = '" + nombreMascota + "'";
        try {
            ResultSet resultSet = connection.getQueryTable(query);
            if (resultSet != null && resultSet.next()) {
                String detalles = "Nombre: " + resultSet.getString("asunto") + "\n" +
                        "Raza: " + resultSet.getString("peticion") + "\n" +
                        "ID Usuario: " + resultSet.getString("idVigilante") + "\n" +
                        "Casa/Apartamento: " + resultSet.getString("estado");
                textAreaDetallesMascota.setText(detalles);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar los detalles de las novedades.", e);
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


