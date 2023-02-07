package GestionCooperativa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BaseDatos.Conexion;
import GestionRutas.IngresoRutas;
import Utilitarios.Ingresos;
import Utilitarios.Restricciones;

public class IngresoCoperativas {
    Conexion conexion = new Conexion();
    PreparedStatement p;
    String instrucciones;
    ResultSet rs;

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement getP() {
        return p;
    }

    public void setP(PreparedStatement p) {
        this.p = p;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void MenuingresoCooperativa() {
        Restricciones r = new Restricciones();
        Ingresos escaner = new Ingresos();
        
        String email;
        String telefono;
        System.out.println("Ingrese el Nombre de la Cooperativa");
        String nombre = escaner.ingreso().next();
        System.out.println("Ingrese la Direccion de la Cooperativa");
        String direccion = escaner.ingreso().next();
        do {
            System.out.println("Ingrese el Email de la Cooperativa");
            email = escaner.ingreso().next();
            if (!r.controlCorreo(email)) {
                System.out.println("Por favor ingrese un correo válido\nEjemplo: example@domain.com");
            }
        } while (!r.controlCorreo(email));
        do {
            System.out.println("Ingrese el Telefono de la Cooperativa");
            telefono = escaner.ingreso().next();
            if (!r.controlNumeroTelefono(telefono)) {
                System.out.println("Por favor ingrese un número de telefono válido\nEjemplo: 0987654321");
            }
        } while (!r.controlNumeroTelefono(telefono));

        ingresoCooperativa(nombre, direccion, email, telefono);

    }

    public boolean ingresoCooperativa(String nombre, String direccion, String email, String telefono) {
        Connection c = conexion.getConexion();
        try {

            this.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Nombre= '" + nombre + "' OR Email= '" + email + "' OR Telefono= '" + telefono + "'"));
            this.setRs(this.getP().executeQuery());
            if (this.rs.next()) {
                System.out.println("Uno de los datos ingresados ya existen\nPor favor ingrese una nueva Cooperativa");
                MenuingresoCooperativa();
            }

            this.setP(
                    c.prepareStatement("INSERT INTO Cooperativas (Nombre,Direccion,Email,Telefono) VALUES (?,?,?,?)"));
            this.getP().setString(1, nombre);
            this.getP().setString(2, direccion);
            this.getP().setString(3, email);
            this.getP().setString(4, telefono);
            this.getP().executeUpdate();
            c.close();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }

        return true;
    }

    public void MenuModificarCooperativa() {
        Restricciones r = new Restricciones();
        Ingresos escaner = new Ingresos();
        IngresoRutas rutas = new IngresoRutas();
        String id;
        String cemail;
        String ctelefono;
        rutas.cooperativasId();
        do {
            System.out.println("Ingrese el Id de la Cooperativa a Cambiar");
            id = escaner.ingreso().next();
            if (!r.controlNum(id)) {
                System.out.println("Solo se Aceptan valores númericos\nPor favor vuelvalo a ingresar");
            }
        } while (!r.controlNum(id));
        System.out.println("Ingrese el Cambio de Nombre de la Cooperativa");
        String cnombre = escaner.ingreso().next();
        System.out.println("Ingrese el Cambio de Direccion de la Cooperativa");
        String cdireccion = escaner.ingreso().next();
        do {
            System.out.println("Ingrese el Cambio de Email de la Cooperativa");
            cemail = escaner.ingreso().next();
            if (!r.controlCorreo(cemail)) {
                System.out.println("Por favor ingrese un correo válido\nEjemplo: example@domain.com");
            }
        } while (!r.controlCorreo(cemail));
        do {
            System.out.println("Ingrese el Cambio de Telefono de la Cooperativa");
            ctelefono = escaner.ingreso().next();
            if (!r.controlNumeroTelefono(ctelefono)) {
                System.out.println("Por favor ingrese un número de telefono válido\nEjemplo: 0987654321");
            }
        } while (!r.controlNumeroTelefono(ctelefono));
        modificarCooperativa(cnombre, cdireccion, cemail, ctelefono, Integer.parseInt(id));
    }

    public boolean modificarCooperativa(String nombre, String direccion, String email, String telefono, int id) {
        Connection c = conexion.getConexion();
        try {
            this.setP(c.prepareStatement(
                    "UPDATE Cooperativas SET Nombre = ? , Direccion = ? , Email = ?, Telefono = ? WHERE Id = " + id));
            this.getP().setString(1, nombre);
            this.getP().setString(2, direccion);
            this.getP().setString(3, email);
            this.getP().setString(4, telefono);
            this.getP().executeUpdate();
            c.close();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return true;
    }

    public void menueliminarCooperativa() {
        Ingresos escaner = new Ingresos();
        IngresoRutas rutas = new IngresoRutas();
        rutas.cooperativasId();
        System.out.println("Ingrese el Nombre de la Cooperativa a Eliminar");
        String nombre = escaner.ingreso().next();
        eliminarCooperativa(nombre);

    }

    public boolean eliminarCooperativa(String nombre) {
        Connection c = conexion.getConexion();
        try {
            this.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Nombre= '" + nombre + "'"));
            this.setRs(this.getP().executeQuery());
            if (!this.rs.next()) {
                System.out.println(
                        "La Cooperativa ingresada esta mal escrita o no existe\nPor favor ingrese una nueva Cooperativa");
                menueliminarCooperativa();
            }
            this.setP(c.prepareStatement("DELETE FROM Cooperativas WHERE Nombre = '" + nombre + "'"));
            this.getP().executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }
        return true;

    }

}