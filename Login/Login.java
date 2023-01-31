package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Asientos.Asiento;
import BaseDatos.Conexion;
import Factura.Factura;
import GestionBoletos.Boletos;
import GestionUsusarios.Usuario;
import GestionUsusarios.gestionUsuarios;
import Menus.Menus;
import Utilitarios.Restricciones;

public class Login {
  Usuario usu = new Usuario();
  gestionUsuarios gesu;
  Asiento asi = new Asiento();
  Boletos bol = new Boletos();
  Factura fac = new Factura();
  Menus men = new Menus();
  Conexion c = new Conexion();
  PreparedStatement p;
  String instrucciones;
  ResultSet rs;

  public Conexion getC() {
    return c;
  }

  public void setC(Conexion c) {
    this.c = c;
  }

  public PreparedStatement getP() {
    return p;
  }

  public void setP(PreparedStatement p) {
    this.p = p;
  }

  public String getInstrucciones() {
    return instrucciones;
  }

  public void setInstrucciones(String instrucciones) {
    this.instrucciones = instrucciones;
  }

  public ResultSet getRs() {
    return rs;
  }

  public void setRs(ResultSet rs) {
    this.rs = rs;
  }

  public boolean menuLogin() {
    Restricciones r = new Restricciones();
    Scanner coso = new Scanner(System.in);
    String num;
    int dato;
    System.out.println("\t\tLogin");
    System.out.println("--------------------------------------");
    System.out
        .println("1.- Sign in\n2.- Sign up\n3.- Recuperacion de Usuario\n4.- Recuperacion de Contraseña\n5.- Salir");
    System.out.println("--------------------------------------");
    System.out.println("Seleccione una de las opciones");
    num = coso.next();
    if (r.controlNum(num)) {
      dato = Integer.parseInt(num);
      switch (dato) {
        case 1:
          menuSignIn();
          break;
        case 2:
          gesu.MenuCreacionUsuario();
          return menuLogin();
        case 3:
          gesu.MenuRecuperacionUsuario();
          return menuLogin();
        case 4:
          gesu.MenuRecuperacionContraseña();
          return menuLogin();
        case 5:
          System.out.println("Gracias por ocupar el programa\nAdios");
          break;
        default:
          System.out
              .println("El dato ingresado no esta dentro del rango de opciones\n Por favor ingrese un valor válido");
          return menuLogin();
      }
    } else if (!r.controlNum(num)) {
      System.out.println("El dato ingresado debe ser de tipo númerico\nPor favor ingrese la opcion nuevamente");
      return menuLogin();
    }
    return false;
  }

  public boolean menuSignIn() {
    Scanner coso = new Scanner(System.in);
    String nomU, cont;
    System.out.println("Ingrese su Nombre de Usuario");
    nomU = coso.next();
    System.out.println("Ingrese su Contraseña");
    cont = coso.next();
    return signIn(nomU, cont);
  }

  public boolean signIn(String nomU, String contr) {
    Connection co = c.getConexion();
    try {
      this.setInstrucciones(
          "SELECT * FROM Usuarios WHERE nombreUsuario = '" + nomU + "' AND contraseña= '" + contr + "'");
      setP(co.prepareStatement(this.getInstrucciones()));
      this.setRs(this.getP().executeQuery());
      if (this.rs.next()) {
        usu.setId(this.rs.getInt("id"));
        usu.setNombre(this.rs.getString("nombre"));
        usu.setApellido(this.rs.getString("apellido"));
        if (this.rs.getInt("admin") == 1) {
          co.close();
          men.MenuAdministrador();
        } else {
          co.close();
          men.MenuUsuario(usu, asi, bol, fac);
        }
      } else {
        System.out
            .println("El nombre de Usuario o la Contraseña esta mal ingresado\nPor favor ingreselos correctamente");
        return menuSignIn();
      }
    } catch (SQLException e) {
      System.out.println(" === ERROR DE INGRESO EN BD ===");
    }
    return false;
  }
}
