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


               /*  System.out.printf("%s %10s %10s %10s", "Cooperativa", "Origen", "Destino", "Horario\n"+
                "_________________________________________________________________________________________\n"+ 
                g.getRs().getNString("Cooperativa")+g.getRs().getNString("Origen")+g.getRs().getNString("Destino")+g.getRs().getNString("Horario"));
               */
              
                System.out.println("Cooperativa: " + g.getRs().getNString("Cooperativa"));
                System.out.println("_________________________________________________________________________________________");
                System.out.printf("Id\t\tRutaCooperativa\tOrigen\t\tDestino\t\tHorario\n"+
                "_________________________________________________________________________________________\n"+
                g.getRs().getString("Id_Rutas")+"\t\t"+g.getRs().getString("Cooperativa")+"\t\t"+g.getRs().getString("Origen")+"\t\t"+g.getRs().getString("Destino")+"\t\t"+g.getRs().getString("Horario")+"\n"); 
                /*System.out.println("Cooperativa: " + g.getRs().getNString("Cooperativa"));

                System.out.println("Origen: " + g.getRs().getNString("Origen"));
                System.out.println("Destino: " + g.getRs().getNString("Destino"));
                System.out.println("Horario: " + g.getRs().getNString("Horario"));
                */
            }

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
    }

}
