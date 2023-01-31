package GestionCooperativa;

import java.sql.Connection;
import java.sql.SQLException;
import BaseDatos.Conexion;
import GestionRutas.IngresoRutas;
import Utilitarios.Ingresos;
import Utilitarios.Restricciones;

public class IngresoCoperativas {
    Ingresos escaner = new Ingresos();
    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();
    String respuesta;
    Restricciones r = new Restricciones();
    IngresoRutas rutas = new IngresoRutas();

    public void MenuingresoCooperativa() {
        System.out.println("Ingrese el Nombre de la Cooperativa");
        String nombre = escaner.ingreso().next();
        System.out.println("Ingrese la Direccion de la Cooperativa");
        String direccion = escaner.ingreso().next();
        System.out.println("Ingrese el Email de la Cooperativa");
        String email = escaner.ingreso().next();
        System.out.println("Ingrese el Telefono de la Cooperativa");
        String telefono = escaner.ingreso().next();
        ingresoCooperativa(nombre, direccion, email, telefono);

    }

    public boolean ingresoCooperativa(String nombre, String direccion, String email, String telefono) {
        try {

            conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Nombre= '" + nombre + "' OR Direccion= '"
                    + direccion + "' OR Email= '" + email + "' OR Telefono= '" + telefono + "'"));
            conexion.setRs(conexion.getP().executeQuery());
            if (conexion.getRs().next()) {
                System.out.println("Uno de los datos ingresados ya existen\nPor favor ingrese una nueva Cooperativa");
                MenuingresoCooperativa();
            }

            conexion.setP(
                    c.prepareStatement("INSERT INTO Cooperativas (Nombre,Direccion,Email,Telefono) VALUES (?,?,?,?)"));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, direccion);
            conexion.getP().setString(3, email);
            conexion.getP().setString(4, telefono);
            conexion.getP().executeUpdate();
            c.close();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }

        return true;
    }

    public void MenuModificarCooperativa() {
        rutas.cooperativasId();
        System.out.println("Ingrese el Id de la Cooperativa a Cambiar");
        Integer id = escaner.ingreso().nextInt();
        System.out.println("Ingrese el Cambio de Nombre de la Cooperativa");
        String cnombre = escaner.ingreso().next();
        System.out.println("Ingrese el Cambio de Direccion de la Cooperativa");
        String cdireccion = escaner.ingreso().next();
        System.out.println("Ingrese el Cambio de Email de la Cooperativa");
        String cemail = escaner.ingreso().next();
        System.out.println("Ingrese el Cambio de Telefono de la Cooperativa");
        String ctelefono = escaner.ingreso().next();
        modificarCooperativa(cnombre, cdireccion, cemail, ctelefono, id);
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
            c.close();
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return true;
    }

    public void menueliminarCooperativa() {
        rutas.cooperativasId();
        System.out.println("Ingrese el Nombre de la Cooperativa a Eliminar");
        String nombre = escaner.ingreso().next();
        eliminarCooperativa(nombre);

    }

    public boolean eliminarCooperativa(String nombre) {

        try {
            conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Nombre= '" + nombre + "'"));
            conexion.setRs(conexion.getP().executeQuery());
            if (!conexion.getRs().next()) {
                System.out.println(
                        "La Cooperativa ingresada esta mal escrita o no existe\nPor favor ingrese una nueva Cooperativa");
                menueliminarCooperativa();
            }
            conexion.setP(c.prepareStatement("DELETE FROM Cooperativas WHERE Nombre = '" + nombre + "'"));
            conexion.getP().executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }
        return true;

    }

}