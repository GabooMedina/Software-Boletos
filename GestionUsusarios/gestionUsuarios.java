package GestionUsusarios;

import java.util.Scanner;

public class gestionUsuarios {
    
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
        Usuario usuario=new Usuario();
        if(cor.isEmpty()|| nom.isEmpty()|| ape.isEmpty()||nomUsu.isEmpty()||cont.isEmpty()){
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
        return true;
    }

    public boolean RecuperacionUsuario(Usuario usu, String nombre)
}
