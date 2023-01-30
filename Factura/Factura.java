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

    
    public boolean ImpresionFactura(String cooperativa, String origen, String destino, String horario, Double precio){
        System.out.println(cooperativa+origen+destino+horario);
        return true;
    }
    
}
