package Menus;

import java.util.Scanner;

import Asientos.Asiento;
import Factura.Factura;
import GestionBoletos.Boletos;
import GestionBoletos.CompraBoleto;
import GestionCooperativa.IngresoCoperativas;
import GestionRutas.IngresoRutas;
import GestionUsusarios.Usuario;
import GestionUsusarios.gestionUsuarios;
import Utilitarios.Ingresos;
import Utilitarios.Restricciones;

public class Menus {

    Ingresos escaner = new Ingresos();
    IngresoCoperativas i = new IngresoCoperativas();
    IngresoRutas rutas = new IngresoRutas();
    Restricciones r = new Restricciones();
    String respuesta;

    public void MenuUsuario(Usuario u, Asiento a, Boletos b, Factura f) {
        Restricciones r = new Restricciones();
        Scanner coso = new Scanner(System.in);
        String num;
        int dato;
        System.out.println("\t\tLogin");
        System.out.println("--------------------------------------");
        System.out.println("1.- Comprar Boleto\n2.- Cancelar compra\n3.- Cambiar contraseña\n4.- Salir");
        System.out.println("--------------------------------------");
        System.out.println("Seleccione una de las opciones");
        num = coso.next();
        if (r.controlNum(num)) {
            dato = Integer.parseInt(num);
            switch (dato) {
                case 1:
                    CompraBoleto boleto = new CompraBoleto();
                    boleto.impresionRutas();
                    boleto.compraTicket(u, a, b, f);
                    break;
                case 2:
                    f.CancelarCompra(u, a, b, f);
                    break;
                case 3:
                    gestionUsuarios cont = new gestionUsuarios();
                    cont.MenuCambioContraseña(u, a, b, f);
                    break;
                case 4:
                    System.out.println("Gracias por ocupar el programa\nAdios");
                    break;
                default:
                    System.out
                            .println(
                                    "El dato ingresado no esta dentro del rango de opciones\n Por favor ingrese un valor válido");
                    MenuUsuario(u, a, b, f);
            }
        } else if (!r.controlNum(num)) {
            System.out.println("El dato ingresado debe ser de tipo númerico\nPor favor ingrese la opcion nuevamente");
            MenuUsuario(u, a, b, f);
        }
    }

    public void MenuAdministrador() {

        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ADMINISTRADOR ===\n" +
                "1.- Crear Cooperativa\n" +
                "2.- Modificar Cooperativa\n" +
                "3.- Eliminar Cooperativa\n" +
                "4.- Crear Ruta\n" +
                "5.- Modificar Ruta\n" +
                "6.- Eliminar Ruta\n" +
                "7.- Reseteo Asientos");
        int opcion = escaner.ingreso().nextInt();

        switch (opcion) {
            case 1:
                i.MenuingresoCooperativa();
                MenuAdministrador();
                do{
                    System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if(!r.controlSI(respuesta)){
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    }else if(respuesta.equals("SI")){
                        i.MenuingresoCooperativa();
                        MenuAdministrador();
                    }else if(respuesta.equals("NO")){
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                }while(!r.controlSI(respuesta));
                break;

            case 2:
                rutas.cooperativasId();
                i.MenuModificarCooperativa();
                do{
                    System.out.println("Desea Modificar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if(!r.controlSI(respuesta)){
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    }else if(respuesta.equals("SI")){
                        rutas.cooperativasId();
                        i.MenuModificarCooperativa();
                    }else if(respuesta.equals("NO")){
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                }while(!r.controlSI(respuesta));

                break;

            case 3:
                    rutas.cooperativasId();
                    i.menueliminarCooperativa();
                    do{
                        System.out.println("Desea Eliminar mas Cooperativas? [Si/No]");
                        respuesta = escaner.ingreso().next().toUpperCase();
                        if(!r.controlSI(respuesta)){
                            System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                        }else if(respuesta.equals("SI")){
                            rutas.cooperativasId();
                            i.menueliminarCooperativa();;
                        }else if(respuesta.equals("NO")){
                            System.out.println("Saliendo de la opción");
                            MenuAdministrador();
                        }
                    }while(!r.controlSI(respuesta));
                
            case 4:

                do {
                    rutas.cooperativasId();
                    System.out.println("Desea Agregar una Nueva Ruta? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    rutas.MenucrearRuta(opcion, respuesta);
                } while (respuesta.equals("SI"));

                break;

            case 5:

                do {
                    rutas.cooperativasId();
                    rutas.menuModificarRuta();
                } while (respuesta.equals("SI"));

                break;

            case 6:

                do {
                    rutas.cooperativasId();
                    rutas.MenudeleteRuta();
                } while (respuesta.equals("SI"));

                break;

            default:
                System.out.println("==== ERROR OPCION NO VALIDA ..|..===");

        }

    }

}