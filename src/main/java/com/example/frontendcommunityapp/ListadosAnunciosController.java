package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Anuncio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListadosAnunciosController {

    @FXML
    private ListView<String> listaAnunciosView;

    @FXML
    private void handleBackButtonAction() {
        try {
            // Cargar la vista de ServicesAdmin.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) listaAnunciosView.getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarListaAnuncios(List<Anuncio> listaAnuncios) {
        for (Anuncio anuncio : listaAnuncios) {
            String detalle = "Fecha: " + anuncio.getFecha() + ", Asunto: " + anuncio.getAsunto() +
                    ", Descripción: " + anuncio.getDescripcion();
            listaAnunciosView.getItems().add(detalle);
        }
    }
}
