package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Queja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QuejasController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField idUsuarioField;

    @FXML
    private TextField fechaField;

    @FXML
    private TextField asuntoField;

    @FXML
    private TextArea descripcionField;

    @FXML
    private TextField nombreQuejas;

    @FXML
    public void initialize() {
        // Inicializa el campo de fecha con la fecha y hora actuales
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fechaField.setText(now.format(formatter));
    }

    // Método para recibir y mostrar los detalles del Residente
    public void setResidentDetails(String nombre, int idUsuario) {
        idUsuarioField.setText(String.valueOf(idUsuario));
        nombreQuejas.setText(nombre);
    }



    @FXML
    public void registrarQueja(javafx.event.ActionEvent actionEvent) throws IOException {
        String fecha = fechaField.getText();
        String asunto = asuntoField.getText();
        String descripcion = descripcionField.getText();
        int idUsuario;

        try {
            idUsuario = Integer.parseInt(idUsuarioField.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de usuario debe ser un número.");
            return;
        }

        Queja queja = new Queja(fecha, asunto, descripcion, idUsuario);
        queja.registrarQuejaDB();

        mostrarAlerta("Éxito", "Queja registrada correctamente.");
        limpiarCampos();
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        fechaField.clear();
        asuntoField.clear();
        descripcionField.clear();
        idUsuarioField.clear();
    }

    public void volverAServiciosResident(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
            root = loader.load();

            ServicesResidentController controller = loader.getController();
            // Pasa los datos al controlador de ServicesResident
           // controller.setResidentDetails(nombreQuejas.getText(), Integer.parseInt(idUsuarioField.getText()));

            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de residente no válido.");
        }
        /*
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */

    }
}
