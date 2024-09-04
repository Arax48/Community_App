package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.NovedadVigilante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListadosVigilanteController {

    @FXML
    private ListView<String> listaNovedadesView;

    @FXML
    private void handleBackButtonAction() {
        try {
            // Cargar la vista de ServicesAdmin.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) listaNovedadesView.getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarListaNovedades(List<NovedadVigilante> listaNovedades) {
        for (NovedadVigilante novedad : listaNovedades) {
            String detalle = "Fecha: " + novedad.getFecha() + ", Asunto: " + novedad.getAsunto() +
                    ", Descripción: " + novedad.getDescripcion() + ", ID Vigilante: " + novedad.getIdUsuario();
            listaNovedadesView.getItems().add(detalle);
        }
    }
}
