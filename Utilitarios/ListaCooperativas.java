package Utilitarios;

import java.util.ArrayList;

import GestionCooperativa.Cooperativa;

public class ListaCooperativas {
    private ArrayList<Cooperativa> cooperativas = new ArrayList();

    public ArrayList<Cooperativa> getCooperativas() {
        return this.cooperativas;
    }

    public void setCooperativas(Cooperativa c) {
        this.cooperativas.add(c);
    }

}

