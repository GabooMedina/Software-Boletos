package Menus;

import java.util.Scanner;

import Asientos.Asiento;
import GestionBoletos.Boletos;
import GestionBoletos.CompraBoleto;
import GestionUsusarios.Usuario;
import Utilitarios.Restricciones;

public class Menus {
CompraBoleto boleto;

    public void MenuUsuario(Usuario u, Asiento a, Boletos b) {
        Restricciones r = new Restricciones();
        int dato;
        Scanner coso = new Scanner(System.in);
        String num;
        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO =====");
        System.out.println("--------------------------------------");
        System.out.println("1.- Comprar boleto\n2.- Cancelacion de Compra\n3.- Cambio de contraseña\n4.- Salir");
        System.out.println("--------------------------------------");
        System.out.println("Seleccione una de las opciones");
        num=coso.next();
        if (r.controlNum(num)) {
            dato = Integer.parseInt(num);
            switch (dato) {
              case 1:
                boleto.impresionRutas();
                boleto.compraTicket();
                MenuUsuario(u, a, b);
                break;
              case 2:

              break;
              case 3:

                break;
              case 4:

                break;
      
              default:
                System.out.println("El dato ingresado no esta dentro del rango de opciones\n Por favor ingrese un valor válido");
                MenuUsuario(u, a, b);
            }
          } else if (!r.controlNum(num)) {
            System.out.println("El dato ingresado debe ser de tipo númerico\nPor favor ingrese la opcion nuevamente");
            MenuUsuario(u, a, b);
          }
    }
}
