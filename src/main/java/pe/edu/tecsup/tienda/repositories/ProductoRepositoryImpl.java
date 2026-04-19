package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.utils.ConexionBD;

public class ProductoRepositoryImpl implements ProductoRepository {

	private static final Logger log = Logger.getLogger(ProductoRepositoryImpl.class);

	
	@Override
	public List<Producto> obtenerProductos() {

		log.info("Llamada al repositorio de Productos");
    	
        List<Producto> productos = new ArrayList<Producto>();
		
        try {

            // Conectarme a la Base de datos
            Connection con = ConexionBD.obtenerConexion();
        
            // Preparar la sentencia
            String sql= 
            		"""
                    // TODO   
                        
                    """;
            PreparedStatement stmt= con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                // Lee informacion de un registro de la tabla productos
                
            	Producto producto = new Producto();
            	
            	// TODO

                // Agrega el objeto a la lista
            	productos.add(producto);
            }

            rs.close();
            stmt.close();
            con.close();
            
            
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }     
        
		return productos;
	}

}
