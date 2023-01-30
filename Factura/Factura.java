package Factura;

import java.sql.Date;

public class Factura {
    int idUsuario;
    int id;
    String coopertiva;
    String origen;
    String destino;
    String horario;
    Double precio;
    int asiento;
    Date fecha;

    public Factura() {
    }
    public boolean ImpresionFactura(){
        
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


    public String getCoopertiva() {
        return coopertiva;
    }


    public void setCoopertiva(String coopertiva) {
        this.coopertiva = coopertiva;
    }


    public String getOrigen() {
        return origen;
    }


    public void setOrigen(String origen) {
        this.origen = origen;
    }


    public String getDestino() {
        return destino;
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }


    public String getHorario() {
        return horario;
    }


    public void setHorario(String horario) {
        this.horario = horario;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public int getAsiento() {
        return asiento;
    }


    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean ImpresionFactura(String cooperativa, String origen, String destino, String horario, Double precio){
        return true;
    }
    
}
