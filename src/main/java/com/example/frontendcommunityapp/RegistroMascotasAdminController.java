package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroMascotasAdminController {

    private static final Logger logger = Logger.getLogger(RegistroMascotasResidentController.class.getName());

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField textFieldNombreMascota;

    @FXML
    private TextField textFieldRaza;

    @FXML
    private TextField textFieldIdCasaApto;

    @FXML
    private CheckBox checkBoxPerdido;

    @FXML
    private TextField messageVerifyRegister;

    @FXML
    private TextField idAdminMascotas;

    @FXML
    private TextField nombreAdminMascotas;


    public void setAdminDetails(String name, int idUsuario) {
        nombreAdminMascotas.setText(name);
        idAdminMascotas.setText(String.valueOf(idUsuario));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {

    }

    public void volverAServiciosAdmin(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            root = loader.load();

            ServicesAdminController controller = loader.getController();
            // Pasa los datos al controlador de ServicesVigilante
            controller.setAdminDetails(nombreAdminMascotas.getText(), Integer.parseInt(idAdminMascotas.getText()));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de Admin no válido.");
        }
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void registrarMascota(ActionEvent event) throws IOException {
        try {
            String nombre = textFieldNombreMascota.getText();
            String raza = textFieldRaza.getText();
            String idCasaAptoText = textFieldIdCasaApto.getText();

            if (nombre.isEmpty() || raza.isEmpty() || idCasaAptoText.isEmpty()) {
                logger.log(Level.WARNING, "Todos los campos deben ser completados.");
                return;
            }

            int idUsuario = Integer.parseInt(idCasaAptoText);
            boolean perdido = checkBoxPerdido.isSelected();

            RegistroMascotas registro = new RegistroMascotas(nombre, raza, idUsuario, perdido);
            registro.registrarMascota();

            System.out.println("RegistroMascotas registrada: " + nombre);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "ID de usuario no válido.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al registrar mascota", e);
        }

        messageVerifyRegister.setText("Mascota Registrada");
    }

}
