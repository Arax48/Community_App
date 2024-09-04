package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServicesResidentController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToPagosPage(ActionEvent actionEvent) throws IOException {
        cargarVista("PagosResident.fxml", actionEvent);
    }

    public void switchMascotasView(ActionEvent actionEvent) throws IOException {
        cargarVista("RegistroMascotasResident.fxml", actionEvent);
    }

    public void quejasView(ActionEvent actionEvent) {
        cargarVista("Quejas.fxml", actionEvent);
    }

    public void salirResidente(ActionEvent actionEvent) {
        cargarVista("login.fxml", actionEvent);
    }

    // Nuevo método para mostrar la selección de áreas comunes
    public void mostrarReservas(ActionEvent actionEvent) throws IOException {
        cargarVista("SeleccionAreasComunes.fxml", actionEvent);
    }

    // Método auxiliar para cargar vistas
    private void cargarVista(String fxmlFile, ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlFile));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
