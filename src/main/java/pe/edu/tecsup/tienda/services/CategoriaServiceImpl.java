package pe.edu.tecsup.tienda.services;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;
import pe.edu.tecsup.tienda.repositories.CategoriaRepositoryImpl;

public class CategoriaServiceImpl  implements CategoriaService{

	private CategoriaRepository categoriaRepository;

	public CategoriaServiceImpl() {
		
		this.categoriaRepository = new CategoriaRepositoryImpl();
		
	}
	
	@Override
	public List<Categoria> obtenerCategorias() {

		List<Categoria> categorias 
			= this.categoriaRepository.obtenerCategorias();
		
		return categorias;
	}
	
	
}


















