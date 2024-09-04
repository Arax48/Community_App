package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.AreasComunes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AreasComunesController {

    private List<AreasComunes> areasComunes;



    public AreasComunesController() {
        areasComunes = new ArrayList<>();
        inicializarAreasComunes();
    }

    private void inicializarAreasComunes() {
        areasComunes.add(new AreasComunes("Salón Social", "Un lugar para eventos y reuniones.", List.of("08:00-12:00", "14:00-20:00"), 1));
        areasComunes.add(new AreasComunes("Piscina", "Área para nadar y relajarse.", List.of("06:00-12:00", "13:00-20:00"), 2));
        areasComunes.add(new AreasComunes("Juegos", "Zona de juegos como billar, tenis de mesa.", List.of("10:00-12:00", "16:00-22:00"), 3));
        areasComunes.add(new AreasComunes("Cancha Deportiva", "Cancha para deportes como fútbol y baloncesto.", List.of("08:00-12:00", "14:00-20:00"), 4));
    }

    public void reservarSalonSocial(javafx.event.ActionEvent actionEvent) throws IOException {
        abrirFormularioReserva(areasComunes.get(0).getId(), actionEvent);
    }

    public void reservarPiscina(javafx.event.ActionEvent actionEvent) throws IOException {
        abrirFormularioReserva(areasComunes.get(1).getId(), actionEvent);
    }

    public void reservarJuegos(javafx.event.ActionEvent actionEvent) throws IOException {
        abrirFormularioReserva(areasComunes.get(2).getId(), actionEvent);
    }

    public void reservarCanchaDeportiva(javafx.event.ActionEvent actionEvent) throws IOException {
        abrirFormularioReserva(areasComunes.get(3).getId(), actionEvent);
    }

    private void abrirFormularioReserva(int areaId, javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioReserva.fxml"));
        Parent root = loader.load();
        FormularioReservaController controller = loader.getController();
        controller.setAreaId(areaId);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void volverServicesResident(ActionEvent event) throws IOException {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cierra la ventana actual
        stageActual.close();

        // Carga la escena de anterior
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Crea un nuevo Stage y muestra la escena
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.show();
    }
}
