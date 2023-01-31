package GestionRutas;

import BaseDatos.Conexion;
import GestionCooperativa.Cooperativa;
import Utilitarios.Ingresos;
import Utilitarios.Restricciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Asientos.gestionAsiento;

public class IngresoRutas {
    
    Conexion conexion = new Conexion();
    PreparedStatement p;
    String instrucciones;
    ResultSet rs;
    
    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement getP() {
        return p;
    }

    public void setP(PreparedStatement p) {
        this.p = p;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void MenucrearRuta() {
        Ingresos escaner=new Ingresos();
    Cooperativa cop=new Cooperativa();
    String respuesta;
    Restricciones r=new Restricciones();
    gestionAsiento asiento=new gestionAsiento();
        cooperativasId();
        Connection c = conexion.getConexion();
        System.out.println("Ingrese el id de la Cooperativa a la que quiere asociar la nueva ruta");
        String id = escaner.ingreso().next();
        if (r.controlNum(id)) {
            try {
                conexion.setP(c.prepareStatement("SELECT *FROM Cooperativas WHERE Id" + id + "'"));
                conexion.setRs(conexion.getP().executeQuery());
                if (conexion.getRs().next()) {
                    String nombre=conexion.getRs().getString("Nombre");
                    System.out.println("Ingrese el Origen de la Nueva Ruta");
                    String origen = escaner.ingreso().next();
                    System.out.println("Ingrese el Destino para la Nueva Ruta");
                    String destino = escaner.ingreso().next();
                    System.out.println("Ingrese el Horario para la Nueva Ruta");
                    String horario = escaner.ingreso().next();
                    System.out.println("Ingrese el Precio para la Nueva Ruta");
                    Double precio = escaner.ingreso().nextDouble();
                    c.close();
                    ingresoRuta(Integer.parseInt(id), nombre, origen, destino, horario, precio);
                }else{
                    System.out.println("El valor ingresado no concuerda con los id's\nPorfavor vuelvalo a ingresar");

                    MenucrearRuta();
                }
            } catch (SQLException e) {
                System.out.println(" === ERROR DE INGRESO EN BD ===");
            }
        }else{
            System.out.println("Solo se pueden ingresar valores númericos\nPor favor vuelva a ingresarlos");
            MenucrearRuta();
        }

    }

    public boolean ingresoRuta(int id, String nombre, String origen, String destino, String horario, Double precio) {
        Ingresos escaner=new Ingresos();
    Cooperativa cop=new Cooperativa();
    String respuesta;
    Restricciones r=new Restricciones();
    gestionAsiento asiento=new gestionAsiento();
        Connection c = conexion.getConexion();
        try {
            conexion.setP(
                    c.prepareStatement(
                            "INSERT INTO Rutas (idCooperativa, Cooperativa, Origen, Destino, Horario, Precio) VALUES (?,?,?,?,?,?)"));
            conexion.getP().setInt(1, id);
            conexion.getP().setString(2, nombre);
            conexion.getP().setString(3, origen);
            conexion.getP().setString(4, destino);
            conexion.getP().setString(5, horario);
            conexion.getP().setDouble(6, precio);
            conexion.getP().executeUpdate();
            c.close();
            asiento.generarAsientos(id);
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }finally {
            try {
                if (conexion.getRs() != null) {
                    conexion.getRs().close();
                }
                if (conexion.getP() != null) {
                    conexion.getP().close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                System.out.println(" === ERROR DE INGRESO EN BD ===");
            }
        }

        return true;
    }

    public boolean cooperativasId() {
        Connection c = conexion.getConexion();
        try {
            this.setInstrucciones("SELECT * FROM Cooperativas");
            this.setP(c.prepareStatement(this.getInstrucciones()));
            this.setRs(this.getP().executeQuery());
            System.out.printf("Id\tCooperativa\t\n");
            while (this.rs.next()) {
                System.out.println("___________________________________________");
                System.out.printf(this.rs.getInt("Id") + "\t" +this.rs.getString("Nombre") + "\n");
            }
            c.close();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }

        return false;

    }
    //Colocar controles en esta
    public boolean menuModificarRuta() {
        Ingresos escaner=new Ingresos();
    Cooperativa cop=new Cooperativa();
    String respuesta;
    Restricciones r=new Restricciones();
    gestionAsiento asiento=new gestionAsiento();
        cooperativasId();
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
        return modificarRuta(cambioNombre, cambioOrigen, cambioDestino, horario, id_Ruta);

    }

    public boolean modificarRuta(String nombre, String origen, String destino, String horario, int id) {
        Connection c = conexion.getConexion();
        try {
            conexion.setP(c.prepareStatement(
                    "UPDATE Rutas SET Cooperativa = ? , Origen = ? , Destino = ?, Horario = ? WHERE Id_Rutas = " + id));
            conexion.getP().setString(1, nombre);
            conexion.getP().setString(2, origen);
            conexion.getP().setString(3, destino);
            conexion.getP().setString(4, horario);
            conexion.getP().executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
            System.out.println(e.getMessage());

        }

        return true;
    }

    public void MenudeleteRuta() {
        Ingresos escaner=new Ingresos();
    Cooperativa cop=new Cooperativa();
    String respuesta;
    Restricciones r=new Restricciones();
    gestionAsiento asiento=new gestionAsiento();
        cooperativasId();
        System.out.println("Ingrese el Id de la Ruta a Eliminar");
        String id_Ruta = escaner.ingreso().next();
        if(r.controlNum(id_Ruta)){
            deleteRuta(Integer.parseInt(id_Ruta));
        }else if(!r.controlNum(id_Ruta)){
            System.out.println("El valor ingresado debe ser númerico\nPorfavor vuelvalo a ingresar");
            MenudeleteRuta();
        }
    }

    public boolean deleteRuta(int id_Rutas) {
        Connection c = conexion.getConexion();
        try {
            conexion.setP(c.prepareStatement("SELECT *FROM Rutas WHERE Id_Rutas" + id_Rutas + "'"));
                conexion.setRs(conexion.getP().executeQuery());
                if (conexion.getRs().next()) {
                    try {
                        conexion.setP(c.prepareStatement("DELETE FROM Rutas WHERE Id_Rutas = '" + id_Rutas + "'"));
                        conexion.getP().executeUpdate();
                        c.close();
                    } catch (SQLException e) {
                        System.out.println(" === ERROR DE INGRESO EN BD ===");
                        System.out.println(e.getMessage());
                        
                    }
                }else{
                    System.out.println("El valor ingresado no concuerda con los id's\nPorfavor vuelvalo a ingresar");
                    MenudeleteRuta();
                }

        } catch (SQLException e) {
            System.out.println(" === ERROR DE INGRESO EN BD ===");
        }
        
        return true;
    }

}
