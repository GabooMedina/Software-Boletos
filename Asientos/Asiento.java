package Asientos;

public class Asiento {
    int idCooperativa;
    int numAsiento;
    boolean ocupado;
    public Asiento() {
    }
    public Asiento(int idCooperativa, int numAsiento, boolean ocupado) {
        this.idCooperativa = idCooperativa;
        this.numAsiento = numAsiento;
        this.ocupado = ocupado;
    }
    public int getIdCooperativa() {
        return idCooperativa;
    }
    public void setIdCooperativa(int idCooperativa) {
        this.idCooperativa = idCooperativa;
    }
    public int getNumAsiento() {
        return numAsiento;
    }
    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }
    public boolean isOcupado() {
        return ocupado;
    }
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
}
