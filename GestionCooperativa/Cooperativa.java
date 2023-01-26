package GestionCooperativa;

import java.util.ArrayList;


import Utilitarios.Ingresos;
public class Cooperativa {

    private String nombre;
    private String telefono;
    private String direccion;
    Ingresos escaner = new Ingresos();

    public Cooperativa(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
