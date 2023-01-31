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
    IngresoRutas r = new IngresoRutas();

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

                break;

            case 2:
                do {
                    r.cooperativasId();
                    System.out.println("Ingrese el Id de la Cooperativa a Cambiar");
                    Integer id = escaner.ingreso().nextInt();
                    System.out.println("Ingrese el Cambio de Nombre de la Cooperativa");
                    String cnombre = escaner.ingreso().next();
                    System.out.println("Ingrese el Cambio de Direccion de la Cooperativa");
                    String cdireccion = escaner.ingreso().next();
                    System.out.println("Ingrese el Cambio de Email de la Cooperativa");
                    String cemail = escaner.ingreso().next();
                    System.out.println("Ingrese el Cambio de Telefono de la Cooperativa");
                    String ctelefono = escaner.ingreso().next();
                    i.modificarCooperativa(cnombre, cdireccion, cemail, ctelefono, id);
                    System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));
                MenuAdministrador();

                break;

            case 3:

                do {
                    System.out.println("Ingrese el Nombre de la Cooperativa a Eliminar");
                    String enombre = escaner.ingreso().next();
                    i.eliminarCooperativa(enombre);
                    System.out.println("Desea Eliminar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));

            case 4:

                do {
                    r.cooperativasId();
                    System.out.println("Desea Agregar una Nueva Ruta? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();

                } while (respuesta.equals("SI"));

                break;

            case 5:

                do {
                    System.out.println("Ingrese el Id de la Ruta a Cambiar");
                    Integer id_Ruta = escaner.ingreso().nextInt();
                    System.out.println("Ingrese el Cambio de Nombre de la Cooperativa");
                    String cambioNombre = escaner.ingreso().next();
                    System.out.println("Ingrese el Cambio de Origen de la Ruta");
                    String cambioOrigen = escaner.ingreso().next();
                    System.out.println("Ingrese el Cambio de Destino de la Ruta");
                    String cambioDestino = escaner.ingreso().next();
                    System.out.println("Ingrese el Horario de la Ruta a Modificar");
                    String horario = escaner.ingreso().next();
                    r.modificarRuta(cambioNombre, cambioOrigen, cambioDestino, horario, id_Ruta);
                    System.out.println("Desea Modificar mas Rutas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));

                break;

            case 6:

                do {
                    System.out.println("Ingrese el Id de la Ruta a Eliminar");
                    Integer id_Ruta = escaner.ingreso().nextInt();
                    r.deleteRuta(id_Ruta);
                    System.out.println("Desea Eliminar mas Rutas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));

                break;

            default:
                System.out.println("==== ERROR OPCION NO VALIDA ..|..===");

        }

    }

}