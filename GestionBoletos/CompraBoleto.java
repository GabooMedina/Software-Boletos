package GestionBoletos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void impresionRutas() {

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

    public boolean compraTicket() {

        try {

            System.out.print("Ingrese el Id de la Frecuencia en la que Desee Viajar: ");
            Integer frecuencia = i.ingreso().nextInt();

            g.setInstrucciones("SELECT * FROM Rutas WHERE Id_Rutas = '" + frecuencia+"'");
            g.setP(co.prepareStatement(g.getInstrucciones()));
            g.setRs(g.getP().executeQuery());
            if(g.getRs().next()){
               String cooperativa = g.getRs().getString("Cooperativa");
               String origen = g.getRs().getString("Origen");
               String destino = g.getRs().getString("Destino");
               String horario = g.getRs().getString("Horario");
               Double precio =  g.getRs().getDouble("Precio");
                return f.ImpresionFactura(cooperativa, origen, destino, horario, precio);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;

    }

}
