package Asientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import BaseDatos.Conexion;
import Utilitarios.Ingresos;
import Utilitarios.Restricciones;

public class gestionAsiento {
    Asiento as = new Asiento();
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

    public boolean generarAsientos(int idRuta) {
        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement("INSERT INTO Asientos (idRuta,numAsiento,ocupado) VALUES (?,?,?)"));
            for (int i = 1; i <= 35; i++) {
                this.getP().setInt(1, idRuta);
                this.getP().setInt(2, i);
                this.getP().setBoolean(3, false);
                this.getP().executeUpdate();
            }
            co.close();
            return true;
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }
        return true;
    }

    public boolean menuAsientoEscogido(int idRuta, Asiento as) {
        Restricciones r = new Restricciones();
        Scanner coso = new Scanner(System.in);
        String num;
        Connection co = c.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Asientos WHERE idRuta= '" + idRuta + "'");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            System.out.println("\nN°\t\tEstado");
            while (this.rs.next()) {
                System.out.println(
                        "_________________________________________________________________________________________");
                System.out.printf(this.rs.getInt("numAsiento") + "\t\t");
                if (this.rs.getInt("ocupado") == 0) {
                    System.out.printf("Disponible\n");
                } else {
                    System.out.printf("Ocupado\n");
                }
            }
            System.out.println("Seleccione el Asiento que desea ocupar");
            num = coso.next();
            if (!r.controlNumAsiento(num)) {
                System.out.println("Solo debe ingresar valores númericos");
                return menuAsientoEscogido(idRuta, as);
            }
            co.close();
            return asientoEscogido(idRuta, Integer.parseInt(num), as);
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return false;
    }

    public boolean asientoEscogido(int idRuta, int numAsiento, Asiento as) {
        Connection co = c.getConexion();
        try {
            this.setInstrucciones(
                    "SELECT * FROM Asientos WHERE idRuta= '" + idRuta + "'" + "AND numAsiento= '" + numAsiento + "'");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            if (this.rs.next()) {
                if (this.rs.getInt("ocupado") == 1) {
                    System.out.println(
                            "\nEl Asiento Seleccionado ya esta Ocupado\nPor favor ingrese un Asiento Disponible");
                    return menuAsientoEscogido(idRuta, as);
                }
                this.setInstrucciones("UPDATE Asientos SET ocupado=? WHERE idRuta= '" + idRuta + "'"
                        + "AND numAsiento= '" + numAsiento + "'");
                setP(co.prepareStatement(this.getInstrucciones()));
                this.getP().setBoolean(1, true);
                this.getP().executeUpdate();
                as.setIdRuta(idRuta);
                as.setNumAsiento(numAsiento);
                as.setOcupado(true);
                co.close();
                return true;
            } else {
                System.out.println("El Asiento seleccionado no existe\nPor favor ingrese un valor valido");
                return menuAsientoEscogido(idRuta, as);
            }
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return false;
    }

    public boolean limpiarAsientos(String idRuta) {
        
        Connection co = c.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Asientos WHERE idRuta= '" + idRuta + "'");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            if (this.rs.next()) {
                this.setInstrucciones("UPDATE Asientos SET ocupado=? WHERE idRuta= '" + idRuta + "'");
                setP(co.prepareStatement(this.getInstrucciones()));
                this.getP().setBoolean(1, false);
                this.getP().executeUpdate();
                co.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("La opcion escogida no se encuentra dentro de las opciones Valida");
            System.out.println("Por favor ingrese una opcion valida");
            menuReseteoAsientos();
        }
        return false;
    }

    public void menuReseteoAsientos() {
        Restricciones r = new Restricciones();
        Ingresos escaner = new Ingresos();
        String id;
        do {
            impresionRutasadmin();
            System.out.println("Ingrese el Id de la Ruta para limpiar los asientos : ");
            id = escaner.ingreso().next();
            if(!r.controlNum(id)){
                System.out.println("La opcion Ingresada debe de ser de tipo numerico");
                System.out.println("Porfavor ingrese una opcion valida");
            }
        } while (!r.controlNum(id));
        limpiarAsientos(id);
        
    }

    public void impresionRutasadmin() {
        Connection co = c.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Rutas");
            this.setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            System.out.printf("Id\tCooperativa\tOrigen\t\tDestino\t\tHorario\t\t\n");
            while (this.rs.next()) {
                System.out.printf(
                        "_________________________________________________________________________________________\n" +
                                this.rs.getString("Id_Rutas") + "\t" + this.rs.getString("Cooperativa") + "\t"
                                + this.rs.getString("Origen") + "\t\t" + this.rs.getString("Destino") + "\t\t"
                                + this.rs.getString("Horario") + "\t\t" + "\n");
            }
            co.close();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e);
        }

    }

}
