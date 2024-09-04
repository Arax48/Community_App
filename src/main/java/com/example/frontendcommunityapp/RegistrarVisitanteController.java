package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Users.*;
import javafx.event.ActionEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

public class RegistrarVisitanteController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private TextField textFieldTorre;

    @FXML
    private TextField textFieldApto;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextArea tfTextArea1;

    @FXML
    private Button buttonRegistrar;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField tfHora;

    @FXML
    private TextField tfMinuto;

    @FXML
    private TextField nombreVigilanteField;

    @FXML
    private TextField idUsuarioField;

    @FXML
    private Label userLabelRegisVisi;

    @FXML
    private Label idRegisVisi;

    @FXML
    private TextField confirmacion;

    public void setVigilanteDetails(String name, int idUsuario) {
        userLabelRegisVisi.setText(name);
        idRegisVisi.setText(String.valueOf(idUsuario));
    }

    public String getTextAreaText() {
        if (tfTextArea1 == null || tfTextArea1.getText().isEmpty()) {
            return "";
        }
        return tfTextArea1.getText();
    }

    public String convertDateFormatToStringmySQL(DatePicker date) {
        String dateString = date.getEditor().getText();
        LocalDate selectedDate = date.getValue();
        int year = selectedDate.getYear();
        int month = selectedDate.getMonthValue();
        int day = selectedDate.getDayOfMonth();

        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);
        String dayStr = String.valueOf(day);

        String mySQLDateFormat = yearStr + "-" + monthStr + "-" + dayStr;


        return mySQLDateFormat;

    }


    public String timeFormat(String hora, String minuto) {
        String horaFormatSQL = hora + ":" + minuto;
        return horaFormatSQL;
    }

    public void registrarVisitante(javafx.event.ActionEvent actionEvent) throws IOException {

        String nombre = textFieldNombre.getText();
        String date = convertDateFormatToStringmySQL(datePicker);
        String time = timeFormat(tfHora.getText(), tfMinuto.getText());
        String telefono = textFieldTelefono.getText();
        String torre = textFieldTorre.getText();
        String apto = textFieldApto.getText();
        String id = textFieldId.getText();

        String proposito = getTextAreaText();


        Visitante visitante = new Visitante(12, nombre, date,
                time, telefono, id, torre, apto, proposito);

        visitante.registrarVisitanteDB(nombre, date,
                time, telefono, id, torre, apto, proposito);

        System.out.println("Visitante creado con éxtio");


        System.out.println(date);
        System.out.println(proposito);

        confirmacion.setText("Visitante registrado");
    }


    public void AtrasServicesVigilante(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesVigilante.fxml"));
            root = loader.load();

            ServicesVigilanteController controller = loader.getController();
            // Pasa los datos al controlador de ServicesVigilante
            controller.setVigilanteDetails(userLabelRegisVisi.getText(), Integer.parseInt(idRegisVisi.getText()));

            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de vigilante no válido.");
        }
    }

        private void mostrarAlerta (String title, String message){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }

