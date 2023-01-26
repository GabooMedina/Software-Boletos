package GestionRutas;

import BaseDatos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class IngresoRutas {

    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();

    public boolean ingresoRuta(String cooperativa, String origen, String destino, String horario) {

        try {

            conexion.setP(
                    c.prepareStatement("INSERT INTO Rutas (Cooperativa, Origen, Destino, Horario) VALUES (?,?,?,?)"));
            conexion.getP().setString(1, cooperativa);
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
