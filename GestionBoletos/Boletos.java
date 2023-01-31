package GestionBoletos;

import java.sql.Date;

public class Boletos {
    
    private String cooperativa, origen, destino,horario;
    private double precio;
    private String fecha;
    
    public Boletos(){
        
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    public String getCooperativa() {
        return cooperativa;
    }


    public void setCooperativa(String cooperativa) {
        this.cooperativa = cooperativa;
    }


    public String getDestino() {
        return destino;
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }
    
   
}
