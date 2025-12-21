package pe.edu.tecsup.tienda.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBD {

	/*
    final static String URL = "jdbc:mariadb://localhost/tienda";
    final static String USER = "root";
    final static String PASSWORD = "root";

    public static Connection obtenerConexion() throws Exception {

        // Cargar el driver
        Class.forName("org.mariadb.jdbc.Driver");

        // Conectarme a la Base de datos
        Connection con = DriverManager.getConnection(URL,USER,PASSWORD);

        return con;
    }*/
	
	public static Connection obtenerConexion() throws Exception {


		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext.lookup("jdbc/tienda");
			con = datasource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	
}
