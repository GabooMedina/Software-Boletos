package Menus;

public class Menus {
    
    public static MenuUsuario(Usuarios u, Asiento,)
}

    public void MenuAdministrador() {

        System.out.println("===== SOFTWARE TERMINAL TERRESTRE AMBATO ===== \n" +
                "\n === MENU DE OPCIONES ADMINISTRADOR ===\n" +
                "1.- Crear Cooperativa\n" +
                "2.- Modificar Cooperativa\n" +
                "3.- Eliminar Cooperativa\n" +
                "4.- Crear Ruta\n" +
                "5.- Modificar Ruta\n" +
                "6.- Eliminar Ruta\n"+
                "7.- Reseteo Asientos");
        int opcion = escaner.ingreso().nextInt();

        switch (opcion) {
            case 1:

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

            case 2:

            r.cooperativasId();
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

                break;
        }

    }

}