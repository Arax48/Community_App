package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ServicesAdminController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label bienvenidaAdmin;

    @FXML
    private Label idAdmin;

    public void setAdminDetails(String name, int idUsuario) {
        bienvenidaAdmin.setText(name);
        idAdmin.setText(String.valueOf(idUsuario));
    }

    public void switchToPagosPage(ActionEvent actionEvent) {
        try {
            root  = FXMLLoader.load(getClass().getResource("PagosAdmin.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToAdminDashboard(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            root = loader.load();

            DashboardController controller = loader.getController();
            // Pasa los datos al controlador de Dashboard
            controller.setAdminDetails(bienvenidaAdmin.getText(), Integer.parseInt(idAdmin.getText()));

            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de Admin no válido.");
        }
    }


    public void switchToMascotasAdmin(ActionEvent actionEvent) {
        try {
            // Cargar la vista de NovedadesVigilante.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistroMascotasAdmin.fxml"));
            root = loader.load();

            // Obtener el controlador de la vista NovedadesVigilante.fxml
            RegistroMascotasAdminController controller = loader.getController();
            controller.setAdminDetails(bienvenidaAdmin.getText(), Integer.parseInt(idAdmin.getText()));

            // Cambiar la escena a NovedadesVigilante.fxml
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchAnunciosPage(ActionEvent actionEvent) {
        try {
            // Cargar la vista de NovedadesVigilante.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AnunciosPage.fxml"));
            root = loader.load();

            // Obtener el controlador de la vista NovedadesVigilante.fxml
            AnunciosPageController controller = loader.getController();
            controller.setAdminDetails(bienvenidaAdmin.getText(), Integer.parseInt(idAdmin.getText()));

            // Cambiar la escena a NovedadesVigilante.fxml
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchRegisterPage(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void switchLogin(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

