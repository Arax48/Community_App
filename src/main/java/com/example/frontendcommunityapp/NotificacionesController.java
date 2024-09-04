package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NotificacionesController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button buttonInput;

    @FXML
    private Button buttonOutput;

    @FXML
    private TextField idResidentNotificaciones;

    @FXML
    private TextField nombreResidentNotificaciones;


    public void setResidentDetails(String name, int idUsuario) {
        nombreResidentNotificaciones.setText(name);
        idResidentNotificaciones.setText(String.valueOf(idUsuario));
    }

    public void setNotificacion(String notificacion) {
        buttonOutput.setText(notificacion);
    }


    public void setTextOutput(ActionEvent event) {

    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void atrasResidentServices(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
            root = loader.load();

            ServicesResidentController controller = loader.getController();
            // Pasa los datos al controlador de ServicesResident
            controller.setResidentDetails(nombreResidentNotificaciones.getText(), Integer.parseInt(idResidentNotificaciones.getText()));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de Resident no válido.");
        }
    }


}
