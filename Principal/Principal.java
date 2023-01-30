import java.util.Scanner;

import GestionBoletos.CompraBoleto;
import GestionCooperativa.Cooperativa;
import GestionCooperativa.IngresoCoperativas;
import GestionRutas.IngresoRutas;
import GestionUsusarios.Usuario;
import Utilitarios.Ingresos;

public class Principal {
     
    public boolean menuUsuario(Usuario u, Asiento s){

    }
    public static void main(String[] args) {
        Ingresos escaner = new Ingresos();
        String respuesta;
        IngresoCoperativas i = new IngresoCoperativas();
        IngresoRutas r = new IngresoRutas();
        CompraBoleto b = new CompraBoleto();
        Cooperativa co = new Cooperativa();
        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.-\n" +
                "2.-\n" +
                "3.-\n" +
                "4.- Crear Cooperativa\n" +
                "5.- Modificar Cooperativa\n" +
                "6.- Eliminar Cooperativa\n" +
                "7.- Crear Ruta\n" +
                "8.- Modificar Ruta\n" +
                "9.- Eliminar Ruta\n" +
                "10.- Comprar Boletos\n"+
                "11-.Registro Compra○\n");
        int opcion = escaner.ingreso().nextInt();

        switch (opcion) {
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:
                do {
                    System.out.println("Ingrese el Nombre de la Cooperativa");
                    String nombre = escaner.ingreso().next();
                    System.out.println("Ingrese la Direccion de la Cooperativa");
                    String direccion = escaner.ingreso().next();
                    System.out.println("Ingrese el Email de la Cooperativa");
                    String email = escaner.ingreso().next();
                    System.out.println("Ingrese el Telefono de la Cooperativa");
                    String telefono = escaner.ingreso().next();
                    i.ingresoCooperativa(nombre, direccion, email, telefono);
                    System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));
                break;

            case 5:
                do {
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
                break;

            case 6:
                do {
                    System.out.println("Ingrese el Nombre de la Cooperativa a Eliminar");
                    String enombre = escaner.ingreso().next();
                    i.eliminarCooperativa(enombre);
                    System.out.println("Desea Eliminar mas Cooperativas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));

                break;

            case 7:
                do {
              r.cooperativasId();
            System.out.println("Desea Agregar una Nueva Ruta? [Si/No]");
            respuesta = escaner.ingreso().next().toUpperCase();
       
                } while (respuesta.equals("SI"));
               
                break;

            case 8:

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

            case 9:

                do {
                    System.out.println("Ingrese el Id de la Ruta a Eliminar");
                    Integer id_Ruta = escaner.ingreso().nextInt();
                    r.deleteRuta(id_Ruta);
                    System.out.println("Desea Eliminar mas Rutas? [Si/No]");
                    respuesta = escaner.ingreso().next().toUpperCase();
                } while (respuesta.equals("SI"));

                break;

            case 10:

               //b.impresionRutas();
        
              

                break;

            case 11:
            b.impresionRutas();
            b.compraTicket();

            //Instanciar objetos en el main y pasarlos como parametros e los metoods de registro

            break;

            default:
                break;
        }
    }
}