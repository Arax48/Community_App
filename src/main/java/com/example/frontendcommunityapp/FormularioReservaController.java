package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class FormularioReservaController {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField casaField;
    @FXML
    private DatePicker fechaField;
    @FXML
    private TextField horarioField;
    @FXML
    private TextField contactoField;

    private int areaId;

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @FXML
    private void reservarArea() {
        String nombre = nombreField.getText();
        String casa = casaField.getText();
        String fecha = fechaField.getValue() != null ? fechaField.getValue().toString() : null;
        String horario = horarioField.getText();
        String contacto = contactoField.getText();

        // Validar campos
        if (nombre.isEmpty() || casa.isEmpty() || fecha == null || horario.isEmpty() || contacto.isEmpty()) {
            showAlert("Error", "Todos los campos deben ser completados.");
            return;
        }

        // Verificar si ya existe una reserva
        String query = "SELECT * FROM reservas WHERE id_area = ? AND fecha = ? AND horario = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/community", "root", "1234");
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, areaId);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                showAlert("Reserva Existente", "Ya hay una reserva para el área en esta fecha y horario.");
            } else {
                // Insertar nueva reserva
                String insertQuery = "INSERT INTO reservas (nombre, casa, fecha, horario, contacto, id_area, id_usuario) VALUES (?, ?, ?, ?, ?, ?,?)";
                try (PreparedStatement pstmtInsert = conn.prepareStatement(insertQuery)) {
                    pstmtInsert.setString(1, nombre);
                    pstmtInsert.setString(2, casa);
                    pstmtInsert.setString(3, fecha);
                    pstmtInsert.setString(4, horario);
                    pstmtInsert.setString(5, contacto);
                    pstmtInsert.setInt(6, areaId);
                    pstmtInsert.setInt(7, 20);
                    pstmtInsert.executeUpdate();
                    showAlert("Reserva Exitosa", "Reserva realizada con éxito.");
                }
            }
        } catch (SQLException e) {
            showAlert("Error", "Ha ocurrido un error al procesar la reserva: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void volver(ActionEvent event) throws IOException {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cierra la ventana actual
        stageActual.close();

        // Carga la escena de anterior
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeleccionAreasComunes.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Crea un nuevo Stage y muestra la escena
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.show();
    }
}