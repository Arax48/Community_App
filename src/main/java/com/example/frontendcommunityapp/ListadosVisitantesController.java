package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Users.Visitante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListadosVisitantesController {

    @FXML
    private ListView<String> listaVisitantesView;

    @FXML
    private void handleBackButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) listaVisitantesView.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarListaVisitantes(List<Visitante> listaVisitantes) {
        for (Visitante visitante : listaVisitantes) {
            String detalle = "ID: " + visitante.getIdVisitante() + ", Nombre: " + visitante.getNombre() +

                    ", Teléfono: " + visitante.getTelefono() + ", Torre: " + visitante.getTorre() +
                    ", Apt: " + visitante.getApto() + ", Doc ID: " + visitante.getDocIdentidad();

            listaVisitantesView.getItems().add(detalle);
        }
    }
}
