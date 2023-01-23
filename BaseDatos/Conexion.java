package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static final String usuario = "cosillo007nob";
    public static final String clave = "modelamiento2023";
    public static final String url = "jdbc:mysql://db4free.net:3306/software_boletos";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }
    
}
