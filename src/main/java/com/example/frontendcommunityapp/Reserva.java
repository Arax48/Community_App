package com.example.frontendcommunityapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reserva {
    private final StringProperty nombre;
    private final StringProperty casa;
    private final StringProperty fecha;
    private final StringProperty horario;
    private final StringProperty contacto;
    private final StringProperty idArea;

    public Reserva(String nombre, String casa, String fecha, String horario, String contacto, String idArea) {
        this.nombre = new SimpleStringProperty(nombre);
        this.casa = new SimpleStringProperty(casa);
        this.fecha = new SimpleStringProperty(fecha);
        this.horario = new SimpleStringProperty(horario);
        this.contacto = new SimpleStringProperty(contacto);
        this.idArea = new SimpleStringProperty(idArea);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty casaProperty() {
        return casa;
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public StringProperty horarioProperty() {
        return horario;
    }

    public StringProperty contactoProperty() {
        return contacto;
    }

    public StringProperty idAreaProperty() {
        return idArea;
    }
}
