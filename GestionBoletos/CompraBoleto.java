package GestionBoletos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Asientos.gestionAsiento;
import BaseDatos.Conexion;
import Factura.Factura;
import GestionUsusarios.gestionUsuarios;
import Utilitarios.Ingresos;

public class CompraBoleto {
    Ingresos i = new Ingresos();
    gestionUsuarios g = new gestionUsuarios();
    Conexion c = new Conexion();
    Connection co = c.getConexion();
    Factura f = new Factura();
    Boletos b = new Boletos();
    gestionAsiento a = new gestionAsiento();
    

    public void impresionRutas() {

        try {
            g.setInstrucciones("SELECT * FROM Rutas");
            g.setP(co.prepareStatement(g.getInstrucciones()));
            this.g.setRs(this.g.getP().executeQuery());
            System.out.printf("Id\tCooperativa\tOrigen\t\tDestino\t\tHorario\t\tPrecio\n");
            while (g.getRs().next()) {
                System.out.printf(
                        "_________________________________________________________________________________________\n" +
                                g.getRs().getString("Id_Rutas") + "\t" + g.getRs().getString("Cooperativa") + "\t"
                                + g.getRs().getString("Origen") + "\t\t" + g.getRs().getString("Destino") + "\t\t"
                                + g.getRs().getString("Horario")+"\t\t"+ g.getRs().getString("Precio")+"\t\t" +"\n");
            }

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
    }

    public boolean compraTicket() {

        try {

            System.out.print("Ingrese el Id de la Frecuencia en la que Desee Viajar: ");
            Integer frecuencia = i.ingreso().nextInt();

            g.setInstrucciones("SELECT * FROM Rutas WHERE Id_Rutas = '" + frecuencia+"'");
            g.setP(co.prepareStatement(g.getInstrucciones()));
            g.setRs(g.getP().executeQuery());
            if(g.getRs().next()){
              
                b.setCooperativa(g.getRs().getString("Cooperativa"));
                b.setOrigen( g.getRs().getString("Origen"));
                b.setDestino(g.getRs().getString("Destino"));
                b.setHorario(g.getRs().getString("Horario"));
                b.setPrecio(g.getRs().getDouble("Precio"));
                a.menuAsientoEscogido(g.getRs().getInt("Id_rutas"));

                return f.ImpresionFactura();

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;

    }

}
