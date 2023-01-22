import java.util.Scanner;

import GestionCooperativa.IngresoCoperativas;
import Utilitarios.Ingresos;

public class Principal {
    public static void main(String[] args) {
        Ingresos escaner = new Ingresos();
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

               

                
                

                break;
            default:
                break;
        }
    }
}