package com.example.frontendcommunityapp.Model.Services;
import com.example.frontendcommunityapp.Controller.DbConnection;

public class RegistroMascotas extends Services {

    private String nombreMascota;
    private String raza;
    private int idCasaApto; // ID del residente
    private boolean perdido;

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public int getIdCasaApto() {
        return idCasaApto;
    }

    public boolean isPerdido() {
        return perdido;
    }

    public RegistroMascotas(String nombreMascota, String raza, int idCasaApto, boolean perdido) {
        super(0, "RegistroMascotas"); // Llama al constructor de la clase Services
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.idCasaApto = idCasaApto;
        this.perdido = perdido;
    }

    public void registrarMascota() {
        String query = "INSERT INTO mascotas(nombre, tipo_animal, id_usuario, perdido) VALUES ('"
                + this.nombreMascota + "', '"
                + this.raza + "', "
                + this.idCasaApto + ", "
                + (this.perdido ? 1 : 0) + ")";

        DbConnection connection = new DbConnection();
        try {
            int result = connection.updateDataBase(query);
            if (result > 0) {
                System.out.println("RegistroMascotas registrada exitosamente.");
            } else {
                System.out.println("Error al registrar la registroMascotas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrarMascotaDB(RegistroMascotas mascotaRegistrada){
        String query = "INSERT INTO mascotas(nombre, tipo_animal, id_usuario, perdido) VALUES ('"
                + mascotaRegistrada.getNombreMascota() + "', '"
                + mascotaRegistrada.getRaza() + "', "
                + mascotaRegistrada.getIdCasaApto() + ", "
                + mascotaRegistrada.isPerdido() + ")";

        DbConnection connection = new DbConnection();
        try {
            int result = connection.updateDataBase(query);
            if (result > 0) {
                System.out.println("RegistroMascotas registrada exitosamente.");
            } else {
                System.out.println("Error al registrar la registroMascotas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        RegistroMascotas pet1 = new RegistroMascotas("tin", "Labrador", 123, false);
        pet1.registrarMascotaDB(pet1);
    }
}
