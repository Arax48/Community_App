package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;
import com.example.frontendcommunityapp.Model.Services.Services;
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

public class RegistroMascotasResidentController {
    private static final Logger logger = Logger.getLogger(RegistroMascotasResidentController.class.getName());

    @FXML
    private TextField textFieldNombreMascota;

    @FXML
    private TextField textFieldRaza;

    @FXML
    private TextField textFieldIdUsuario; // Cambiado de IdCasaApto a IdUsuario

    @FXML
    private TextField textFieldCasaOapto; // Nueva columna

    @FXML
    private CheckBox checkBoxPerdido;

    @FXML
    private TextField messageVerifyRegister;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private TextField idUsuarioMascotas;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setResidentDetails(String name, int idUsuario) {
        nombreUsuario.setText(name);
        idUsuarioMascotas.setText(String.valueOf(idUsuario));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // Inicialización
    }

    @FXML
    public void registrarMascota(ActionEvent actionEvent) {
        try {
            String nombre = textFieldNombreMascota.getText();
            String raza = textFieldRaza.getText();
            String idUsuario = idUsuarioMascotas.getText();
            String casaOapto = textFieldCasaOapto.getText();

            // Validación de campos vacíos
            if (nombre.isEmpty() || raza.isEmpty() || idUsuario.isEmpty() || casaOapto.isEmpty()) {
                logger.log(Level.WARNING, "Todos los campos deben ser completados.");
                messageVerifyRegister.setText("Por favor completa todos los campos.");
                return;
            }

            boolean perdido = checkBoxPerdido.isSelected();

            RegistroMascotas registroMascotas = new RegistroMascotas(nombre, raza, idUsuario, casaOapto, perdido);

            // Llama al método para registrar o actualizar la mascota
            String mensaje = registroMascotas.registrarMascota();
            messageVerifyRegister.setText(mensaje);

            if (perdido) {
                messageVerifyRegister.setText("La mascota ha sido reportada como perdida. " +
                        "En caso de encontrarla, por favor actualice el registro.");
            }

            logger.log(Level.INFO, "Mascota registrada exitosamente.");
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Error al convertir el ID de usuario.", e);
            messageVerifyRegister.setText("Error al convertir el ID de usuario.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado.", e);
            messageVerifyRegister.setText("Ocurrió un error inesperado.");
        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
            root = loader.load();

            ServicesResidentController controller = loader.getController();
            // Pasa los datos al controlador de ServicesVigilante
            //controller.setResidentDetails(nombreUsuario.getText(), Integer.parseInt(idUsuarioMascotas.getText()));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de residente no válido.");
        }

        /*
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.show();

         */
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void actualizarEstadoPerdido(ActionEvent actionEvent) {
        try {
            String nombre = textFieldNombreMascota.getText();
            String idUsuario = textFieldIdUsuario.getText();

            // Solo se necesita el nombre y el idUsuario para actualizar el estado
            RegistroMascotas registroMascotas = new RegistroMascotas(nombre, "", idUsuario, "", true); // Se asume que se está reportando como perdido

            if (registroMascotas.actualizarEstadoPerdido()) {
                messageVerifyRegister.setText("El estado de la mascota ha sido actualizado a perdido.");
            } else {
                messageVerifyRegister.setText("Error al actualizar el estado de la mascota.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado.", e);
            messageVerifyRegister.setText("Ocurrió un error inesperado.");
        }
    }

}




