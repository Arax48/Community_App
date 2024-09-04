package com.example.frontendcommunityapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reserva {
    private final StringProperty nombre;
    private final StringProperty casa;
    private final StringProperty fecha;
    private final StringProperty horario;
    private final StringProperty contacto;

    public Reserva(String nombre, String casa, String fecha, String horario, String contacto) {
        this.nombre = new SimpleStringProperty(nombre);
        this.casa = new SimpleStringProperty(casa);
        this.fecha = new SimpleStringProperty(fecha);
        this.horario = new SimpleStringProperty(horario);
        this.contacto = new SimpleStringProperty(contacto);
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
}
