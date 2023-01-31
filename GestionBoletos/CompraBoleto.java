package GestionBoletos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import Asientos.Asiento;
import Asientos.gestionAsiento;
import BaseDatos.Conexion;
import Factura.Factura;
import GestionUsusarios.Usuario;
import GestionUsusarios.gestionUsuarios;
import Utilitarios.Ingresos;

public class CompraBoleto {
    Ingresos i = new Ingresos();
    gestionUsuarios g = new gestionUsuarios();
    Conexion c = new Conexion();
    Connection co = c.getConexion();
    gestionAsiento a = new gestionAsiento();
    Date fecha=new Date();
    Calendar fe;
    
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

    public boolean compraTicket(Usuario u, Asiento as, Boletos b,Factura f) {

        try {
            impresionRutas();
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
                b.setFecha(String.valueOf(fecha.getDate())+"/"+String.valueOf(fecha.getMonth()+1)+"/"+String.valueOf(fecha.getYear()+1900));
                a.menuAsientoEscogido(g.getRs().getInt("Id_rutas"),as);
                f.ImpresionFactura(u, as, b, f);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;

    }

}
