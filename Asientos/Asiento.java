package Asientos;

public class Asiento {
    int idRuta;
    int numAsiento;
    boolean ocupado;
    public Asiento() {
    }
    public Asiento(int idRuta, int numAsiento, boolean ocupado) {
        this.idRuta = idRuta;
        this.numAsiento = numAsiento;
        this.ocupado = ocupado;
    }
    public int getIdRuta() {
        return idRuta;
    }
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
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
