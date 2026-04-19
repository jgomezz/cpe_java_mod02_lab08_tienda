package pe.edu.tecsup.tienda.services;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.repositories.ProductoRepository;
import pe.edu.tecsup.tienda.repositories.ProductoRepositoryImpl;

public class ProductoServiceImpl implements ProductoService {

	private static final Logger log 
		= Logger.getLogger(ProductoServiceImpl.class);

	private ProductoRepository productoRepository;

	public ProductoServiceImpl() {
		
		this.productoRepository = new ProductoRepositoryImpl();
	}
	
}
