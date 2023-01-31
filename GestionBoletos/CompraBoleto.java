package GestionBoletos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Asientos.Asiento;
import Asientos.gestionAsiento;
import BaseDatos.Conexion;
import Factura.Factura;
import GestionUsusarios.Usuario;
import Utilitarios.Ingresos;

public class CompraBoleto {
    Date fecha = new Date();

    Conexion conexion = new Conexion();
    PreparedStatement p;
    String instrucciones;
    ResultSet rs;

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement getP() {
        return p;
    }

    public void setP(PreparedStatement p) {
        this.p = p;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void impresionRutas() {
        Connection co = conexion.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Rutas");
            this.setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            System.out.printf("Id\tCooperativa\tOrigen\t\tDestino\t\tHorario\t\tPrecio\n");
            while (this.rs.next()) {
                System.out.printf(
                        "_________________________________________________________________________________________\n" +
                                this.rs.getString("Id_Rutas") + "\t" + this.rs.getString("Cooperativa") + "\t"
                                + this.rs.getString("Origen") + "\t\t" + this.rs.getString("Destino") + "\t\t"
                                + this.rs.getString("Horario") + "\t\t" + this.rs.getString("Precio") + "\t\t" + "\n");
            }
            co.close();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
    }

    public boolean compraTicket(Usuario u, Asiento as, Boletos b, Factura f) {
        Ingresos i = new Ingresos();
        gestionAsiento a = new gestionAsiento();
        Connection co = conexion.getConexion();
        try {
            impresionRutas();
            System.out.print("Ingrese el Id de la Frecuencia en la que Desee Viajar: ");
            Integer frecuencia = i.ingreso().nextInt();

            this.setInstrucciones("SELECT * FROM Rutas WHERE Id_Rutas = '" + frecuencia + "'");
            this.setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            if (this.rs.next()) {

                b.setCooperativa(this.rs.getString("Cooperativa"));
                b.setOrigen(this.rs.getString("Origen"));
                b.setDestino(this.rs.getString("Destino"));
                b.setHorario(this.rs.getString("Horario"));
                b.setPrecio(this.rs.getDouble("Precio"));
                b.setFecha(String.valueOf(fecha.getDate()) + "/" + String.valueOf(fecha.getMonth() + 1) + "/"
                        + String.valueOf(fecha.getYear() + 1900));
                a.menuAsientoEscogido(this.rs.getInt("Id_rutas"), as);
                co.close();
                f.ImpresionFactura(u, as, b, f);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;

    }

}
