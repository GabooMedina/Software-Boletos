package GestionBoletos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BaseDatos.Conexion;
public class CompraBoleto {
    
    Conexion conexion = new Conexion();
    Connection c = conexion.getConexion();
    private String sql = "SELECT * FROM Rutas";
    PreparedStatement p;
    ResultSet r;


    public void impresionRutas(){
        Conexion c=new Conexion(); 
        Connection co=c.getConexion();
           
                try {
                    
                    c.setP(co.prepareStatement(sql));
                    conexion.setRs(conexion.getP().executeQuery());
                    while (conexion.getRs().next()) {
                        System.out.println("Coperativas: "+conexion.getRs().getString("Cooperativa"));
                        System.out.println("Origen: "+conexion.getRs().getString("Origen"));
                        System.out.println("Destino: "+conexion.getRs().getString("Destino"));
                        System.out.println("Horario: "+conexion.getRs().getString("Horario"));
                    }
                    

            } catch (SQLException e) {
                System.out.println(e);
               
            }
        

    }

    

}
