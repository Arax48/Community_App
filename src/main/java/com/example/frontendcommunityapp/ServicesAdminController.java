package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;

public class ServicesAdminController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToPagosPage(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("PagosAdmin.fxml"));
        } catch (IOException e) {
            showAlert("Error", "No se pudo abrir la vista de pagos: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminDashboard(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        } catch (IOException e) {
            showAlert("Error", "No se pudo abrir el panel de administración: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMascotasAdmin(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("RegistroMascotasAdmin.fxml"));
        } catch (IOException e) {
            showAlert("Error", "No se pudo abrir la vista de mascotas: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchAnunciosPage(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("AnunciosPage.fxml"));
        } catch (IOException e) {
            showAlert("Error", "No se pudo abrir la vista de anuncios: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchRegisterPage(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        } catch (IOException e) {
            showAlert("Error", "No se pudo abrir la vista de registro: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToReservasComunes(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistroReservas.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "No se pudo abrir la vista de reservas comunes: " + e.getMessage());
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
}
