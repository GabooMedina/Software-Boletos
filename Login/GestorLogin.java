package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import BaseDatos.Conexion;
import GestionCooperativa.IngresoCoperativas;
import GestionRutas.IngresoRutas;
import GestionUsusarios.gestionUsuarios;
import GestionBoletos.CompraBoleto;

public class GestorLogin {
    Scanner teclado = new Scanner(System.in);
    gestionUsuarios gestorUsuarios = new gestionUsuarios();
    IngresoCoperativas ingresoCooperativa = new IngresoCoperativas();
    IngresoRutas ingresoRutas = new IngresoRutas();
    Conexion conexion = new Conexion();
    PreparedStatement insercion;
    Connection conectar =conexion.getConexion();
    String opcion, instrucciones;
    Resultset rs;

    public void ejecucion() {
        do {
            menuPrincipal();
            opcion = teclado.next();
            switch (opcion) {
                case "1":

                    break;
                case "2":
                    registroUsuario();
                    break;
                case "3":
                    recuperarUsuario();
                    break;
                case "4":
                    recuperarContraseña();
                    break;
            }
        } while (!opcion.equals("5"));
    }
    
    public void selecionMenu() {     

        try {
            instrucciones = "SELECT * FROM Usuarios WHERE admin = '" + 1 +"'";
            insercion = conectar.prepareStatement(instrucciones);
            rs = (Resultset) insercion.executeQuery();   

            if(rs.next()){
                //Pedir ayuda 
            }

        } catch (SQLException e) {
            System.out.println(" === ERROR EN BD ===");
        }
    }

    public void menuPrincipal() {
        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.- Iniciar Sesion\n" +
                "2.- Registrarse\n" +
                "3.- Olvide mi usuario\n" +
                "4.- Olvide mi contraseña\n" +
                "5.- Salir");
    }

    public void menuInicioSesionAdmin() {

        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.- Crear Cooperativa\n" +
                "2.- Modificar Cooperativa\n" +
                "3.- Eliminar Cooperativa\n" +
                "4.- Crear Ruta\n" +
                "5.- Modificar Ruta\n" +
                "6.- Eliminar Ruta\n" +
                "10.- Salir");

    }

    public void menuInicioSesionUsuario() {
        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ===\n" +
                "1.- Comprar Boletos\n"+
                "2.- Cambiar mi contraseña");
    }

    public void usuario(){
        do {
            menuInicioSesionUsuario();
            opcion = teclado.next();
            switch (opcion) {
                case "1":
                    crearCooperativa();
                    break;
                case "2":
                    CambioContraseña();
                    break;
            }
        } while (!opcion.equals("3"));
    }

    public void admin() {
        do {
            menuInicioSesionAdmin();
            opcion = teclado.next();
            switch (opcion) {
                case "1":
                    crearCooperativa();
                    break;
                case "2":
                    modificarCooperativa();
                    break;
                case "3":
                    eliminarCooperativa();
                    break;
                case "4":
                    crearRuta();
                    break;
                case "5":
                    modificarRuta();
                    break;
                case "6":
                    eliminarRuta();
                    break;
            }
        } while (!opcion.equals("7"));
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

    public void modificarCooperativa() {
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
            ingresoCooperativa.modificarCooperativa(cnombre, cdireccion, cemail, ctelefono, id);
            System.out.println("Desea Ingresar mas Cooperativas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }

    public void eliminarCooperativa() {
        do {
            System.out.println("Ingrese el Nombre de la Cooperativa a Eliminar");
            String enombre = teclado.next();
            ingresoCooperativa.eliminarCooperativa(enombre);
            System.out.println("Desea Eliminar mas Cooperativas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }

    public void crearRuta() {
        do {
            System.out.println("Ingrese el Nombre de la Cooperativa para la Nueva Ruta");
            String cooperativa = teclado.next();
            System.out.println("Ingrese el Origen de la Nueva Ruta");
            String origen = teclado.next();
            System.out.println("Ingrese el Destino para la Nueva Ruta");
            String destino = teclado.next();
            System.out.println("Ingrese el Horario para la Nueva Ruta");
            String horario = teclado.next();
            ingresoRutas.ingresoRuta(cooperativa, origen, destino, horario);
            System.out.println("Desea Agregar una Nueva Ruta? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }
    
    public void modificarRuta(){
        do {
            System.out.println("Ingrese el Id de la Ruta a Cambiar");
            Integer id_Ruta = teclado.nextInt();
            System.out.println("Ingrese el Cambio de Nombre de la Cooperativa");
            String cambioNombre = teclado.next();
            System.out.println("Ingrese el Cambio de Origen de la Ruta");
            String cambioOrigen = teclado.next();
            System.out.println("Ingrese el Cambio de Destino de la Ruta");
            String cambioDestino = teclado.next();
            System.out.println("Ingrese el Horario de la Ruta a Modificar");
            String horario = teclado.next();
            ingresoRutas.modificarRuta(cambioNombre, cambioOrigen, cambioDestino,horario, id_Ruta);
            System.out.println("Desea Modificar mas Rutas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }

    public void eliminarRuta() {
        do {
            System.out.println("Ingrese el Id de la Ruta a Eliminar");
            Integer id_Ruta = teclado.nextInt();
            ingresoRutas.deleteRuta(id_Ruta);
            System.out.println("Desea Eliminar mas Rutas? [Si/No]");
            opcion = teclado.next().toUpperCase();
        } while (opcion.equals("SI"));
    }

    public void registroUsuario() {
        gestorUsuarios.MenuCreacionUsuario();
    }

    public void recuperarUsuario() {
        gestorUsuarios.MenuRecuperacionUsuario();
    }

    public void recuperarContraseña() {
        gestorUsuarios.MenuRecuperacionContraseña();
    }

    public void CambioContraseña() {
        gestorUsuarios.MenuCambioContraseña();
    }

    public void CompraBoleto(){
        //Falta la compra de los boletos
    }

    
}