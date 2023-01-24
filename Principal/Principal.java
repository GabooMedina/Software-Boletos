import java.util.Scanner;

import GestionCooperativa.IngresoCoperativas;
import Utilitarios.Ingresos;

public class Principal {
    public static void main(String[] args) {
        Ingresos escaner = new Ingresos();
        IngresoCoperativas i = new IngresoCoperativas();
        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.-\n" +
                "2.-\n" +
                "3.-\n" +
                "4.- Crear Cooperativa\n");
        int opcion = escaner.ingreso().nextInt();

        switch (opcion) {
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                System.out.println("Ingrese el Nombre de la Cooperativa");
                String nombre = escaner.ingreso().next();
                System.out.println("Ingrese la Direccion de la Cooperativa");
                String direccion = escaner.ingreso().next();
                System.out.println("Ingrese el Email de la Cooperativa");
                String email = escaner.ingreso().next();
                System.out.println("Ingrese el Telefono de la Cooperativa");
                String telefono = escaner.ingreso().next();
                i.ingresoCooperativa(nombre,direccion,email,telefono);

                break;
            default:
                break;
        }
    }
}