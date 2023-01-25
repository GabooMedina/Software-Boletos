package GestionCooperativa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import BaseDatos.Conexion;
import Utilitarios.Ingresos;
import Utilitarios.ListaCooperativas;

public class IngresoCoperativas {
    Ingresos escaner = new Ingresos();
    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();

    public boolean ingresoCooperativa(String nombre, String direccion, String email, String telefono) {
        try {

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