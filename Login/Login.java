package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import BaseDatos.Conexion;
import GestionUsusarios.Usuario;
import Utilitarios.Restricciones;

public class Login {
  Usuario usu=new Usuario();
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

  public boolean login() {
    Connection co=c.getConexion();
    Restricciones r = new Restricciones();
    Scanner coso = new Scanner(System.in);
    String nomU,cont;
    System.out.println("Ingrese su Nombre de Usuario");
    nomU=coso.next();
    System.out.println("Ingrese su Contraseña");
    cont=coso.next();
    try {
      
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
