package GestionBoletos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BaseDatos.Conexion;
import GestionUsusarios.gestionUsuarios;

public class CompraBoleto {

    gestionUsuarios g = new gestionUsuarios();
    Conexion c = new Conexion();
    Connection co = c.getConexion();

    public void impresionRutas() {

        try {
            g.setInstrucciones("SELECT * FROM Rutas");
            g.setP(co.prepareStatement(g.getInstrucciones()));
            this.g.setRs(this.g.getP().executeQuery());
            while (g.getRs().next()) {
                System.out.println("_________________________________________________________________________________________");
                System.out.printf("Id\t\tRutaCooperativa\tOrigen\t\tDestino\t\tHorario\n"+
                "_________________________________________________________________________________________\n"+
                g.getRs().getString("Id_Rutas")+"\t\t"+g.getRs().getString("Cooperativa")+"\t\t"+g.getRs().getString("Origen")+"\t\t"+g.getRs().getString("Destino")+"\t\t"+g.getRs().getString("Horario")+"\n"); 
            }

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
    }

}
