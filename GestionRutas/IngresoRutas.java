package GestionRutas;

import BaseDatos.Conexion;
import GestionCooperativa.Cooperativa;
import GestionUsusarios.gestionUsuarios;
import Utilitarios.Ingresos;


import java.sql.Connection;
import java.sql.SQLException;

public class IngresoRutas {
    Ingresos escaner = new Ingresos();
    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();
    gestionUsuarios g = new gestionUsuarios();
    Ingresos i = new Ingresos();
    Cooperativa cop;
    String respuesta;

    public void menuRutas(){
        
    }
    
    public boolean ingresoRuta(int id, String nombre, String origen, String destino, String horario, Double precio) {

        try {

            conexion.setP(
                    c.prepareStatement(
                            "INSERT INTO Rutas (idCooperativa, Cooperativa, Origen, Destino, Horario, Precio) VALUES (?,?,?,?,?,?)"));
            conexion.getP().setInt(1, id);
            conexion.getP().setString(2, nombre);
            conexion.getP().setString(3, origen);
            conexion.getP().setString(4, destino);
            conexion.getP().setString(5, horario);
            conexion.getP().setDouble(6, precio);
            conexion.getP().executeUpdate();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }

        return true;
    }

    public boolean cooperativasId() {

        try {
            g.setInstrucciones("SELECT * FROM Cooperativas");
            g.setP(c.prepareStatement(g.getInstrucciones()));
            this.g.setRs(this.g.getP().executeQuery());
            System.out.printf("Id\tCooperativa\t\n");
            while (g.getRs().next()) {
                System.out.println("___________________________________________");
                System.out.printf(g.getRs().getInt("Id") + "\t" + g.getRs().getString("Nombre") + "\n");
            }

            System.out.print("Ingrese el Id de la Cooperativa: ");
            String id = i.ingreso().next();

            g.setInstrucciones("SELECT * FROM Cooperativas WHERE Id = '" + id + "'");
            g.setP(c.prepareStatement(g.getInstrucciones()));
            g.setRs(g.getP().executeQuery());
            if (g.getRs().next()) {
                return MenucrearRuta(g.getRs().getInt("Id"), g.getRs().getString("Nombre"));
            }

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }

        return false;

    }

    public boolean modificarRuta(String nombre, String origen, String destino, String horario, int id) {

        try {
            conexion.setP(c.prepareStatement(
                    "UPDATE Rutas SET Cooperativa = ? , Origen = ? , Destino = ?, Horario = ? WHERE Id_Rutas = " + id));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, origen);
            conexion.getP().setString(3, destino);
            conexion.getP().setString(4, horario);
            conexion.getP().executeUpdate();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());

        }

        return true;
    }

    public boolean deleteRuta(int id_Rutas) {

        try {
            conexion.setP(c.prepareStatement("DELETE FROM Rutas WHERE Id_Rutas = '" + id_Rutas + "'"));
            conexion.getP().executeUpdate();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }

        return true;
    }

    public boolean MenucrearRuta(int id, String nombre) {
            System.out.println("Ingrese el Origen de la Nueva Ruta");
            String origen = escaner.ingreso().next();
            System.out.println("Ingrese el Destino para la Nueva Ruta");
            String destino = escaner.ingreso().next();
            System.out.println("Ingrese el Horario para la Nueva Ruta");
            String horario = escaner.ingreso().next();
            System.out.println("Ingrese el Precio para la Nueva Ruta");
            Double precio = escaner.ingreso().nextDouble();
             return ingresoRuta(id, nombre, origen, destino, horario, precio);
            
             
    }

}
