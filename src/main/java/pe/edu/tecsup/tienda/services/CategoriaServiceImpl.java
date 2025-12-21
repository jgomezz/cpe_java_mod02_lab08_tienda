package pe.edu.tecsup.tienda.services;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;
import pe.edu.tecsup.tienda.repositories.CategoriaRepositoryImpl;
import org.apache.log4j.Logger;

public class CategoriaServiceImpl  implements CategoriaService{

	private CategoriaRepository categoriaRepository;

	private static final Logger log 
		= Logger.getLogger(CategoriaServiceImpl.class);
	
	public CategoriaServiceImpl() {
		
		this.categoriaRepository = new CategoriaRepositoryImpl();
		
	}
	
	@Override
	public List<Categoria> obtenerCategorias() {

    	log.info("Llamada al servicio");

		
		List<Categoria> categorias 
			= this.categoriaRepository.obtenerCategorias();
		
		return categorias;
	}
	
	
}


















