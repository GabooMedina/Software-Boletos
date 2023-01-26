package Login;
import java.util.Scanner;

import GestionCooperativa.IngresoCoperativas;
import GestionUsusarios.gestionUsuarios;

public class GestorLogin {
    Scanner teclado = new Scanner(System.in);
    gestionUsuarios gestorUsuarios = new gestionUsuarios();
    IngresoCoperativas ingresoCooperativa = new IngresoCoperativas();
    String opcion;

    public void ejecucion() {
        do {
            menuPrincipal();
            opcion = teclado.next();
            switch (opcion) {
                case "1": 
                    
                    break;
                case "2": registroUsuario(); 
                break;
                case "3": recuperarUsuario();   
                break;
                case "4": recuperarContraseña();
                break;
            }
        } while (!opcion.equals("5"));
    }
    public void menuPrincipal(){
        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.- Iniciar Sesion\n" +
                "2.- Registrarse\n" +
                "3.- Olvide mi usuario\n" +
                "4.- Olvide mi contraseña\n"+
                "5.- Salir");
    }

    public void menuInicioSesionAdmin(){

        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.- Crear Cooperativa\n" +
                "2.- Modificar Cooperativa\n" +
                "3.- Eliminar Cooperativa\n");

    }

    public void menuInicioSesionUsuario(){

    }

    public void admin(){
        do {
            menuInicioSesionAdmin();
            opcion = teclado.next();
            switch (opcion) {
                case "1": crearCooperativa();
                    
                    break;
                case "2": modificarCooperativa();; 
                break;
                case "3": eliminarCooperativa();   
                break;
            }
        } while (!opcion.equals("5"));
    }

    public void crearCooperativa() {
        do {
            System.out.println("Ingrese el Nombre de la Cooperativa");
            String nombre = teclado.next();
            System.out.println("Ingrese la Direccion de la Cooperativa");
            String direccion = teclado.next();
            System.out.println("Ingrese el Email de la Cooperativa");
            String email = teclado.next();
            System.out.println("Ingrese el Telefono de la Cooperativa");
            String telefono = teclado.next();
            ingresoCooperativa.ingresoCooperativa(nombre, direccion, email, telefono);
            System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }

    public void modificarCooperativa(){
        do {
            System.out.println("Ingrese el Id de la Cooperativa a Cambiar");
            Integer id = teclado.nextInt();
            System.out.println("Ingrese el Cambio de Nombre de la Cooperativa");
            String cnombre = teclado.next();
            System.out.println("Ingrese el Cambio de Direccion de la Cooperativa");
            String cdireccion = teclado.next();
            System.out.println("Ingrese el Cambio de Email de la Cooperativa");
            String cemail = teclado.next();
            System.out.println("Ingrese el Cambio de Telefono de la Cooperativa");
            String ctelefono = teclado.next();
            ingresoCooperativa.modificarCooperativa( cnombre, cdireccion, cemail, ctelefono, id);
            System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }

    public void eliminarCooperativa(){
        do {
            System.out.println("Ingrese el Nombre de la Cooperativa a Eliminar");
            String enombre = teclado.next();
            ingresoCooperativa.eliminarCooperativa(enombre);
            System.out.println("Desea Eliminar mas Cooperativas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }
    public void registroUsuario(){
        gestorUsuarios.MenuCreacionUsuario();
    }

    public void recuperarUsuario(){
        gestorUsuarios.RecuperacionUsuario();
    }
    public void recuperarContraseña(){
        gestorUsuarios.RecuperacionContraseña();
    }
}