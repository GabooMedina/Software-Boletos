package Factura;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Asientos.Asiento;
import BaseDatos.Conexion;
import GestionBoletos.Boletos;
import GestionUsusarios.Usuario;
import Menus.Menus;
import Utilitarios.Restricciones;

public class Factura {
    int idUsuario;
    int id;
    String fecha;
    int asiento;

    Menus men = new Menus();
    Conexion c = new Conexion();
    PreparedStatement p;
    String instrucciones;
    ResultSet rs;

    public Conexion getC() {
        return c;
    }

    public void setC(Conexion c) {
        this.c = c;
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

    public Factura() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public boolean ImpresionFactura(Usuario u, Asiento a, Boletos b, Factura f) {
        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement(
                    "INSERT INTO RegistroCompra (idUsuario,Nombre,Apellido,Cooperativa,Origen,Destino,Horario,Precio,Asiento,Fecha) VALUES (?,?,?,?,?,?,?,?,?,?)"));
            this.getP().setInt(1, u.getId());
            this.getP().setString(2, u.getNombre());
            this.getP().setString(3, u.getApellido());
            this.getP().setString(4, b.getCooperativa());
            this.getP().setString(5, b.getOrigen());
            this.getP().setString(6, b.getDestino());
            this.getP().setString(7, b.getHorario());
            this.getP().setDouble(8, b.getPrecio());
            this.getP().setInt(9, a.getNumAsiento());
            this.getP().setString(10, b.getFecha());
            this.getP().executeUpdate();
            f.setIdUsuario(u.getId());
            f.setAsiento(a.getNumAsiento());
            f.setFecha(b.getFecha());
            inscomp(u, a, b, f);
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return false;
    }

    public void inscomp(Usuario u, Asiento a, Boletos b, Factura f) {
        System.out.println(f.fecha);

        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement("SELECT * FROM RegistroCompra Where idUsuario= '" + f.idUsuario
                    + "' AND Asiento= '" + f.asiento + "' AND Fecha= '" + f.fecha + "'"));
            this.setRs(this.getP().executeQuery());
            if (this.rs.next()) {
                f.setId(this.rs.getInt("Id_compra"));
                men.MenuUsuario(u, a, b, f);
            }
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
    }

    public void CancelarCompra(Usuario u, Asiento a, Boletos b, Factura f) {
        Restricciones r = new Restricciones();
        Scanner coso = new Scanner(System.in);
        String op;
        System.out.println("Desea eliminar la compra actual?");
        System.out.println("1.- Si\n2.- No");
        System.out.println("Seleccione una de las opciones");
        op = coso.next();
        if (r.controlNum(op)) {
            if (op.equals("1")) {
                Connection co = c.getConexion();
                try {
                    this.setP(co.prepareStatement("DELETE * FROM RegistroCompra Where idUsuario= '" + f.getIdUsuario()
                            + "' AND Asiento= '" + f.getAsiento() + "' AND Fecha= '" + f.getFecha() + "'"));
                    this.setRs(this.getP().executeQuery());
                    men.MenuUsuario(u, a, b, f);
                } catch (SQLException e) {
                    System.out.println(" === ERROR DE INGRESO EN BD ===");
                }
            } else if (op.equals("2")) {
                System.out.println("Saliendo de la opcion");
                men.MenuUsuario(u, a, b, f);
            } else {
                System.out
                        .println("El valor ingresado sobrepasa las opciones existentes\nPor favor vulva a ingresarlo");
                CancelarCompra(u, a, b, f);
            }
        } else {
            System.out.println("Debe ingresar un valor númerico\nPor favor vulva a ingresarlo");
            CancelarCompra(u, a, b, f);
        }
    }

    public void imprimirHistorialCompras(Usuario u, Asiento a, Boletos b, Factura f) {
        Connection co = c.getConexion();

        try {
            this.setP(co.prepareStatement("SELECT * FROM RegistroCompra Where idUsuario= '" + f.idUsuario + "'"));
            this.setRs(this.getP().executeQuery());
            System.out.printf(
                    "Nombre\t\tApellido\t\tCooperativa\t\tOrigen\t\tDestino\t\tHorario\t\tPrecio\t\tAsiento\t\tFecha\n");
            while (this.getRs().next()) {
                System.out.printf(
                        "_________________________________________________________________________________________\n"
                                + this.getRs().getString("Nombre") + "\t\t" + this.getRs().getString("Apellido")
                                + "\t\t" + this.getRs().getString("Cooperativa") + "\t\t"
                                + this.getRs().getString("Origen") + "\t\t" + this.getRs().getString("Destino") + "\t\t"
                                + this.getRs().getString("Horario") + "\t\t" + this.getRs().getString("Precio") + "\t\t"
                                + this.getRs().getString("Asiento") + "\t\t" + this.getRs().getString("Fecha"));
            }
        } catch (Exception e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
    }

}
