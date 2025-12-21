package pe.edu.tecsup.tienda.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    final static String URL = "jdbc:mariadb://localhost/tienda";
    final static String USER = "root";
    final static String PASSWORD = "root";

    public static Connection obtenerConexion() throws Exception {

        // Cargar el driver
        Class.forName("org.mariadb.jdbc.Driver");

        // Conectarme a la Base de datos
        Connection con = DriverManager.getConnection(URL,USER,PASSWORD);

        return con;
    }
}
