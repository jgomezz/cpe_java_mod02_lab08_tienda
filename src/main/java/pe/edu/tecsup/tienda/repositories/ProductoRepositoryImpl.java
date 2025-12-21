package pe.edu.tecsup.tienda.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Producto;


public class ProductoRepositoryImpl implements ProductoRepository {

	private static final Logger log 
	= Logger.getLogger(ProductoRepositoryImpl.class);

	@Override
	public List<Producto> obtenerProductos() {
		
    	log.info("Llamada al repositorio");

    	List<Producto> productos = new ArrayList<Producto>();
		
		return productos;
	}

}
