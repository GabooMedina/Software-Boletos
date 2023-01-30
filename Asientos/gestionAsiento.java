package Asientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BaseDatos.Conexion;

public class gestionAsiento {
    Conexion c=new Conexion();
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

    public boolean generarAsientos(int idRuta){
        Connection co=c.getConexion();
        for(int i=1;i<=35;i++){

        }
        return true;
    }
}
