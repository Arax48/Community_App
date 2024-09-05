package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Users.Admin;
import com.example.frontendcommunityapp.Model.Users.Resident;
import com.example.frontendcommunityapp.Model.Users.User;
import com.example.frontendcommunityapp.Model.Users.Vigilante;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldTorre;

    @FXML
    private TextField textFieldApto;
    /*
    @FXML
    private RadioButton radioButtonAdmin;

    @FXML
    private RadioButton radioButtonResident;

    @FXML
    private RadioButton radioButtonVigilante;

    */

    @FXML
    private Label errorMessage;

    @FXML
    private ChoiceBox<String> users;

    @FXML
    private Button buttonRegistrar;

    @FXML
    private TextField confirmacion;

    @FXML
    private Label userRegister;

    @FXML
    private Label idRegister;




    private String[] usuarios = {"Admin", "Residente", "Vigilante"};
    boolean isSelected = false;


    public void setAdminDetails(String name, int idUsuario) {
        userRegister.setText(name);
        idRegister.setText(String.valueOf(idUsuario));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users.getItems().addAll(usuarios);
    }


    public void registrarUsuario(javafx.event.ActionEvent actionEvent) throws IOException {

        String nombre = textFieldNombre.getText();
        String telefono = textFieldTelefono.getText();
        String email = textFieldEmail.getText();
        String pass = passwordField.getText();
        String username = textFieldUsername.getText();
        String torre = textFieldTorre.getText();
        String apto = textFieldApto.getText();

        String user = users.getValue();
        System.out.println(user);



            if (user == "Admin") {
                if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty() ||
                    pass.isEmpty() || username.isEmpty() || torre.isEmpty() || apto.isEmpty()) {
                    errorMessage.setText("Digite todos los campos");
            } else {

                Admin createdAdmin = new Admin(12, nombre,
                        telefono, email, pass, username, torre, apto);

                createdAdmin.registrarAdminDB(nombre, telefono, email, pass, username, torre, apto);
                System.out.println("Admin creado con éxtio");
                confirmacion.setText("Usuario registrado");
                errorMessage.setText("");
            }
            }
            else if (user == "Residente") {
                if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty() ||
                    pass.isEmpty() || username.isEmpty() || torre.isEmpty() || apto.isEmpty()) {
                errorMessage.setText("Digite todos los campos");
            } else {
                Resident createdResident = new Resident(12, nombre,
                        telefono, email, pass, username, torre, apto);

                createdResident.registrarResidentDB(nombre, telefono, email, pass, username, torre, apto);
                System.out.println("Residente creado con éxtio");
                    confirmacion.setText("Usuario registrado");
                    errorMessage.setText("");

            }
        } else if(user == "Vigilante") {
            if (!apto.isEmpty()) {
                errorMessage.setText("Vigilante no se le asocia torre y apto favor dejar los campos vacios");
            }  else {
                Vigilante createdVigilante = new Vigilante(12, nombre,
                        telefono, email, pass, username);

                createdVigilante.registrarVigilanteDB(nombre, telefono, email, pass, username);
                System.out.println("Vigilante creado con éxtio");
                confirmacion.setText("Usuario registrado");
                errorMessage.setText("");
                }

            }


    }

    public void switchAdminServices(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesAdmin.fxml"));
            root = loader.load();

            ServicesAdminController controller = loader.getController();
            // Pasa los datos al controlador de ServicesVigilante
            //controller.setAdminDetails(userRegister.getText(), Integer.parseInt(idRegister.getText()));

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


}

