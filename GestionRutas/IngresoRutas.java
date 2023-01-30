package GestionRutas;

import BaseDatos.Conexion;
import GestionUsusarios.gestionUsuarios;

import java.sql.Connection;
import java.sql.SQLException;

public class IngresoRutas {

    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();
    gestionUsuarios g = new gestionUsuarios();

    public boolean ingresoRuta(String cooperativa, String origen, String destino, String horario, Double precio) {

        try {

            conexion.setP(
                    c.prepareStatement("INSERT INTO Rutas (Cooperativa, Origen, Destino, Horario) VALUES (?,?,?,?)"));
            conexion.getP().setString(2, cooperativa);
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

    public void cooperativasId(int id){

        try {
            g.setInstrucciones("SELECT * FROM Rutas");
            g.setP(co.prepareStatement(g.getInstrucciones()));
            this.g.setRs(this.g.getP().executeQuery());
            System.out.printf("Id\tCooperativa\tOrigen\t\tDestino\t\tHorario\t\tPrecio\n");
            while (g.getRs().next()) {
                System.out.printf(
                        "_________________________________________________________________________________________\n" +
                                g.getRs().getString("Id_Rutas") + "\t" + g.getRs().getString("Cooperativa") + "\t\t"
                                + g.getRs().getString("Origen") + "\t\t" + g.getRs().getString("Destino") + "\t\t"
                                + g.getRs().getString("Horario") +g.getRs().getString("Precio") +"\n");
            }

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }

    }

    public boolean modificarRuta(String nombre, String origen, String destino, String horario, int id) {

        try {
            conexion.setP(c.prepareStatement("UPDATE Rutas SET Cooperativa = ? , Origen = ? , Destino = ?, Horario = ? WHERE Id_Rutas = " + id));
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

    public boolean deleteRuta(int id_Rutas){

        try {
            conexion.setP(c.prepareStatement( "DELETE FROM Rutas WHERE Id_Rutas = '" + id_Rutas+"'"));
            conexion.getP().executeUpdate();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }

        return true;
    }
}
