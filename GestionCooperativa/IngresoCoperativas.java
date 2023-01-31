package GestionCooperativa;

import java.sql.Connection;
import java.sql.SQLException;
import BaseDatos.Conexion;
import Utilitarios.Ingresos;
public class IngresoCoperativas {
    Ingresos escaner = new Ingresos();
    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();

    public void MenuingresoCooperativa(){
        do {
            System.out.println("Ingrese el Nombre de la Cooperativa");
            String nombre = escaner.ingreso().next();
            System.out.println("Ingrese la Direccion de la Cooperativa");
            String direccion = escaner.ingreso().next();
            System.out.println("Ingrese el Email de la Cooperativa");
            String email = escaner.ingreso().next();
            System.out.println("Ingrese el Telefono de la Cooperativa");
            String telefono = escaner.ingreso().next();
            i.ingresoCooperativa(nombre, direccion, email, telefono);
            System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
            respuesta = escaner.ingreso().next().toUpperCase();
        } while (respuesta.equas("SI"));
    } 

    public boolean ingresoCooperativa(String nombre, String direccion, String email, String telefono) {
        try {

            conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Nombre= '"+nombre+"'"));
            conexion.setRs(conexion.getP().executeQuery());
            if(conexion.getRs().next()){
                System.out.println("La Cooperativa ingresada ya existe\nPor favor ingrese una nueva Cooperativa");
                MenuingresoCooperativa();
            }

            conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Direccion= '"+direccion+"'"));
            conexion.setRs(conexion.getP().executeQuery());
            if(conexion.getRs().next()){
                System.out.println("La direccion ingresada ya existe\nPor favor ingrese una nueva direccion");
                MenuingresoCooperativa();
            }

            conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Email= '"+email+"'"));
            conexion.setRs(conexion.getP().executeQuery());
            if(conexion.getRs().next()){
                System.out.println("el email ingresado ya existe\nPor favor ingrese un nuevo correo");
                MenuingresoCooperativa();
            }

            conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Telefono= '"+telefono+"'"));
            conexion.setRs(conexion.getP().executeQuery());
            if(conexion.getRs().next()){
                System.out.println("el telefono ingresado ya existe\nPor favor ingrese un nuevo telefono");
                MenuingresoCooperativa();
            }
            
            conexion.setP(
                    c.prepareStatement("INSERT INTO Cooperativas (Nombre,Direccion,Email,Telefono) VALUES (?,?,?,?)"));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, direccion);
            conexion.getP().setString(3, email);
            conexion.getP().setString(4, telefono);
            conexion.getP().executeUpdate();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }

        return true;
    }

    public boolean modificarCooperativa(String nombre, String direccion, String email, String telefono, int id) {

        try {
            conexion.setP(c.prepareStatement(
                    "UPDATE Cooperativas SET Nombre = ? , Direccion = ? , Email = ?, Telefono = ? WHERE Id = " + id));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, direccion);
            conexion.getP().setString(3, email);
            conexion.getP().setString(4, telefono);
            conexion.getP().executeUpdate();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return true;
    }

    public boolean eliminarCooperativa(String nombre) {

        try {
            conexion.setP(c.prepareStatement( "DELETE FROM Cooperativas WHERE Nombre = '" + nombre+"'"));
            conexion.getP().executeUpdate();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }
        
        return true;
    }

}