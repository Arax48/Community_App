package com.example.frontendcommunityapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class DashboardController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label bienvenidaAdmin;

    @FXML
    private Label idAdmin;

    private Button serviceButton;

    // Este método se llamará desde LoginController para establecer el nombre y el ID del vigilante
    public void setAdminDetails(String name, int idUsuario) {
        bienvenidaAdmin.setText(name);
        idAdmin.setText(String.valueOf(idUsuario));
    }
/*
    public void switchToServicesPage(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("ServicesResident.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/
    public void switchToServicesPage(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            root  = FXMLLoader.load(getClass().getResource("ServicesAdmin.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void salirDash(ActionEvent actionEvent) {
        try {
            root  = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
