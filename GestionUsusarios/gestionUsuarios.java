package GestionUsusarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import BaseDatos.Conexion;
public class gestionUsuarios {
    Usuario usuario;
    Conexion c=new Conexion();
    PreparedStatement p;
    String instrucciones;
    ResultSet rs;
    
    
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
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

    public boolean MenuCreacionUsuario(){
        Scanner coso=new Scanner(System.in);
        String cor,nom,ape,nomU,cont;
        System.out.println("Ingrese un Correo");
        cor=coso.next();
        System.out.println("Ingrese un Nombre");
        nom=coso.next();
        System.out.println("Ingrese un Apellido");
        ape=coso.next();
        System.out.println("Ingrese un Nombre de Usuario");
        nomU=coso.next();
        System.out.println("Ingrese una Contraseña");
        cont=coso.next();
        return CreacionUsuario(cor,nom, ape, nomU, cont);
    }

    public boolean CreacionUsuario (String cor,String nom,String ape,String nomUsu,String cont){
        Connection co=c.getConexion();
        try {
            this.setP(co.prepareStatement("INSERT INTO Usuarios (correo,nombre,apellido,nombreUsuario,contraseña) VALUES (?,?,?,?,?)"));
            this.getP().setString(1, cor);
            this.getP().setString(2, nom);
            this.getP().setString(3, ape);
            this.getP().setString(4, nomUsu);
            this.getP().setString(5, cont);
            this.getP().executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return true;
    }

    public boolean MenuRecuperacionUsuario(){
        Scanner coso=new Scanner(System.in);
        String corr;
        System.out.println("Ingrese su correo");
        corr=coso.next();
        return RecuperacionUsuario(corr);
    }

    public boolean RecuperacionUsuario(String correo){
        Connection co=c.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Usuarios WHERE correo = '" + correo+"'");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            if(this.rs.next()){
                System.out.println("Nombre de Usuario: "+this.rs.getString("nombreUsuario"));
            }
            return true;

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return false;
    }

    public boolean MenuRecuperacionContraseña(){
        Scanner coso=new Scanner(System.in);
        String corr;
        System.out.println("Ingrese su correo");
        corr=coso.next();
        return RecuperacionContraseña(corr);
    }

    public boolean RecuperacionContraseña(String correo){
        Connection co=c.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Usuarios WHERE correo = '" + correo+"'");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            if(this.rs.next()){
                System.out.println("Contraseña: "+this.rs.getString("contraseña"));
            }
            return true;

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        return false;
    }

    public boolean MenuCambioContraseña(){
        Scanner coso=new Scanner(System.in);
        String con;
        System.out.println("Ingrese la contraseña actual");
        con=coso.next();
        return CambioContraseña(con);
    }

    public boolean CambioContraseña(String con){
        Connection co=c.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Usuarios WHERE contraseña= '"+con+"'");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            if(this.rs.next()){
                Scanner coso=new Scanner(System.in);
                String con1,con2;
                System.out.println("Ingrese la nueva contraseña");
                con1=coso.next();
                System.out.println("Repita la contraseña");
                con2=coso.next();
                if(con2.equals(con1)){
                    this.setInstrucciones("UPDATE Usuarios SET contraseña=? WHERE contraseña= '"+con+"'");
                    setP(co.prepareStatement(this.getInstrucciones()));  
                    this.getP().setString(1, con1);
                    this.getP().executeUpdate();
                }else if(!con2.equals(con1)){
                    System.out.println("Las contraseñas deben coincidir");
                    return CambioContraseña(con);
                }
            }
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
