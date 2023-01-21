package GestionUsusarios;

import java.util.Scanner;
public class gestionUsuarios {
    Usuario usuario;
    
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

    public boolean RecuperacionUsuario(){
        Scanner coso=new Scanner(System.in);
        String corr;
        System.out.println("Ingrese su correo");
        corr=coso.next();
        if(usuario.getCorreo().equals(corr)){
            System.out.println(usuario.getNombreUsuario());
            return true; 
        }
        System.out.println("El correo ingresado no existe");
        return false;
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
