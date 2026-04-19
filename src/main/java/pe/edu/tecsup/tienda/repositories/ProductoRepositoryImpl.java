package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
        
            // TODO
            
            
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
