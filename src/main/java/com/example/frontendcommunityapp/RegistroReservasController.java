package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegistroReservasController {
    @FXML
    private TableView<Reserva> tablaReservas;
    @FXML
    private TableColumn<Reserva, String> colNombre;
    @FXML
    private TableColumn<Reserva, String> colCasa;
    @FXML
    private TableColumn<Reserva, String> colFecha;
    @FXML
    private TableColumn<Reserva, String> colHorario;
    @FXML
    private TableColumn<Reserva, String> colContacto;

    private ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();

    public void initialize() {
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colCasa.setCellValueFactory(cellData -> cellData.getValue().casaProperty());
        colFecha.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        colHorario.setCellValueFactory(cellData -> cellData.getValue().horarioProperty());
        colContacto.setCellValueFactory(cellData -> cellData.getValue().contactoProperty());

        cargarReservas();
    }

    private void cargarReservas() {
        String query = "SELECT nombre, casa, fecha, horario, contacto FROM reservas";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/communityappdb", "silvana", "");
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String casa = rs.getString("casa");
                String fecha = rs.getString("fecha");
                String horario = rs.getString("horario");
                String contacto = rs.getString("contacto");
                listaReservas.add(new Reserva(nombre, casa, fecha, horario, contacto));
            }
            tablaReservas.setItems(listaReservas);
        } catch (SQLException e) {
            showAlert("Error", "No se pudieron cargar las reservas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void regresarServicios(ActionEvent event) throws IOException {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cierra la ventana actual
        stageActual.close();

        // Carga la escena de anterior
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Crea un nuevo Stage y muestra la escena
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.show();
    }
}

