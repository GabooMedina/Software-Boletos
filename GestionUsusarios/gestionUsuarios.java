package GestionUsusarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
        /*if(cor.isEmpty()|| nom.isEmpty()|| ape.isEmpty()||nomUsu.isEmpty()||cont.isEmpty()){
            System.out.println("No debe dejar ninguna opcion en blanco");
            return MenuCreacionUsuario();
        }
        if(!cor.isEmpty())
            usuario.correo=cor;
        if(!nom.isEmpty())
            usuario.nombre=nom.toUpperCase();
        if(!ape.isEmpty())
            usuario.apellido=ape.toUpperCase();
        if(!nomUsu.isEmpty())
            usuario.nombreUsuario=nomUsu;
        if(!cont.isEmpty())
            usuario.contraseña=cont;
        System.out.println("Usuario Creado");
        return true;*/
    }

    public boolean RecuperacionUsuario(){
        Connection co=c.getConexion();
        Scanner coso=new Scanner(System.in);
        String corr;
        System.out.println("Ingrese su correo");
        corr=coso.next();
        try {
            this.setInstrucciones("SELECT * FROM Usuarios where correo=?");
            setP(co.prepareStatement(this.getInstrucciones()));
            this.getP().setString(1, corr);
            this.setRs(this.getP().executeQuery());
            ResultSet usua=this.getRs();
            String nomus=usua.;
            System.out.println(nomus);
            return true;

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
        /*if(usuario.getCorreo().equals(corr)){
            System.out.println(usuario.getNombreUsuario());
            return true; 
        }
        System.out.println("El correo ingresado no existe");
        return false;*/
    }

    public boolean RecuperacionContraseña(){
        Scanner coso=new Scanner(System.in);
        String corr;
        System.out.println("Ingrese su correo");
        corr=coso.next();
        if(usuario.getCorreo().equals(corr)){
            System.out.println(usuario.getContraseña());
            return true; 
        }
        System.out.println("El correo ingresado no existe");
        return false;
    }

    public boolean CambioContraseña(){
        Scanner coso=new Scanner(System.in);
        String cont1,cont2,nuecont;
        System.out.println("Ingrese su contraseña actual");
        cont1=coso.next();
        System.out.println("Ingrese otra vez su contraseña actual");
        cont2=coso.next();
        if(usuario.getContraseña().equals(cont1)&&usuario.getContraseña().equals(cont2)){
            System.out.println("Ingrese su nueva contraseña");
            nuecont=coso.next();
            usuario.setContraseña(nuecont);
            return true; 
        }
        System.out.println("Las contraseñas no coinciden");
        return false;
    }
}
