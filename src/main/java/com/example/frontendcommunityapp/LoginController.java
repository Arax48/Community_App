package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Controller.DbConnection;
import com.example.frontendcommunityapp.Model.Users.Admin;
import com.example.frontendcommunityapp.Model.Users.Resident;
import com.example.frontendcommunityapp.Model.Users.Vigilante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label mylabel;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registroButton;

    @FXML
    public void handleLoginButtonAction(ActionEvent actionEvent) throws IOException, SQLException {
        String nombre = userNameField.getText();
        String pass = passwordField.getText();

        // Validación de campos vacíos
        if (nombre.isEmpty() || pass.isEmpty()) {
            mylabel.setText("Por favor, ingrese su nombre de usuario y contraseña.");
            return;
        }

        // Consulta a la base de datos
        String query = "SELECT * FROM usuarios WHERE username = '" + nombre + "' AND password = '" + pass + "'";
        DbConnection connection = new DbConnection();
        try {
            ResultSet rs = connection.getQueryTable(query);
            if (rs.next()) {
                if (rs.getBoolean(10)) { // Residente
                    Resident loggedInResident = new Resident(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));

                    root = FXMLLoader.load(getClass().getResource("ServicesResident.fxml"));
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else if (rs.getBoolean(9)) { // Administrador
                    Admin loggedInAdmin = new Admin(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));

                    root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else if (rs.getBoolean(11)) { // Vigilante
                    Vigilante loggedVigilante = new Vigilante(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6));

                    // Cargar la vista del vigilante con FXMLLoader
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesVigilante.fxml"));
                    root = loader.load();

                    // Obtener el controlador y pasar los detalles del vigilante
                    ServicesVigilanteController servicesVigilanteController = loader.getController();
                    servicesVigilanteController.setVigilanteDetails(loggedVigilante.getNombre(), loggedVigilante.getId_usuario());


                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            } else {
                mylabel.setText("Inicio de sesión fallido, ingrese credenciales correctas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void switchRegisterPage(ActionEvent actionEvent) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
