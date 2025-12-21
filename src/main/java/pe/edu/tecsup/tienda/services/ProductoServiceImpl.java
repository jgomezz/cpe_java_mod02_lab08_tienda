package pe.edu.tecsup.tienda.services;

import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;
import pe.edu.tecsup.tienda.repositories.ProductoRepositoryImpl;

public class ProductoServiceImpl implements ProductoService {
	
	private static final Logger log 
		= Logger.getLogger(ProductoServiceImpl.class);
	
	ProductoRepository productoRepository;

	
	public ProductoServiceImpl() {
		this.productoRepository = new ProductoRepositoryImpl();
	}


	@Override
	public List<Producto> obtenerProductos() {
    	
		log.info("Llamada al servicio");
    	
		List<Producto> productos 
			= this.productoRepository.obtenerProductos();
				
		return productos;
		
	}

}
