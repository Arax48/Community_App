package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Controller.DbConnection;
import com.example.frontendcommunityapp.Model.Services.Anuncio;
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
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AnunciosPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField idAdmin1;

    @FXML
    private TextField fechaField;

    @FXML
    private TextField asuntoField;

    @FXML
    private TextArea descripcionField;

    @FXML
    private TextField nombreAdmin;

    @FXML
    public void initialize() {
        // Inicializa el campo de fecha con la fecha y hora actuales
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fechaField.setText(now.format(formatter));
    }

    public void setAdminDetails(String name, int idUsuario) {
        nombreAdmin.setText(name);
        idAdmin1.setText(String.valueOf(idUsuario));
    }

    @FXML
    public void volverAServiciosAdmin(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            root = loader.load();

            ServicesAdminController controller = loader.getController();
            // Pasa los datos al controlador de ServicesAdmin
            controller.setAdminDetails(nombreAdmin.getText(), Integer.parseInt(idAdmin1.getText()));

            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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

    private void limpiarCampos() {
        fechaField.clear();
        asuntoField.clear();
        descripcionField.clear();
    }

    @FXML
    public void registrarAnuncio(ActionEvent actionEvent) throws IOException {
        String fecha = fechaField.getText();
        String asunto = asuntoField.getText();
        String descripcion = descripcionField.getText();
        int idAdmin;

        try {
            idAdmin = Integer.parseInt(idAdmin1.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de admin debe ser un número.");
            return;
        }

        Anuncio anuncio = new Anuncio(fecha, asunto, descripcion, idAdmin);
        anuncio.registrarAnuncioDB();

        mostrarAlerta("Éxito", "Anuncio registrado correctamente.");
        limpiarCampos();

        // Opcionalmente, puedes redirigir al usuario a una página de notificaciones
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Notificaciones.fxml"));
        root = loader.load();
        NotificacionesController controller = loader.getController();
        // Pasa los datos al controlador de Notificaciones
        controller.setNotificacion(asunto);

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }






}
