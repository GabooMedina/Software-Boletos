package Menus;

import java.util.Scanner;

import Asientos.Asiento;
import Asientos.gestionAsiento;
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
    CompraBoleto boleto = new CompraBoleto();
    gestionUsuarios cont = new gestionUsuarios();
    gestionAsiento asi=new gestionAsiento();
    String respuesta;

    public void MenuUsuario(Usuario u, Asiento a, Boletos b, Factura f) {
        Restricciones r = new Restricciones();
        Scanner coso = new Scanner(System.in);
        String num;
        int dato;
        System.out.println("\t\tLogin");
        System.out.println("--------------------------------------");
        System.out.println(
                "1.- Comprar Boleto\n2.- Cancelar compra\n3.- Cambiar contraseña\n4.- Mostrar Historial de Compras\n5.- Salir");
        System.out.println("--------------------------------------");
        System.out.println("Seleccione una de las opciones");
        num = coso.next();
        if (r.controlNum(num)) {
            dato = Integer.parseInt(num);
            switch (dato) {
                case 1:
                    boleto.compraTicket(u, a, b, f);
                    MenuUsuario(u, a, b, f);
                    break;
                case 2:
                    f.CancelarCompra(u, a, b, f);
                    MenuUsuario(u, a, b, f);
                    break;
                case 3:
                    cont.MenuCambioContraseña(u, a, b, f);
                    MenuUsuario(u, a, b, f);
                    break;
                case 4:
                    f.imprimirHistorialCompras(u, a, b, f);
                    MenuUsuario(u, a, b, f);
                    break;
                case 5:
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
                do {
                    System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        i.MenuingresoCooperativa();
                        ;
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));
                break;

            case 2:
                i.MenuModificarCooperativa();
                ;
                do {
                    System.out.println("Desea Modificar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        i.MenuModificarCooperativa();
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));
                break;

            case 3:
                i.menueliminarCooperativa();
                do {
                    System.out.println("Desea Eliminar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        i.menueliminarCooperativa();
                        ;
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));

            case 4:
                rutas.MenucrearRuta();
                do {
                    System.out.println("Desea Crear otra Ruta? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        rutas.MenucrearRuta();
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));

                break;

            case 5:
                rutas.menuModificarRuta();
                do {
                    System.out.println("Desea Modificar otra Ruta? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        rutas.menuModificarRuta();
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));

                break;

            case 6:
                rutas.MenudeleteRuta();
                do {
                    System.out.println("Desea Eliminar otra Ruta? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        rutas.MenudeleteRuta();
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));

                break;

            case 7:
                asi.menuReseteoAsientos();
                do {
                    System.out.println("Desea Resetar los asientos de otra Ruta? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                    if (!r.controlSI(respuesta)) {
                        System.out.println("Solo debe ingresar SI/NO\nPor favor ingrese un valor válido");
                    } else if (respuesta.equals("SI")) {
                        rutas.menuModificarRuta();
                    } else if (respuesta.equals("NO")) {
                        System.out.println("Saliendo de la opción");
                        MenuAdministrador();
                    }
                } while (!r.controlSI(respuesta));
            break;

            default:
                System.out.println("==== ERROR OPCION NO VALIDA ..|..===");
                MenuAdministrador();

        }

    }

}