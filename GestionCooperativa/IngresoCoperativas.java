package GestionCooperativa;

import java.util.ArrayList;

import Utilitarios.Ingresos;
import Utilitarios.ListaCooperativas;

public class IngresoCoperativas {
    Ingresos escaner = new Ingresos();
    ListaCooperativas lista = new ListaCooperativas();

    private String respuesta;

    public  <ArrayList> ListaCooperativas creacinCooperativa() {

        do {
        System.out.println("Ingrese el Nombre de la Cooperativa");
        String nombre = escaner.ingreso().next();
        System.out.println("Ingrese el Telefono de la Cooperativa");
        String telefono = escaner.ingreso().next();
        System.out.println("Ingrese la Direccion de la Cooperativa");
        String direccion = escaner.ingreso().next();
        Cooperativa c = new Cooperativa(nombre,telefono,direccion);
        lista.setCooperativas(c);
        
        
        System.out.println("=== Desea Ingresar una Nueva Cooperativa? ===");
        respuesta = escaner.ingreso().next().toUpperCase();
    } while (respuesta.equals("SI"));

    return lista;
    }

    public void impresionLista(){

        System.out.println("=== IMPRESION LISTA DE NUEVAS COOPERATIVAS ===");
        for (int i = 0; i < lista.getCooperativas().size(); i++) {
            System.out.println(lista.getCooperativas().get(i));
        }

       
    }
}