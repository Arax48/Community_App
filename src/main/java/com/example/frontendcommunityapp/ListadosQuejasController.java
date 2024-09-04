package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Queja;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListadosQuejasController {

    @FXML
    private ListView<String> listaQuejasView;

    @FXML
    private void handleBackButtonAction() {
        try {
            // Cargar la vista de ServicesAdmin.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) listaQuejasView.getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarListaQuejas(List<Queja> listaQuejas) {
        for (Queja queja : listaQuejas) {
            String detalle = "Fecha: " + queja.getFecha() + ", Asunto: " + queja.getAsunto() +
                    ", Descripción: " + queja.getDescripcion();
            listaQuejasView.getItems().add(detalle);
        }
    }
}
