package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListadosAdminController {

    @FXML
    private ListView<String> listaMascotasView;

    @FXML
    private void handleBackButtonAction() {
        try {
            // Cargar la vista de ServicesAdmin.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) listaMascotasView.getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarListaMascotas(List<RegistroMascotas> listaMascotas) {
        for (RegistroMascotas mascota : listaMascotas) {
            String detalle = "Nombre: " + mascota.getNombreMascota() + ", Raza: " + mascota.getRaza() +
                    ", ID Casa/Apto: " + mascota.getIdCasaApto() + ", Perdido: " + (mascota.isPerdido() ? "Sí" : "No");
            listaMascotasView.getItems().add(detalle);
        }
    }
}
