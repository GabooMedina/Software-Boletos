package GestionCooperativa;

import java.sql.Connection;
import java.util.ArrayList;

import BaseDatos.Conexion;
import Utilitarios.Ingresos;
import Utilitarios.ListaCooperativas;

public class IngresoCoperativas {
    Ingresos escaner = new Ingresos();
    Conexion conexion =new Conexion();
    Connection c =conexion.getConexion();
    
    public boolean ingresoCooperativa(String nombre, String telefono, String direccion){ 
        try {
            
            conexion.setP(c.prepareStatement("INSERT INTO Cooperativas (nombre,telefono,direccion) VALUES (?,?,?)"));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, telefono);
            conexion.getP().setString(3, direccion);
            conexion.getP().executeUpdate();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }

        return true;
    }

    public boolean modificarCooperativa(String nombre, String telefono, String direccion){

        try {
            
            conexion.setP(c.prepareStatement("UPDATE Cooperativas  SET nombre = ? , telefono = ? , direccion = ? WHERE datospersonales.cedula=?"));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, telefono);
            conexion.getP().setString(3, direccion);
            conexion.getP().executeUpdate();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }



        return true;
    }

    public boolean eliminarCooperativa(){


        return true;
    }

}