package pe.edu.tecsup.tienda.services;

import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;
import pe.edu.tecsup.tienda.repositories.CategoriaRepositoryImpl;

public class CategoriaServiceImpl implements CategoriaService {

	private static final Logger log 
		= Logger.getLogger(CategoriaServiceImpl.class);
	
	
	/**
	 * 
	 */
	private CategoriaRepository categoriaRepository;
	
	
	/**
	 * 
	 */
	public CategoriaServiceImpl() {
		
		this.categoriaRepository = new CategoriaRepositoryImpl();
	}
	
	
	@Override
	public List<Categoria> obtenerCategorias() {

		log.info("Llamada al servicio obtenerCategorias()...! ");
		
		List<Categoria> categorias 
			= this.categoriaRepository.obtenerCategoria();
	
		return categorias;
	
	}

}
