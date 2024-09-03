package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ServicesVigilanteController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label vigilanteNameLabel; // Este es el Label en el que mostraremos el nombre del vigilante

    @FXML
    private Label vigilanteIdLabel; // Este es el Label en el que mostraremos el ID del vigilante

    // Este método se llamará desde LoginController para establecer el nombre y el ID del vigilante
    public void setVigilanteDetails(String name, int idUsuario) {
        vigilanteNameLabel.setText(name);
        vigilanteIdLabel.setText(String.valueOf(idUsuario));
    }

    public void switchRegistrarVisitantePage(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("RegistrarVisitante.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void salirVigilanteServices(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ReportarNovedadVigilante(ActionEvent actionEvent) {
        try {
            // Cargar la vista de NovedadesVigilante.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NovedadesVigilante.fxml"));
            root = loader.load();

            // Obtener el controlador de la vista NovedadesVigilante.fxml
            NovedadesVigilanteController controller = loader.getController();
            controller.setVigilanteDetails(vigilanteNameLabel.getText(), Integer.parseInt(vigilanteIdLabel.getText()));

            // Cambiar la escena a NovedadesVigilante.fxml
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
